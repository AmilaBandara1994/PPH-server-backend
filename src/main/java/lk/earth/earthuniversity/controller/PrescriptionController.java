package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.PrescriptionDao;
import lk.earth.earthuniversity.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionDao prescriptionDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Prescription> getAll(@RequestParam HashMap <String,String> params) {


        String prescriptionstatusid = params.get("prescriptionstatusid");
//        String date = params.get("date");
        String clinictypeid = params.get("clinictypeid");
        String appointmentnumber = params.get("appointmentnumber");
        String patientname = params.get("patientname");


        List<Prescription> prescriptions = this.prescriptionDao.findAll();
        if(params.isEmpty()) return prescriptions;

        Stream<Prescription> prescriptionstream = prescriptions.stream();

        if(prescriptionstatusid!=null) prescriptionstream = prescriptionstream.filter(obj -> obj.getPrescriptionstatus().getId() ==Integer.parseInt(prescriptionstatusid));
        if(clinictypeid !=null) prescriptionstream = prescriptionstream.filter(obj -> obj.getAppointment().getClinic().getClinictype().getId() ==Integer.parseInt(clinictypeid));
//        if(patientname!=null) prescriptionstream = prescriptionstream.filter(obj -> obj.getAppointment().getPatient().getName().toLowerCase().contains(patientname.toLowerCase()));
        if(appointmentnumber!=null) prescriptionstream = prescriptionstream.filter(obj -> obj.getAppointment().getPatient().getName().contains(appointmentnumber));

//        if(date!=null) prescriptionstream = prescriptionstream.filter(obj -> {
//
////            Calendar start = Calendar.getInstance();
////            start.setTimeInMillis( obj.getDate().getTime() );
////            return start.after(Timestamp.valueOf(date));
//
////            return  new Date(date).after(obj.getDate());
//        });

        return  prescriptionstream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Prescription get(@PathVariable Integer id) {
        Prescription prescription = this.prescriptionDao.findByMyId(id);
        return prescription;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Prescription prescription){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        if(errors == ""){

            prescription.setDate(new Timestamp( new Date().getTime()));
            prescriptionDao.save(prescription);
        }

        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(prescription.getId()));
        response.put("url","/prescriptions/"+prescription.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Prescription prescription){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        if(errors=="") prescriptionDao.save(prescription);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(prescription.getId()));
        responce.put("url","/prescriptions/"+prescription.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Prescription prescription = prescriptionDao.findByMyId(id);
        if(prescription==null)
            errors = errors+"<br> Prescription Related to this ID Does Not Exist";

        if(errors.isEmpty()) prescriptionDao.delete(prescription);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/prescriptions/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


