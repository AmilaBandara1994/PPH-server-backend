package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DrugadverseeffectDao;
import lk.earth.earthuniversity.dao.DrugcontraindicationDao;
import lk.earth.earthuniversity.entity.Drugadverseeffect;
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
@RequestMapping(value = "/drugadverseeffects")
public class DrugadverseeffectController {

    @Autowired
    private DrugadverseeffectDao drugadverseeffectDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Drugadverseeffect> get() {

        List<Drugadverseeffect> drugadverseeffects = this.drugadverseeffectDao.findAll();

        drugadverseeffects = drugadverseeffects.stream().map(
                drugadverseeffect -> { Drugadverseeffect a = new Drugadverseeffect();
                    a.setId(drugadverseeffect.getId());
                    a.setAdverseeffect(drugadverseeffect.getAdverseeffect());
                    return a; }
        ).collect(Collectors.toList());

        return drugadverseeffects;

    }

}


