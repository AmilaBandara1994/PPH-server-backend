package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.AppointmentstatusDao;
import lk.earth.earthuniversity.entity.Appointmentstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/appointmentstatuses")
public class AppointmentstatusController {

    @Autowired
    private AppointmentstatusDao appointmentstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Appointmentstatus> get() {

        List<Appointmentstatus> appointmentstatuses = this.appointmentstatusDao.findAll();

        appointmentstatuses = appointmentstatuses.stream().map(
                appointmentstatus -> { Appointmentstatus a = new Appointmentstatus();
                    a.setId(appointmentstatus.getId());
                    a.setName(appointmentstatus.getName());
                    return a; }
        ).collect(Collectors.toList());

        return appointmentstatuses;

    }

}


