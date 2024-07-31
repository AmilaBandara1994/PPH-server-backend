package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.CardpaymentDao;
import lk.earth.earthuniversity.dao.PaymentstatusDao;
import lk.earth.earthuniversity.entity.Cardpayment;
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
@RequestMapping(value = "/cardpayments")
public class CardpaymentController {

    @Autowired
    private CardpaymentDao cardpaymentDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Cardpayment> get() {

        List<Cardpayment> cardpayments = this.cardpaymentDao.findAll();

        cardpayments = cardpayments.stream().map(
                cardpayment -> { Cardpayment c = new Cardpayment();
                    c.setId(cardpayment.getId());
                    c.setNumber(cardpayment.getNumber());
                    return c; }
        ).collect(Collectors.toList());

        return cardpayments;

    }

}


