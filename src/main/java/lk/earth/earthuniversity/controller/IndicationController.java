package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.IndicationDao;
import lk.earth.earthuniversity.entity.Indication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/indications")
public class IndicationController {

    @Autowired
    private IndicationDao indicationDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Indication> get() {

        List<Indication> indications = this.indicationDao.findAll();

        indications = indications.stream().map(
                indication -> { Indication a = new Indication();
                    a.setId(indication.getId());
                    a.setName(indication.getName());
                    return a; }
        ).collect(Collectors.toList());

        return indications;

    }

}


