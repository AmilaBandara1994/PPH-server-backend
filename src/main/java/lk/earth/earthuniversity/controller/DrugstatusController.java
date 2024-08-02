package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DrugstatusDao;
import lk.earth.earthuniversity.entity.Drugstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/drugstatuses")
public class DrugstatusController {

    @Autowired
    private DrugstatusDao drugstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Drugstatus> get() {

        List<Drugstatus> drugstatuss = this.drugstatusDao.findAll();

        drugstatuss = drugstatuss.stream().map(
                drugstatus -> { Drugstatus a = new Drugstatus();
                    a.setId(drugstatus.getId());
                    a.setName(drugstatus.getName());
                    return a; }
        ).collect(Collectors.toList());

        return drugstatuss;

    }

}


