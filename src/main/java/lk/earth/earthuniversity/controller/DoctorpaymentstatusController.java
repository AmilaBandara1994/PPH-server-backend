package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DoctorpaymentstatusDao;
import lk.earth.earthuniversity.entity.Doctorpaymentstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/doctorpaymentstatuses")
public class DoctorpaymentstatusController {

    @Autowired
    private DoctorpaymentstatusDao doctorpaymentstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Doctorpaymentstatus> get() {

        List<Doctorpaymentstatus> doctorpaymentstatuses = this.doctorpaymentstatusDao.findAll();

        doctorpaymentstatuses = doctorpaymentstatuses.stream().map(
                doctorpaymentstatus -> { Doctorpaymentstatus b = new Doctorpaymentstatus();
                    b.setId(doctorpaymentstatus.getId());
                    b.setName(doctorpaymentstatus.getName());
                    return b; }
        ).collect(Collectors.toList());

        return doctorpaymentstatuses;

    }

}


