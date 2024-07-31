package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.EmployeeDao;
import lk.earth.earthuniversity.dao.PatientDao;
import lk.earth.earthuniversity.entity.Doctor;
import lk.earth.earthuniversity.entity.Employee;
import lk.earth.earthuniversity.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    @Autowired
    private PatientDao patientDao;

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Patient get(@PathVariable Integer id) {
        Patient patient = this.patientDao.findByMyId(id);
        return patient;
    }

    @GetMapping(produces = "application/json")
//    @PreAuthorize("hasAuthority('employee-select')")
    public List<Patient> get(@RequestParam HashMap<String, String> params) {

        List<Patient> patients = this.patientDao.findAll();

        if(params.isEmpty())  return patients;

        String patientstatusid = params.get("patientstatus");
        String genderid= params.get("genderid");
        String email= params.get("email");
        String bloodgroupid= params.get("bloodgroupid");
        String contactnumber= params.get("contactnumber");
        String nic= params.get("nic");

        Stream<Patient> patientStream = patients.stream();

        if(patientstatusid!=null) patientStream = patientStream.filter(e -> e.getPatientstatus().getId()==Integer.parseInt(patientstatusid));
        if(genderid!=null) patientStream = patientStream.filter(e -> e.getGender().getId()==Integer.parseInt(genderid));
        if(contactnumber!=null) patientStream = patientStream.filter(e -> e.getContactnumber().equals(contactnumber));
        if(email!=null) patientStream = patientStream.filter(e -> e.getEmail().equals(email));
        if(nic!=null) patientStream = patientStream.filter(e -> e.getNic().equals(nic));
        if(bloodgroupid!=null) patientStream = patientStream.filter(e -> e.getBloodgroup().getId() == Integer.parseInt(bloodgroupid));

        return patientStream.collect(Collectors.toList());

    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Patient patient){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        if(patientDao.findByContactNumber(patient.getContactnumber())!=null)
            errors = errors+"<br> Existing Number";
        if(patientDao.findByNic(patient.getNic())!=null)
            errors = errors+"<br> Existing NIC";
        if(patientDao.findByEmail(patient.getEmail())!=null)
            errors = errors+"<br> Existing Email";


        if(errors=="")
        patientDao.save(patient);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(patient.getId()));
        responce.put("url","/patient/"+patient.getId());
        responce.put("errors",errors);

        return responce;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Patient patient){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Patient patient1 = patientDao.findByContactNumber(patient.getContactnumber());
        Patient patient2 = patientDao.findByNic(patient.getNic());

        if(patient1!=null && patient.getId()!=patient1.getId())
            errors = errors+"<br> Existing Contact Number";
        if(patient2!=null && patient.getId()!=patient2.getId())
            errors = errors+"<br> Existing NIC";

        if(errors=="") patientDao.save(patient);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(patient.getId()));
        responce.put("url","/patients/"+patient.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){


        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Patient patient1 = patientDao.findByMyId(id);

        if(patient1==null)
            errors = errors+"<br> Patient Does Not Existed";

        if(errors=="") patientDao.delete(patient1);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/patients/"+id);
        responce.put("errors",errors);

        return responce;
    }

}




