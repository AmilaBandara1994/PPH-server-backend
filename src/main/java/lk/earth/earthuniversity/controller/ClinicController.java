package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClinicDao;
import lk.earth.earthuniversity.entity.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/clinics")
public class ClinicController {

    @Autowired
    private ClinicDao clinicDao;


//    @GetMapping(produces = "application/json")
//    public List<Clinic> getAll() {
//        return  this.clinicDao.findAll();
//    }

    @GetMapping(produces = "application/json")
    public List<Clinic> get(@RequestParam HashMap<String, String> params) {

        List<Clinic>  clinics = this.clinicDao.findAll();

        if(params.isEmpty()) return clinics;

        String clinictype = params.get("clinictype");
        String doctorname = params.get("doctorname");
        String clinicstatus = params.get("clinicstatus");

        Stream<Clinic> clinicStream = clinics.stream();

        if(clinictype  != null) clinicStream = clinicStream.filter(clinic -> clinic.getClinictype().getName().contains(clinictype));
        if(doctorname  != null) clinicStream = clinicStream.filter(clinic -> clinic.getDoctor().getName().contains(doctorname));
        if(clinicstatus  != null) clinicStream = clinicStream.filter(clinic -> clinic.getClinicstatus().getName().contains(clinicstatus));

        return  clinicStream.collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Clinic clinic){
        System.out.println( " this is object of clinic " + clinic);

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

//        if(clinicDao.findById(clinic.getId())!=null)
//            errors = errors+"<br> Existing Clinic";
//        if(employeedao.findByNic(employee.getNic())!=null)
//            errors = errors+"<br> Existing NIC";

        System.out.println(clinic);

        if(errors=="")
            clinicDao.save(clinic);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(clinic.getId()));
        responce.put("url","/clinics/"+clinic.getId());
        responce.put("errors",errors);

        return responce;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Clinic clinic){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

//        Optional<Clinic> clinic1 = clinicDao.findById(clinic.getId());
//        Employee emp2 = employeedao.findByNic(employee.getNic());

//        if(clinic1!=null )
//            errors = errors+"<br> Clinic Already Exist ";
//        if(emp2!=null && employee.getId()!=emp2.getId())
//            errors = errors+"<br> Existing NIC";

        if(errors=="") clinicDao.save(clinic);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(clinic.getId()));
        responce.put("url","/clinic/"+clinic.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){

        System.out.println(id);

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Clinic clinic = clinicDao.findByMyId(id);

        if(clinic==null)
            errors = errors+"<br> Clinic  Does Not Existed";

        if(errors=="") clinicDao.delete(clinic);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/clinic/"+id);
        responce.put("errors",errors);

        return responce;
    }






//    @GetMapping(path ="/list",produces = "application/json")
//    public List<Doctor> get() {
//
//        List<Doctor> doctors = this.doctorDao.findAll();
//
//        doctors = doctors.stream().map(
//                doctor -> { Doctor d = new Doctor();
//                            d.setId(doctor.getId());
//                            d.setName(doctor.getName());
//                            return d; }
//        ).collect(Collectors.toList());
//
//        return doctors;
//
//    }

}


