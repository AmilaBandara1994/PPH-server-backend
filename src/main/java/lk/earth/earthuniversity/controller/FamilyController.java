package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.EmployeeDao;
import lk.earth.earthuniversity.dao.FamilyDao;
import lk.earth.earthuniversity.entity.Employee;
import lk.earth.earthuniversity.entity.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/families")
public class FamilyController {

    @Autowired
    private FamilyDao familyDao;

    @GetMapping(produces = "application/json")
//    @PreAuthorize("hasAuthority('employee-select')")
    public List<Family> get(@RequestParam HashMap<String, String> params) {

        List<Family> families = this.familyDao.findAll();

        if(params.isEmpty())  return families;

        String districtid = params.get("districtid");
        String provinceid = params.get("provinceid");
        String fullname= params.get("fullname");
        String familystatusid = params.get("familystatusid");

        Stream<Family> familyStream = families.stream();

        if(districtid!=null) familyStream = familyStream.filter(f -> f.getDistrict().getId()==Integer.parseInt(districtid));
        if(provinceid!=null) familyStream = familyStream.filter(f -> f.getDistrict().getProvince().getId()==Integer.parseInt(provinceid));
        if(familystatusid!=null) familyStream = familyStream.filter(f -> f.getFamilystatus().getId()==Integer.parseInt(familystatusid));
        if(fullname!=null) familyStream = familyStream.filter(f -> f.getName().contains(fullname));

        return familyStream.collect(Collectors.toList());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Insert')")
    public HashMap<String,String> add(@RequestBody Family family){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        if(familyDao.findByMobileNumber(family.getMobile())!=null)
            errors = errors+"<br> Existing Mobile Number";
        if(familyDao.findByName(family.getName())!=null)
            errors = errors+"<br> Existing Name";


        if(errors=="")
        familyDao.save(family);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(family.getId()));
        responce.put("url","/families/"+family.getId());
        responce.put("errors",errors);

        return responce;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('Employee-Update')")
    public HashMap<String,String> update(@RequestBody Family family){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Family family1 = familyDao.findByMobileNumber(family.getMobile());
        Family family2 = familyDao.findByName(family.getName());

        if(family1!=null && family.getId()!=family1.getId())
            errors = errors+"<br> Existing Mobile";
        if(family2!=null && family.getId()!=family2.getId())
            errors = errors+"<br> Existing Name";

        if(errors=="") familyDao.save(family);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(family.getId()));
        responce.put("url","/families/"+family.getId());
        responce.put("errors",errors);

        return responce;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Family family1 = familyDao.findByMyId(id);

        if(family1==null)
            errors = errors+"<br> Family with id Does Not Existed";

        if(errors=="") familyDao.delete(family1);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/families/"+id);
        responce.put("errors",errors);

        return responce;
    }

}




