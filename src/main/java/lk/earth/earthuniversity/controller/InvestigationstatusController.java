package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.InvestigationstatusDao;
import lk.earth.earthuniversity.entity.Investigationstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/investigationstatuses")
public class InvestigationstatusController {

    @Autowired
    private InvestigationstatusDao investigationstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Investigationstatus> get() {

        List<Investigationstatus> investigationstatuses = this.investigationstatusDao.findAll();

        investigationstatuses = investigationstatuses.stream().map(
                investigationstatus -> { Investigationstatus b = new Investigationstatus();
                    b.setId(investigationstatus.getId());
                    b.setName(investigationstatus.getName());
                    return b; }
        ).collect(Collectors.toList());

        return investigationstatuses;

    }

}


