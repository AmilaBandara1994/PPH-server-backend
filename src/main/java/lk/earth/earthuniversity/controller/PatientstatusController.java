package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.PatientstatusDao;
import lk.earth.earthuniversity.entity.Patientstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/patientstatuses")
public class PatientstatusController {

    @Autowired
    private PatientstatusDao patientstatusDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Patientstatus> get() {

        List<Patientstatus> patientstatuses = this.patientstatusDao.findAll();

        patientstatuses = patientstatuses.stream().map(
                patientstatus -> { Patientstatus d = new Patientstatus();
                    d.setId(patientstatus.getId());
                    d.setName(patientstatus.getName());
                    return d; }
        ).collect(Collectors.toList());

        return patientstatuses;

    }

}


