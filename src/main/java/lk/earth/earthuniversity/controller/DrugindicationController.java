package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DrugcontraindicationDao;
import lk.earth.earthuniversity.dao.DrugindicationDao;
import lk.earth.earthuniversity.entity.Drugcontraindication;
import lk.earth.earthuniversity.entity.Drugindication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/drugindications")
public class DrugindicationController {

    @Autowired
    private DrugindicationDao drugindicationDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Drugindication> get() {

        List<Drugindication>  drugindications= this.drugindicationDao.findAll();

        drugindications = drugindications.stream().map(
                drugindication -> { Drugindication a = new Drugindication();
                    a.setId(drugindication.getId());
                    a.setIndication(drugindication.getIndication());
                    return a; }
        ).collect(Collectors.toList());

        return drugindications;

    }

}


