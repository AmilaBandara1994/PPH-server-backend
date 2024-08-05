package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DiagnosisDao;
import lk.earth.earthuniversity.entity.Diagnosis;
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
@RequestMapping(value = "/diagnoses")
public class DiagnosisController {

    @Autowired
    private DiagnosisDao diagnosisDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Diagnosis> getAll(@RequestParam HashMap <String,String> params) {


        String severityid = params.get("severityid");
        String treatmentplanid = params.get("treatmentplanid");
        String patientname = params.get("patientname");
//        String appointmentnumber = params.get("appointmentnumber");


        List<Diagnosis> diagnoses = this.diagnosisDao.findAll();
        if(params.isEmpty()) return diagnoses;

        Stream<Diagnosis> diagnosestream = diagnoses.stream();


        if(severityid!=null) diagnosestream = diagnosestream.filter(obj -> obj.getSeverity().getId() ==Integer.parseInt(severityid));
        if(treatmentplanid !=null) diagnosestream = diagnosestream.filter(obj -> obj.getTreatmentplan().getId() ==Integer.parseInt(treatmentplanid));
        if(patientname!=null) diagnosestream = diagnosestream.filter(obj -> obj.getAppointment().getPatient().getName().toLowerCase().contains(patientname.toLowerCase()));
//        if(appointmentnumber!=null) diagnosestream = diagnosestream.filter(obj -> obj.getBrand().getId() ==Integer.parseInt(appointmentnumber));

        return  diagnosestream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Diagnosis get(@PathVariable Integer id) {
        Diagnosis diagnosis = this.diagnosisDao.findByMyId(id);
        return diagnosis;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Diagnosis diagnosis){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        System.out.println(diagnosis.getSeverity());
        if(errors == ""){

            diagnosis.setTime(new Timestamp( new Date().getTime()));
            diagnosisDao.save(diagnosis);
        }

        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(diagnosis.getId()));
        response.put("url","/diagnoses/"+diagnosis.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Diagnosis diagnosis){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        if(errors=="") diagnosisDao.save(diagnosis);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(diagnosis.getId()));
        responce.put("url","/diagnoses/"+diagnosis.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Diagnosis diagnosis = diagnosisDao.findByMyId(id);
        if(diagnosis==null)
            errors = errors+"<br> Diagnosis Related to this ID Does Not Exist";

        if(errors.isEmpty()) diagnosisDao.delete(diagnosis);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/diagnoses/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


