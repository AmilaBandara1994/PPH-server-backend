package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DrugDao;
import lk.earth.earthuniversity.entity.Drug;
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
@RequestMapping(value = "/drugs")
public class DrugController {

    @Autowired
    private DrugDao drugDao;

    @GetMapping(value = "/list", produces = "application/json")
    public List<Drug> getAll(@RequestParam HashMap <String,String> params) {

        String code = params.get("code");
        String drugformid = params.get("drugformid");
        String genericid = params.get("genericid");
        String name = params.get("name");
        String brandid = params.get("brandid");


        List<Drug> drugs = this.drugDao.findAll();
        if(params.isEmpty()) return drugs;

        Stream<Drug> drugStream = drugs.stream();


        if(code!=null) drugStream = drugStream.filter(obj-> obj.getCode().equals(code));
        if(drugformid!=null) drugStream = drugStream.filter(obj -> obj.getDrugform().getId() ==Integer.parseInt(drugformid));
        if(genericid !=null) drugStream = drugStream.filter(obj -> obj.getGeneric().getId() ==Integer.parseInt(genericid));
        if(name!=null) drugStream = drugStream.filter(obj -> obj.getName().toLowerCase().contains(name.toLowerCase()));
        if(brandid!=null) drugStream = drugStream.filter(obj -> obj.getBrand().getId() ==Integer.parseInt(brandid));

        return  drugStream.collect(Collectors.toList());

    }

    @GetMapping(path ="/details/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Drug get(@PathVariable Integer id) {
        Drug drug = this.drugDao.findByMyId(id);
        return drug;
    }
//    @GetMapping(path ="/patientid/{id}", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Drug> getbypatientid(@PathVariable Integer id) {
//        List<Drug> drugs = this.drugDao.findByPatientId(id);
//        return drugs;
//    }
//
//    @GetMapping(path ="/countbyclinic/{id}", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public Long getcount(@PathVariable Integer id) {
//         return  this.drugDao.countByClinic(id);
//    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Drug drug){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        String drugCode =  drug.getCode();
        String drugName =  drug.getName();

        if(drugDao.findByDrugCode(drugCode)!=null)
            errors = errors+"<br> Existing Drug Code";

        if(drugDao.findByDrugName(drugName)!=null)
            errors = errors+"<br> Existing Drug Name";

        if(errors == ""){

            drug.setDointroduced(new Timestamp( new Date().getTime()));
            drugDao.save(drug);
        }

        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(drug.getId()));
        response.put("url","/drugs/"+drug.getId());
        response.put("errors",errors);

        return response;
    }



    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Drug drug){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Drug drug1=  drugDao.findByDrugCode(drug.getCode());
        Drug drug2=  drugDao.findByDrugName(drug.getName());

        if(drug1!=null && drug.getId()!=drug1.getId())
            errors = errors+"<br> Existing Drug ";

        if(drug2!=null && drug.getId()!=drug2.getId())
            errors = errors+"<br> Existing Drug ";

        if(errors=="") drugDao.save(drug);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(drug.getId()));
        responce.put("url","/drugs/"+drug.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        HashMap<String,String> responce = new HashMap<>();
        String errors="";
        Drug drug = drugDao.findByMyId(id);
        if(drug==null)
            errors = errors+"<br> Drug Related to this ID Does Not Exist";

        if(errors.isEmpty()) drugDao.delete(drug);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/drugs/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


