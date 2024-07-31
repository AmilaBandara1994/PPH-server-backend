package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.UniversityDao;
import lk.earth.earthuniversity.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/universities")
public class UniversityController {

    @Autowired
    private UniversityDao universityDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<University> get() {

        List<University> universities = this.universityDao.findAll();

        universities = universities.stream().map(
                    university -> { University u = new University();
                    u.setId(university.getId());
                    u.setName(university.getName());
                            return u; }
        ).collect(Collectors.toList());

        return universities;

    }

}


