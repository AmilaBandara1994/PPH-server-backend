package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.GenericDao;
import lk.earth.earthuniversity.entity.Generic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/generics")
public class GenericController {

    @Autowired
    private GenericDao genericDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Generic> get() {

        List<Generic> generics = this.genericDao.findAll();

        generics = generics.stream().map(
                generic -> { Generic a = new Generic();
                    a.setId(generic.getId());
                    a.setName(generic.getName());
                    return a; }
        ).collect(Collectors.toList());

        return generics;

    }

}


