package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClinicDao;
import lk.earth.earthuniversity.dao.DoctorpaymentDao;
import lk.earth.earthuniversity.entity.Clinic;
import lk.earth.earthuniversity.entity.Doctorpayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/doctorpayments")
public class DoctorpaymentController {

    @Autowired
    private DoctorpaymentDao doctorpaymentDao;

    @Autowired
    private ClinicDao clinicDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Doctorpayment> getAll(@RequestParam HashMap <String,String> params) {

        String doctorpaymenttypeid = params.get("doctorpaymenttypeid");
        String doctorpaymentstatusid = params.get("doctorpaymentstatusid");
        String clinictypeid = params.get("clinictypeid");
        String patientid = params.get("patientid");
        String number = params.get("number");
        String date = params.get("date");
        String employeeid = params.get("employeeid");


        List<Doctorpayment> doctorpayments = this.doctorpaymentDao.findAll();
        if(params.isEmpty()) return doctorpayments;

        Stream<Doctorpayment> doctorpaymentStream = doctorpayments.stream();


//        if(doctorpaymenttypeid!=null) doctorpaymentStream = doctorpaymentStream.filter(a -> a.getDoctorpaymenttype().getId() ==Integer.parseInt(doctorpaymenttypeid));
//        if(doctorpaymentstatusid!=null) doctorpaymentStream = doctorpaymentStream.filter(a -> a.getDoctorpaymentstatus().getId() ==Integer.parseInt(doctorpaymentstatusid));
//        if(clinictypeid !=null) doctorpaymentStream = doctorpaymentStream.filter(a -> a.getClinic().getId() ==Integer.parseInt(clinictypeid));
//        if(patientid!=null) doctorpaymentStream = doctorpaymentStream.filter(a -> a.getPatient().getId() ==Integer.parseInt(patientid));
//        if(number!=null) doctorpaymentStream = doctorpaymentStream.filter(a -> a.getNumber().equals(number));
//        if(employeeid!=null) doctorpaymentStream = doctorpaymentStream.filter(a -> a.getEmployee().getId() ==Integer.parseInt(employeeid));
//        if(date!=null) doctorpaymentStream = doctorpaymentStream.filter(a -> a.getDate().toString().equals(date));
//

        return  doctorpaymentStream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Doctorpayment get(@PathVariable Integer id) {
        Doctorpayment doctorpayment = this.doctorpaymentDao.findByMyId(id);
        return doctorpayment;
    }
//    @GetMapping(path ="/patientid/{id}", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Doctorpayment> getbypatientid(@PathVariable Integer id) {
//        List<Doctorpayment> doctorpayments = this.doctorpaymentDao.findByPatientId(id);
//        return doctorpayments;
//    }
//
//    @GetMapping(path ="/countbyclinic/{id}", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public Long getcount(@PathVariable Integer id) {
//         return  this.doctorpaymentDao.countByClinic(id);
//    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Doctorpayment doctorpayment){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        Clinic cl1= doctorpayment.getClinic();


        BigDecimal tvalue = cl1.getTotalincome();
//      BigDecimal income = dpay.getClinic().getTotalincome(); // Assuming getTotalincome() returns BigDecimal
        BigDecimal percentage = new BigDecimal("20").divide(new BigDecimal("100"), MathContext.DECIMAL128); // 20%
        BigDecimal amountToAdd = tvalue.multiply(percentage);


        doctorpayment.setTotal(amountToAdd);


            // Calculate the 20% of income
//            dpay.setTotal(dpay.getTotal().add(amountToAdd)); // Add it to the existing total





//            Clinic cl1= doctorpayment.getClinic();
//            int value = cl1.getTotalincome().intValue();
//            int total = value * 20/100;
//            doctorpayment.setTotal( BigDecimal.valueOf(total));
//            cl1.setTotalincome(BigDecimal.valueOf(cl1.getTotalincome().intValue() - total));

        if(doctorpayment.getDoctorpaymentstatus().getName().equals("Paid")){
//            cl1.setTotalincome(BigDecimal.valueOf(cl1.getTotalincome().intValue() - total));
            clinicDao.save(cl1);
        }
        if(errors == ""){
            doctorpayment.setDate(new Timestamp( new Date().getTime()));
            doctorpaymentDao.save(doctorpayment);
        }else{
            errors = "Server Validation Errors : <br> "+errors;
        }
        response.put("id",String.valueOf(doctorpayment.getId()));
        response.put("url","/doctorpayments/"+doctorpayment.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Doctorpayment doctorpayment){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

//        if(doctorpayment.getDoctorpaymentstatus().getName().equals("Calculated")){
            Clinic cl1= doctorpayment.getClinic();
            int value = cl1.getTotalincome().intValue();
            int total = (value * 20)/100;
            doctorpayment.setTotal(BigDecimal.valueOf(total));
//            cl1.setTotalincome(BigDecimal.valueOf(cl1.getTotalincome().intValue() - total));
//        }

            if(doctorpayment.getDoctorpaymentstatus().getName().equals("Paid")){

//            Clinic cl1= doctorpayment.getClinic();
//            int value = cl1.getTotalincome().intValue();
//            int total = value * 20/100;
////            doctorpayment.setTotal( value * 20/100);
                cl1.setTotalincome(BigDecimal.valueOf(cl1.getTotalincome().intValue() - total));
                clinicDao.save(cl1);
            }


        if(errors=="") doctorpaymentDao.save(doctorpayment);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(doctorpayment.getId()));
        responce.put("url","/doctorpayments/"+doctorpayment.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Doctorpayment doctorpayment = doctorpaymentDao.findByMyId(id);
        if(doctorpayment==null)
            errors = errors+"<br> Doctorpayment Does Not Exist";

        if(errors.isEmpty()) doctorpaymentDao.delete(doctorpayment);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/doctorpayments/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


