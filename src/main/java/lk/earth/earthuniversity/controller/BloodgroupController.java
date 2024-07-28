package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.BloodgroupDao;
import lk.earth.earthuniversity.dao.EmpstatusDao;
import lk.earth.earthuniversity.entity.Bloodgroup;
import lk.earth.earthuniversity.entity.Empstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/bloodgroups")
public class BloodgroupController {

    @Autowired
    private BloodgroupDao bloodgroupDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Bloodgroup> get() {

        List<Bloodgroup> bloodgroups = this.bloodgroupDao.findAll();

        bloodgroups = bloodgroups.stream().map(
                bloodgroup -> { Bloodgroup d = new Bloodgroup();
                    d.setId(bloodgroup.getId());
                    d.setName(bloodgroup.getName());
                    return d; }
        ).collect(Collectors.toList());

        return bloodgroups;

    }

}


