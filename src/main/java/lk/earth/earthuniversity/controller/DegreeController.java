package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DegreeDao;
import lk.earth.earthuniversity.entity.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/degrees")
public class DegreeController {

    @Autowired
    private DegreeDao degreeDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Degree> get() {

        List<Degree> degrees = this.degreeDao.findAll();

        degrees = degrees.stream().map(
                    degree -> { Degree d = new Degree();
                    d.setId(degree.getId());
                    d.setName(degree.getName());
                            return d; }
        ).collect(Collectors.toList());

        return degrees;

    }

}


