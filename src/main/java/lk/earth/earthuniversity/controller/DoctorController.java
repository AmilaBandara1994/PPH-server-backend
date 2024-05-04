package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DoctorDao;
import lk.earth.earthuniversity.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;


    @GetMapping(produces = "application/json")
    public List<Doctor> getAll() {
        return  this.doctorDao.findAll();
    }
//
//    @GetMapping(path ="/list",produces = "application/json")
//    public List<Employee> get() {
//
//        List<Employee> employees = this.employeedao.findAllNameId();
//
//        employees = employees.stream().map(
//                employee -> {
//                    Employee e = new Employee(employee.getId(), employee.getCallingname());
//                    return  e;
//                }
//        ).collect(Collectors.toList());
//
//        return employees;
//
//    }
//
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
////    @PreAuthorize("hasAuthority('Employee-Insert')")
//    public HashMap<String,String> add(@RequestBody Employee employee){
//
//        HashMap<String,String> responce = new HashMap<>();
//        String errors="";
//
//        if(employeedao.findByNumber(employee.getNumber())!=null)
//            errors = errors+"<br> Existing Number";
//        if(employeedao.findByNic(employee.getNic())!=null)
//            errors = errors+"<br> Existing NIC";
//
//        System.out.println(employee.getDoassignment());
//
//        if(errors=="")
//            employeedao.save(employee);
//        else errors = "Server Validation Errors : <br> "+errors;
//
//        responce.put("id",String.valueOf(employee.getId()));
//        responce.put("url","/employees/"+employee.getId());
//        responce.put("errors",errors);
//
//        return responce;
//    }
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.CREATED)
////    @PreAuthorize("hasAuthority('Employee-Update')")
//    public HashMap<String,String> update(@RequestBody Employee employee){
//
//        HashMap<String,String> responce = new HashMap<>();
//        String errors="";
//
//        Employee emp1 = employeedao.findByNumber(employee.getNumber());
//        Employee emp2 = employeedao.findByNic(employee.getNic());
//
//        if(emp1!=null && employee.getId()!=emp1.getId())
//            errors = errors+"<br> Existing Number";
//        if(emp2!=null && employee.getId()!=emp2.getId())
//            errors = errors+"<br> Existing NIC";
//
//        if(errors=="") employeedao.save(employee);
//        else errors = "Server Validation Errors : <br> "+errors;
//
//        responce.put("id",String.valueOf(employee.getId()));
//        responce.put("url","/employees/"+employee.getId());
//        responce.put("errors",errors);
//
//        return responce;
//    }
//
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public HashMap<String,String> delete(@PathVariable Integer id){
//
//        System.out.println(id);
//
//        HashMap<String,String> responce = new HashMap<>();
//        String errors="";
//
//        Employee emp1 = employeedao.findByMyId(id);
//
//        if(emp1==null)
//            errors = errors+"<br> Employee Does Not Existed";
//
//        if(errors=="") employeedao.delete(emp1);
//        else errors = "Server Validation Errors : <br> "+errors;
//
//        responce.put("id",String.valueOf(id));
//        responce.put("url","/employees/"+id);
//        responce.put("errors",errors);
//
//        return responce;
//    }






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


