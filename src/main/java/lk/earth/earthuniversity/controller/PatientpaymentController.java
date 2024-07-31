package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.PatientpaymentDao;
import lk.earth.earthuniversity.dao.PatientpaymentDao;
import lk.earth.earthuniversity.entity.Patientpayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/patientpayments")
public class PatientpaymentController {

    @Autowired
    private PatientpaymentDao patientpaymentDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Patientpayment> getAll(@RequestParam HashMap <String,String> params) {

        String paytypeid = params.get("paytypeid");
        String paymentstatusid = params.get("paymentstatusid");
        String clinictypeid = params.get("clinictypeid");
        String patientnic = params.get("patientnic");
        String patientname = params.get("patientname");
        String appointmentid = params.get("appointmentid");
        String appointmentnumber = params.get("appointmentnumber");
        String date = params.get("date");


        List<Patientpayment> patientpayments = this.patientpaymentDao.findAll();
        if(params.isEmpty()) return patientpayments;

        Stream<Patientpayment> patientpaymentStream = patientpayments.stream();


        if(paytypeid!=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getPaytype().getId() ==Integer.parseInt(paytypeid));
        if(appointmentnumber!=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getAppointment().getNumber() ==Integer.parseInt(appointmentnumber));
        if(paymentstatusid!=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getPaymentstatus().getId() ==Integer.parseInt(paymentstatusid));
        if(clinictypeid !=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getAppointment().getClinic().getId() ==Integer.parseInt(clinictypeid));
        if(patientnic!=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getAppointment().getPatient().getNic().equals(patientnic));
        if(patientname!=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getAppointment().getPatient().getName().contains(patientname));
        if(appointmentid!=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getAppointment().getId() ==Integer.parseInt(appointmentid));
        if(date!=null) patientpaymentStream = patientpaymentStream.filter(a -> a.getDate().toString().equals(date));


        return  patientpaymentStream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Patientpayment get(@PathVariable Integer id) {
        Patientpayment patientpayment = this.patientpaymentDao.findByMyId(id);
        return patientpayment;
    }

    @GetMapping(path ="/countbyclinic/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Long getcount(@PathVariable Integer id) {
         return  this.patientpaymentDao.countByClinic(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Patientpayment patientpayment){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        Integer number =  patientpayment.getAppointment().getId();
//
        if(patientpaymentDao.findByAppointment(number)!= null)
            errors = errors+"<br> Existing Number";

        if(errors == ""){
            patientpayment.setDate(new Timestamp( new Date().getTime()));
            patientpaymentDao.save(patientpayment);
        }

        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(patientpayment.getId()));
        response.put("url","/patientpayments/"+patientpayment.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Patientpayment patientpayment){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Patientpayment appoint =  patientpaymentDao.findByDatetime(patientpayment.getDate());

        if(appoint!=null && patientpayment.getId()!=appoint.getId())
            errors = errors+"<br> Existing Patientpayment";

        if(errors=="") patientpaymentDao.save(patientpayment);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(patientpayment.getId()));
        responce.put("url","/patientpayments/"+patientpayment.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Patientpayment patientpayment = patientpaymentDao.findByMyId(id);
        if(patientpayment==null)
            errors = errors+"<br> Patient payment Does Not Exist";

        if(errors.isEmpty()) patientpaymentDao.delete(patientpayment);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/patientpayments/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


