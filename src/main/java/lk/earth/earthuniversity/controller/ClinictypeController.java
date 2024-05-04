package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClinictypeDao;
import lk.earth.earthuniversity.entity.Clinictype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/clinictypes")
public class ClinictypeController {

    @Autowired
    private ClinictypeDao clinictypeDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Clinictype> get() {

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


