package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.InvestigationresultDao;
import lk.earth.earthuniversity.entity.Investigationresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/investigationresults")
public class InvestigationresultController {

    @Autowired
    private InvestigationresultDao investigationresultDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Investigationresult> get() {

        List<Investigationresult> investigationresults = this.investigationresultDao.findAll();

        investigationresults = investigationresults.stream().map(
                investigationresult -> { Investigationresult b = new Investigationresult();
                    b.setId(investigationresult.getId());
                    b.setName(investigationresult.getName());
                    return b; }
        ).collect(Collectors.toList());

        return investigationresults;

    }

}


