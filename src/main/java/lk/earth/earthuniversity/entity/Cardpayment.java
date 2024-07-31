package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cardpayment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number")
    private String number;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "patientpayment_id", referencedColumnName = "id", nullable = false)
//    private Patientpayment patientpayment;
    @Basic
    @Column(name = "bankbranch")
    private String bankbranch;
    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id", nullable = false)
    private Bank bank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBankbranch() {
        return bankbranch;
    }

    public void setBankbranch(String bankbranch) {
        this.bankbranch = bankbranch;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cardpayment)) return false;
        Cardpayment that = (Cardpayment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getBankbranch(), that.getBankbranch()) && Objects.equals(getBank(), that.getBank());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getBankbranch(), getBank());
    }
}
