package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClinictypeDao;
import lk.earth.earthuniversity.entity.Clinictype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/clinictypes")
public class ClinictypeController {

    @Autowired
    private ClinictypeDao clinictypeDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Clinictype> get()  {
//        @RequestParam HashMap<String, String> params
        List<Clinictype> clinictypes = this.clinictypeDao.findAll();

        clinictypes = clinictypes.stream().map(
                clinictype -> { Clinictype c = new Clinictype();
                            c.setId(clinictype.getId());
                            c.setName(clinictype.getName());
                            return c; }
        ).collect(Collectors.toList());

        return clinictypes;

    }

}


