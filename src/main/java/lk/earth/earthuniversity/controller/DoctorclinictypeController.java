package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DoctorclinictypeDao;
import lk.earth.earthuniversity.dao.DoctorclinictypeDao;
import lk.earth.earthuniversity.entity.Doctorclinictype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/doctorclinictypes")
public class DoctorclinictypeController {

    @Autowired
    private DoctorclinictypeDao doctorclinictypeDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Doctorclinictype> get() {

        List<Doctorclinictype> doctorclinictypes = this.doctorclinictypeDao.findAll();

        doctorclinictypes = doctorclinictypes.stream().map(
                doctorclinictype -> { Doctorclinictype d = new Doctorclinictype();
                    d.setId(doctorclinictype.getId());
                    d.setClinictype(doctorclinictype.getClinictype());
                    return d; }
        ).collect(Collectors.toList());

        return doctorclinictypes;

    }

}


