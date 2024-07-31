package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.PaymentstatusDao;
import lk.earth.earthuniversity.dao.PaytypeDao;
import lk.earth.earthuniversity.entity.Paymentstatus;
import lk.earth.earthuniversity.entity.Paytype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/paytypes")
public class PaytypeController {

    @Autowired
    private PaytypeDao paymentstatusDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Paytype> get() {

        List<Paytype> paytypes = this.paymentstatusDao.findAll();

        paytypes = paytypes.stream().map(
                paytype -> { Paytype p = new Paytype();
                    p.setId(paytype.getId());
                    p.setName(paytype.getName());
                    return p; }
        ).collect(Collectors.toList());

        return paytypes;

    }

}


