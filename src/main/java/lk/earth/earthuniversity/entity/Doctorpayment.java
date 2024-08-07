package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Doctorpayment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "total")
    private BigDecimal total;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "paiddate")
    private Date paiddate;
    @ManyToOne
    @JoinColumn(name = "doctorpaymentstatus_id", referencedColumnName = "id", nullable = false)
    private Doctorpaymentstatus doctorpaymentstatus;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "id", nullable = false)
    private Clinic clinic;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPaiddate() {
        return paiddate;
    }

    public void setPaiddate(Date paiddate) {
        this.paiddate = paiddate;
    }

    public Doctorpaymentstatus getDoctorpaymentstatus() {
        return doctorpaymentstatus;
    }

    public void setDoctorpaymentstatus(Doctorpaymentstatus doctorpaymentstatus) {
        this.doctorpaymentstatus = doctorpaymentstatus;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctorpayment)) return false;
        Doctorpayment that = (Doctorpayment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getTotal(), that.getTotal()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getPaiddate(), that.getPaiddate()) && Objects.equals(getDoctorpaymentstatus(), that.getDoctorpaymentstatus()) && Objects.equals(getClinic(), that.getClinic()) && Objects.equals(getEmployee(), that.getEmployee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getTotal(), getDescription(), getPaiddate(), getDoctorpaymentstatus(), getClinic(), getEmployee());
    }
}
