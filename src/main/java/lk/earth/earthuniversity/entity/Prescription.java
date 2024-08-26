package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Prescription {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id", nullable = false)
    private Appointment appointment;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Prescriptiondrug> prescriptiondrugs;
    @ManyToOne
    @JoinColumn(name = "prescriptionstatus_id", referencedColumnName = "id", nullable = false)
    private Prescriptionstatus prescriptionstatus;

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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Prescriptionstatus getPrescriptionstatus() {
        return prescriptionstatus;
    }

    public void setPrescriptionstatus(Prescriptionstatus prescriptionstatus) {
        this.prescriptionstatus = prescriptionstatus;
    }

    public Collection<Prescriptiondrug> getPrescriptiondrugs() {
        return prescriptiondrugs;
    }

    public void setPrescriptiondrugs(Collection<Prescriptiondrug> prescriptiondrugs) {
        this.prescriptiondrugs = prescriptiondrugs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescription)) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getAppointment(), that.getAppointment()) && Objects.equals(getPrescriptionstatus(), that.getPrescriptionstatus()) && Objects.equals(getPrescriptiondrugs(), that.getPrescriptiondrugs()) && Objects.equals(getPrescriptionstatus(), that.getPrescriptionstatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getAppointment(), getPrescriptionstatus(), getPrescriptiondrugs(), getPrescriptionstatus());
    }
}
