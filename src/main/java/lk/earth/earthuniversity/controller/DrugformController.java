package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DrugformDao;
import lk.earth.earthuniversity.entity.Drugform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/drugforms")
public class DrugformController {

    @Autowired
    private DrugformDao drugformDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Drugform> get() {

        List<Drugform> drugforms = this.drugformDao.findAll();

        drugforms = drugforms.stream().map(
                drugform -> { Drugform a = new Drugform();
                    a.setId(drugform.getId());
                    a.setName(drugform.getName());
                    return a; }
        ).collect(Collectors.toList());

        return drugforms;

    }

}


