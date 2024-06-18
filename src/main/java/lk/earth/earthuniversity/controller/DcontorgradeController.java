package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DoctorgradeDao;
import lk.earth.earthuniversity.entity.Doctorgrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/doctorgrades")
public class DcontorgradeController {

    @Autowired
    private DoctorgradeDao doctorgradeDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Doctorgrade> get() {

        List<Doctorgrade> doctorgrades = this.doctorgradeDao.findAll();

        doctorgrades = doctorgrades.stream().map(
                doctorgrade -> { Doctorgrade d = new Doctorgrade();
                            d.setId(doctorgrade.getId());
                            d.setName(doctorgrade.getName());
                            return d; }
        ).collect(Collectors.toList());

        return doctorgrades;

    }

}


