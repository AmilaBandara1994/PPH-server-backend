package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.AppointmenttypeDao;
import lk.earth.earthuniversity.dao.ClinicstatusDao;
import lk.earth.earthuniversity.entity.Appointmenttype;
import lk.earth.earthuniversity.entity.Clinicstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/appointmenttypes")
public class AppointmenttypeController {

    @Autowired
    private AppointmenttypeDao appointmenttypeDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Appointmenttype> get() {

        List<Appointmenttype> appointmenttypes = this.appointmenttypeDao.findAll();

        appointmenttypes = appointmenttypes.stream().map(
                appointmenttype -> { Appointmenttype a = new Appointmenttype();
                            a.setId(appointmenttype.getId());
                            a.setName(appointmenttype.getName());
                            return a; }
        ).collect(Collectors.toList());

        return appointmenttypes;

    }

}


