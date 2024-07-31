package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Appointment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "id", nullable = false)
    private Clinic clinic;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "appointmentstatus_id", referencedColumnName = "id", nullable = false)
    private Appointmentstatus appointmentstatus;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "appointmenttype_id", referencedColumnName = "id", nullable = false)
    private Appointmenttype appointmenttype;
    @OneToMany(mappedBy = "appointment")
    @JsonIgnore
    private Collection<Patientpayment> patientpayments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getClinic(), that.getClinic()) && Objects.equals(getPatient(), that.getPatient()) && Objects.equals(getAppointmentstatus(), that.getAppointmentstatus()) && Objects.equals(getEmployee(), that.getEmployee()) && Objects.equals(getAppointmenttype(), that.getAppointmenttype());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getDate(), getDescription(), getClinic(), getPatient(), getAppointmentstatus(), getEmployee(), getAppointmenttype());
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointmentstatus getAppointmentstatus() {
        return appointmentstatus;
    }

    public void setAppointmentstatus(Appointmentstatus appointmentstatus) {
        this.appointmentstatus = appointmentstatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Appointmenttype getAppointmenttype() {
        return appointmenttype;
    }

    public void setAppointmenttype(Appointmenttype appointmenttype) {
        this.appointmenttype = appointmenttype;
    }

    public Collection<Patientpayment> getPatientpayments() {
        return patientpayments;
    }

    public void setPatientpayments(Collection<Patientpayment> patientpayments) {
        this.patientpayments = patientpayments;
    }
}
