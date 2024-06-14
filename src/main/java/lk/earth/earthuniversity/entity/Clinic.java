package lk.earth.earthuniversity.entity;

import lk.earth.earthuniversity.util.RegexPattern;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Clinic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    @Column(name = "date")
    private Date date;

    @Basic
    @RegexPattern(reg = "^(1[0-2]|0?[1-9])[:][0-5][0-9][:][0-5][0-9]$", msg = "Invalid Time Format")
    @Column(name = "starttime")
    private Time starttime;

    @Basic
    @RegexPattern(reg = "^(1[0-2]|0?[1-9])[:][0-5][0-9][:][0-5][0-9]$", msg = "Invalid Time Format")
    @Column(name = "endtime")
    private Time endtime;

    @Basic
    @RegexPattern(reg = "^\\d{2}$", msg = "Invalid Patient Count")
    @Column(name = "patientcount")
    private Integer patientcount;

    @Basic
    @RegexPattern(reg = "^\\d{2,4}(?:[.]\\d{2})?$", msg="Invalid Total Income")
    @Column(name = "totalincome")
    private BigDecimal totalincome;

    @Basic
    @RegexPattern(reg = "^\\d{2,5}(?:[.]\\d{2})?$", msg="Invalid Doctor Payment")
    @Column(name = "doctorpayment")
    private BigDecimal doctorpayment;

    @Basic
    @Column(name = "dopublish")
    private Date dopublish;

    @ManyToOne
    @JoinColumn(name = "clinictype_id", referencedColumnName = "id", nullable = false)
    private Clinictype clinictype;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "nurse1_id", referencedColumnName = "id", nullable = false)
    private Employee nurse1;

    @ManyToOne
    @JoinColumn(name = "nurse2_id", referencedColumnName = "id")
    private Employee nurse2;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "clinicstatus_id", referencedColumnName = "id", nullable = false)
    private Clinicstatus clinicstatus;

    public Clinic(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Integer getPatientcount() {
        return patientcount;
    }

    public void setPatientcount(Integer patientcount) {
        this.patientcount = patientcount;
    }

    public BigDecimal getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(BigDecimal totalincome) {
        this.totalincome = totalincome;
    }

    public BigDecimal getDoctorpayment() {
        return doctorpayment;
    }

    public void setDoctorpayment(BigDecimal doctorpayment) {
        this.doctorpayment = doctorpayment;
    }

    public Date getDopublish() {
        return dopublish;
    }

    public void setDopublish(Date dopublish) {
        this.dopublish = dopublish;
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
        if (o == null || getClass() != o.getClass()) return false;

        Clinic clinic = (Clinic) o;

        if (id != null ? !id.equals(clinic.id) : clinic.id != null) return false;
        if (date != null ? !date.equals(clinic.date) : clinic.date != null) return false;
        if (starttime != null ? !starttime.equals(clinic.starttime) : clinic.starttime != null) return false;
        if (endtime != null ? !endtime.equals(clinic.endtime) : clinic.endtime != null) return false;
        if (patientcount != null ? !patientcount.equals(clinic.patientcount) : clinic.patientcount != null)
            return false;
        if (totalincome != null ? !totalincome.equals(clinic.totalincome) : clinic.totalincome != null) return false;
        if (doctorpayment != null ? !doctorpayment.equals(clinic.doctorpayment) : clinic.doctorpayment != null)
            return false;
        if (dopublish != null ? !dopublish.equals(clinic.dopublish) : clinic.dopublish != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (patientcount != null ? patientcount.hashCode() : 0);
        result = 31 * result + (totalincome != null ? totalincome.hashCode() : 0);
        result = 31 * result + (doctorpayment != null ? doctorpayment.hashCode() : 0);
        result = 31 * result + (dopublish != null ? dopublish.hashCode() : 0);
        return result;
    }

    public Clinictype getClinictype() {
        return clinictype;
    }

    public void setClinictype(Clinictype clinictype) {
        this.clinictype = clinictype;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Employee getNurse1() {
        return nurse1;
    }

    public void setNurse1(Employee nurse1) {
        this.nurse1 = nurse1;
    }

    public Employee getNurse2() {
        return nurse2;
    }

    public void setNurse2(Employee nurse2) {
        this.nurse2 = nurse2;
    }

    public Clinicstatus getClinicstatus() {
        return clinicstatus;
    }

    public void setClinicstatus(Clinicstatus clinicstatus) {
        this.clinicstatus = clinicstatus;
    }
}
