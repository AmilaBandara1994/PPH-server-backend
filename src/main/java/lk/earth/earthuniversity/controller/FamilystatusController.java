package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.FamilystatusDao;
import lk.earth.earthuniversity.entity.Familystatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/familystatuses")
public class FamilystatusController {

    @Autowired
    private FamilystatusDao familystatusDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Familystatus> get() {

        List<Familystatus> familystatuses = this.familystatusDao.findAll();

        familystatuses = familystatuses.stream().map(
                familystatus -> { Familystatus d = new Familystatus();
                    d.setId(familystatus.getId());
                    d.setName(familystatus.getName());
                    return d; }
        ).collect(Collectors.toList());

        return familystatuses;

    }

}


