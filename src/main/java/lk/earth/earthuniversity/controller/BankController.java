package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.AppointmentstatusDao;
import lk.earth.earthuniversity.dao.BankDao;
import lk.earth.earthuniversity.entity.Appointmentstatus;
import lk.earth.earthuniversity.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/banks")
public class BankController {

    @Autowired
    private BankDao bankDao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Bank> get() {

        List<Bank> banks = this.bankDao.findAll();

        banks = banks.stream().map(
                bank -> { Bank b = new Bank();
                    b.setId(bank.getId());
                    b.setName(bank.getName());
                    return b; }
        ).collect(Collectors.toList());

        return banks;

    }

}


