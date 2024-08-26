package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DoctorDao;
import lk.earth.earthuniversity.entity.Doctor;
import lk.earth.earthuniversity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Doctor> getAll(@RequestParam HashMap <String,String> params) {
        String clinictypeId = params.get("clinictypeid");
        String doctorgradeid = params.get("doctorgradeid");
        String degreeid = params.get("degreeid");


        List<Doctor> doctors = this.doctorDao.findAll();
        if(params.isEmpty()) return doctors;

        Stream<Doctor> doctorStream = doctors.stream();

//        if(clinictypeId != null) doctors = this.doctorDao.findAllDoctorsByCategoryId(Integer.parseInt(clinictypeId));

        if(doctorgradeid!=null) doctorStream = doctorStream.filter(e -> e.getDoctorgrade().getId() ==Integer.parseInt(doctorgradeid));
        if(clinictypeId!=null) doctorStream = doctorStream.filter(e -> e.getDoctorgrade().getId() ==Integer.parseInt(clinictypeId));
        if(degreeid!=null) doctorStream = doctorStream.filter(e -> e.getDoctordegrees().stream().filter(de-> de.getDegree().getId() == Integer.parseInt(degreeid)).isParallel());


        return  doctorStream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Doctor get(@PathVariable Integer id) {
        Doctor doctor = this.doctorDao.findByMyId(id);
        return doctor;
    }
    @GetMapping(path ="/doctorclinic/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getByClinicType(@PathVariable Integer id) {
                List<Doctor> doctor = this.doctorDao.doctorByClinicType(id);
                return doctor;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Doctor doctor){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        Integer id =  doctor.getEmployee().getId();

        if(doctorDao.findDoctorByEmployeeId(id)!=null)
            errors = errors+"<br> Existing Employee";

        if(errors==""){
            doctor.setDoregister(new Timestamp( new Date().getTime()));
            doctorDao.save(doctor);
        } else{
            errors = "Server Validation Errors : <br> "+errors;
        }

        response.put("id",String.valueOf(doctor.getId()));
        response.put("url","/doctors/"+doctor.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Doctor doctor){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

//        Doctor doc1 =  doctorDao.findByMyId(doctor.getEmployee().getId());
//
//        if(doc1!=null && doctor.getId()!=doc1.getId())
//            errors = errors+"<br> Existing Employee";

        if(errors=="") doctorDao.save(doctor);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(doctor.getId()));
        responce.put("url","/doctors/"+doctor.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Doctor doc1 = doctorDao.findByMyId(id);
        if(doc1==null)
            errors = errors+"<br> Employee Does Not Existed";

        if(errors.isEmpty()) doctorDao.delete(doc1);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/employees/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


