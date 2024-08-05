package lk.earth.earthuniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
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
//    @Pattern(regexp = "^[A-Z]+-[A-Z]+\\d+$", message = "Invalid Number")
    private String number;
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
    @OneToMany(mappedBy = "appointment")
    @JsonIgnore
    private Collection<Diagnosis> diagnoses;
    @OneToMany(mappedBy = "appointment")
    @JsonIgnore
    private Collection<Prescription> prescriptions;

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

    public Collection<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Collection<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNumber(), that.getNumber()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getClinic(), that.getClinic()) && Objects.equals(getPatient(), that.getPatient()) && Objects.equals(getAppointmentstatus(), that.getAppointmentstatus()) && Objects.equals(getEmployee(), that.getEmployee()) && Objects.equals(getAppointmenttype(), that.getAppointmenttype()) && Objects.equals(getPatientpayments(), that.getPatientpayments()) && Objects.equals(getDiagnoses(), that.getDiagnoses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getDate(), getDescription(), getClinic(), getPatient(), getAppointmentstatus(), getEmployee(), getAppointmenttype(), getPatientpayments(), getDiagnoses());
    }

    public Collection<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Collection<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
