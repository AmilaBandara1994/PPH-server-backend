package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.EmpstatusDao;
import lk.earth.earthuniversity.dao.PatientriskfactorDao;
import lk.earth.earthuniversity.entity.Empstatus;
import lk.earth.earthuniversity.entity.Patientriskfactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/patientriskfactor")
public class PatientristfactorController {

    @Autowired
    private PatientriskfactorDao patientriskfactorDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Patientriskfactor> get() {

        List<Patientriskfactor> patientriskfactors = this.patientriskfactorDao.findAll();

        patientriskfactors = patientriskfactors.stream().map(
                patientriskfactor -> { Patientriskfactor d = new Patientriskfactor();
                    d.setId(patientriskfactor.getId());
                    d.setPatient(patientriskfactor.getPatient());
                    d.setRiskfactor(patientriskfactor.getRiskfactor());
                    return d; }
        ).collect(Collectors.toList());

        return patientriskfactors;

    }

}


