package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.AppointmentstatusDao;
import lk.earth.earthuniversity.dao.PaymentstatusDao;
import lk.earth.earthuniversity.entity.Appointmentstatus;
import lk.earth.earthuniversity.entity.Paymentstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/paymentstatuses")
public class PaymentstatusController {

    @Autowired
    private PaymentstatusDao paymentstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Paymentstatus> get() {

        List<Paymentstatus> paymentstatuses = this.paymentstatusDao.findAll();

        paymentstatuses = paymentstatuses.stream().map(
                paymentstatus -> { Paymentstatus p = new Paymentstatus();
                    p.setId(paymentstatus.getId());
                    p.setName(paymentstatus.getName());
                    return p; }
        ).collect(Collectors.toList());

        return paymentstatuses;

    }

}


