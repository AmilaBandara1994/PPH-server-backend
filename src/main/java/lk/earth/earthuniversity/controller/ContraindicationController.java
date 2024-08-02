package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ContraindicationDao;
import lk.earth.earthuniversity.entity.Contraindication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/contraindications")
public class ContraindicationController {

    @Autowired
    private ContraindicationDao contraindicationDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Contraindication> get() {

        List<Contraindication> contraindications = this.contraindicationDao.findAll();

        contraindications = contraindications.stream().map(
                contraindication -> { Contraindication a = new Contraindication();
                    a.setId(contraindication.getId());
                    a.setName(contraindication.getName());
                    return a; }
        ).collect(Collectors.toList());

        return contraindications;

    }

}


