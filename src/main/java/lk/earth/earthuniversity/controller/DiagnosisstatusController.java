package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DiagnosisstatusDao;
import lk.earth.earthuniversity.entity.Diagnosisstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/diagnosisstatuses")
public class DiagnosisstatusController {

    @Autowired
    private DiagnosisstatusDao diagnosisstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Diagnosisstatus> get() {

        List<Diagnosisstatus> diagnosisstatuses = this.diagnosisstatusDao.findAll();

        diagnosisstatuses = diagnosisstatuses.stream().map(
                diagnosisstatus -> { Diagnosisstatus b = new Diagnosisstatus();
                    b.setId(diagnosisstatus.getId());
                    b.setName(diagnosisstatus.getName());
                    return b; }
        ).collect(Collectors.toList());

        return diagnosisstatuses;

    }

}


