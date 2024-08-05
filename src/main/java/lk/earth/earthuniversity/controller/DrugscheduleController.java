package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DrugscheduleDao;
import lk.earth.earthuniversity.entity.Drugschedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/drugschedules")
public class DrugscheduleController {

    @Autowired
    private DrugscheduleDao drugscheduleDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Drugschedule> get() {

        List<Drugschedule> drugschedules = this.drugscheduleDao.findAll();

        drugschedules = drugschedules.stream().map(
                drugschedule -> { Drugschedule b = new Drugschedule();
                    b.setId(drugschedule.getId());
                    b.setName(drugschedule.getName());
                    return b; }
        ).collect(Collectors.toList());

        return drugschedules;

    }

}


