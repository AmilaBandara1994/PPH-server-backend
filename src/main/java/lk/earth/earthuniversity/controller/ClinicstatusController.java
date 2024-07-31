package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClinicstatusDao;
import lk.earth.earthuniversity.entity.Clinicstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/clinicstatuses")
public class ClinicstatusController {

    @Autowired
    private ClinicstatusDao clinicstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Clinicstatus> get() {

        List<Clinicstatus> clinicstatuses = this.clinicstatusDao.findAll();

        clinicstatuses = clinicstatuses.stream().map(
                clinicstatus -> { Clinicstatus c = new Clinicstatus();
                            c.setId(clinicstatus.getId());
                            c.setName(clinicstatus.getName());
                            return c; }
        ).collect(Collectors.toList());

        return clinicstatuses;

    }

}


