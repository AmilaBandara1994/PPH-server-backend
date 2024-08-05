package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.SeverityDao;
import lk.earth.earthuniversity.entity.Severity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/severities")
public class SeverityController {

    @Autowired
    private SeverityDao severityDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Severity> get() {

        List<Severity> severities = this.severityDao.findAll();

        severities = severities.stream().map(
                severity -> { Severity b = new Severity();
                    b.setId(severity.getId());
                    b.setName(severity.getName());
                    return b; }
        ).collect(Collectors.toList());

        return severities;

    }

}


