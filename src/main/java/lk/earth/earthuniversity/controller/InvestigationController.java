package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.InvestigationDao;
import lk.earth.earthuniversity.entity.Investigation;
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
@RequestMapping(value = "/investigations")
public class InvestigationController {

    @Autowired
    private InvestigationDao investigationDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Investigation> getAll(@RequestParam HashMap <String,String> params) {

        String investigationtypeid = params.get("investigationtypeid");
        String investigationstatusid = params.get("investigationstatusid");
        String clinictypeid = params.get("clinictypeid");
        String patientid = params.get("patientid");
        String number = params.get("number");
        String date = params.get("date");
        String employeeid = params.get("employeeid");


        List<Investigation> investigations = this.investigationDao.findAll();
        if(params.isEmpty()) return investigations;

        Stream<Investigation> investigationStream = investigations.stream();


//        if(investigationtypeid!=null) investigationStream = investigationStream.filter(a -> a.getInvestigationtype().getId() ==Integer.parseInt(investigationtypeid));
//        if(investigationstatusid!=null) investigationStream = investigationStream.filter(a -> a.getInvestigationstatus().getId() ==Integer.parseInt(investigationstatusid));
//        if(clinictypeid !=null) investigationStream = investigationStream.filter(a -> a.getClinic().getId() ==Integer.parseInt(clinictypeid));
//        if(patientid!=null) investigationStream = investigationStream.filter(a -> a.getPatient().getId() ==Integer.parseInt(patientid));
//        if(number!=null) investigationStream = investigationStream.filter(a -> a.getNumber().equals(number));
//        if(employeeid!=null) investigationStream = investigationStream.filter(a -> a.getEmployee().getId() ==Integer.parseInt(employeeid));
//        if(date!=null) investigationStream = investigationStream.filter(a -> a.getDate().toString().equals(date));


        return  investigationStream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Investigation get(@PathVariable Integer id) {
        Investigation investigation = this.investigationDao.findByMyId(id);
        return investigation;
    }
//    @GetMapping(path ="/patientid/{id}", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Investigation> getbypatientid(@PathVariable Integer id) {
//        List<Investigation> investigations = this.investigationDao.findByPatientId(id);
//        return investigations;
//    }
//
//    @GetMapping(path ="/countbyclinic/{id}", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public Long getcount(@PathVariable Integer id) {
//         return  this.investigationDao.countByClinic(id);
//    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Investigation investigation){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        String name =  investigation.getName();

        if(investigationDao.findByName(name)!=null)
            errors = errors+"<br> Existing Name";

        if(errors == ""){
            investigation.setDate(new Timestamp( new Date().getTime()));
            investigationDao.save(investigation);
        }else{
            errors = "Server Validation Errors : <br> "+errors;
        }

        response.put("id",String.valueOf(investigation.getId()));
        response.put("url","/investigations/"+investigation.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Investigation investigation){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

//        Investigation appoint =  investigationDao.findByNumber(investigation.getNumber());

//        if(appoint!=null && investigation.getId()!=appoint.getId())
//            errors = errors+"<br> Existing Investigation";

        if(errors=="") investigationDao.save(investigation);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(investigation.getId()));
        responce.put("url","/investigations/"+investigation.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Investigation investigation = investigationDao.findByMyId(id);
        if(investigation==null)
            errors = errors+"<br> Investigation Does Not Exist";

        if(errors.isEmpty()) investigationDao.delete(investigation);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/investigations/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


