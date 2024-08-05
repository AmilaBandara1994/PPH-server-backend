package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DiseaseDao;
import lk.earth.earthuniversity.entity.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/diseases")
public class DiseaseController {

    @Autowired
    private DiseaseDao diseaseDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Disease> get() {

        List<Disease> diseases = this.diseaseDao.findAll();

        diseases = diseases.stream().map(
                disease -> { Disease b = new Disease();
                    b.setId(disease.getId());
                    b.setName(disease.getName());
                    return b; }
        ).collect(Collectors.toList());

        return diseases;

    }

}


