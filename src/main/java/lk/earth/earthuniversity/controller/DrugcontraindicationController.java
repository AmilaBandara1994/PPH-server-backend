package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ContraindicationDao;
import lk.earth.earthuniversity.dao.DrugcontraindicationDao;
import lk.earth.earthuniversity.entity.Contraindication;
import lk.earth.earthuniversity.entity.Drugcontraindication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/drugcontraindications")
public class DrugcontraindicationController {

    @Autowired
    private DrugcontraindicationDao drugcontraindicationDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Drugcontraindication> get() {

        List<Drugcontraindication> drugcontraindications = this.drugcontraindicationDao.findAll();

        drugcontraindications = drugcontraindications.stream().map(
                drugcontraindication -> { Drugcontraindication a = new Drugcontraindication();
                    a.setId(drugcontraindication.getId());
                    a.setContraindication(drugcontraindication.getContraindication());
                    return a; }
        ).collect(Collectors.toList());

        return drugcontraindications;

    }

}


