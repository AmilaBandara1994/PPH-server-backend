package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.earth.earthuniversity.util.RegexPattern;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Clinic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;


    @Basic
    @Column(name = "name")
    private String name;
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
    @RegexPattern(reg = "^\\d{2,3}$", msg = "Invalid Patient Count")
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
    private Timestamp dopublish;

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
    @OneToMany(mappedBy = "clinic")
    @JsonIgnore
    private Collection<Appointment> appointments;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "clinic")
    @JsonIgnore
    private Collection<Doctorpayment> doctorpayments;


    public Clinic(){}

    public Clinic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Timestamp getDopublish() {
        return dopublish;
    }

    public void setDopublish(Timestamp dopublish) {
        this.dopublish = dopublish;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Clinicstatus getClinicstatus() {
        return clinicstatus;
    }

    public void setClinicstatus(Clinicstatus clinicstatus) {
        this.clinicstatus = clinicstatus;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clinic)) return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(getId(), clinic.getId()) && Objects.equals(getName(), clinic.getName()) && Objects.equals(getDate(), clinic.getDate()) && Objects.equals(getStarttime(), clinic.getStarttime()) && Objects.equals(getEndtime(), clinic.getEndtime()) && Objects.equals(getPatientcount(), clinic.getPatientcount()) && Objects.equals(getTotalincome(), clinic.getTotalincome()) && Objects.equals(getDoctorpayment(), clinic.getDoctorpayment()) && Objects.equals(getDopublish(), clinic.getDopublish()) && Objects.equals(getClinictype(), clinic.getClinictype()) && Objects.equals(getDoctor(), clinic.getDoctor()) && Objects.equals(getNurse1(), clinic.getNurse1()) && Objects.equals(getNurse2(), clinic.getNurse2()) && Objects.equals(getEmployee(), clinic.getEmployee()) && Objects.equals(getClinicstatus(), clinic.getClinicstatus()) && Objects.equals(getAppointments(), clinic.getAppointments()) && Objects.equals(getDescription(), clinic.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDate(), getStarttime(), getEndtime(), getPatientcount(), getTotalincome(), getDoctorpayment(), getDopublish(), getClinictype(), getDoctor(), getNurse1(), getNurse2(), getEmployee(), getClinicstatus(), getAppointments(), getDescription());
    }

    public Collection<Doctorpayment> getDoctorpayments() {
        return doctorpayments;
    }

    public void setDoctorpayments(Collection<Doctorpayment> doctorpayments) {
        this.doctorpayments = doctorpayments;
    }
}
