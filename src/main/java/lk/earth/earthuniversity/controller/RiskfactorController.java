package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.EmpstatusDao;
import lk.earth.earthuniversity.dao.RiskfactorDao;
import lk.earth.earthuniversity.entity.Empstatus;
import lk.earth.earthuniversity.entity.Riskfactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/riskfactors")
public class RiskfactorController {

    @Autowired
    private RiskfactorDao riskfactorDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Riskfactor> get() {

        List<Riskfactor> riskfactors = this.riskfactorDao.findAll();

        riskfactors = riskfactors.stream().map(
                riskfactor -> { Riskfactor d = new Riskfactor();
                    d.setId(riskfactor.getId());
                    d.setName(riskfactor.getName());
                    return d; }
        ).collect(Collectors.toList());

        return riskfactors;

    }

}


