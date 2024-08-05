package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.AllergyDao;
import lk.earth.earthuniversity.entity.Allergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/allergies")
public class AllergyController {

    @Autowired
    private AllergyDao allergyDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Allergy> get() {

        List<Allergy> allergies = this.allergyDao.findAll();

        allergies = allergies.stream().map(
                allergy -> { Allergy b = new Allergy();
                    b.setId(allergy.getId());
                    b.setName(allergy.getName());
                    return b; }
        ).collect(Collectors.toList());

        return allergies;

    }

}


