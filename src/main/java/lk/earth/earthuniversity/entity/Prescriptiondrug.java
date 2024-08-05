package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Prescriptiondrug {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "dose")
    private String dose;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "days")
    private Integer days;
//    @ManyToOne
//    @JoinColumn(name = "prescription_id", referencedColumnName = "id", nullable = false)
//    private Prescription prescription;
    @ManyToOne
    @JoinColumn(name = "drug_id", referencedColumnName = "id", nullable = false)
    private Drug drug;
    @ManyToOne
    @JoinColumn(name = "drugschedule_id", referencedColumnName = "id", nullable = false)
    private Drugschedule drugschedule;
    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "id", nullable = false)
    private Meal meal;
    @ManyToOne
    @JoinColumn(name = "dosage_id", referencedColumnName = "id", nullable = false)
    private Dosage dosage;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Drugschedule getDrugschedule() {
        return drugschedule;
    }

    public void setDrugschedule(Drugschedule drugschedule) {
        this.drugschedule = drugschedule;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescriptiondrug)) return false;
        Prescriptiondrug that = (Prescriptiondrug) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDose(), that.getDose()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDays(), that.getDays()) && Objects.equals(getDrug(), that.getDrug()) && Objects.equals(getDrugschedule(), that.getDrugschedule()) && Objects.equals(getMeal(), that.getMeal()) && Objects.equals(getDosage(), that.getDosage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDose(), getDescription(), getDays(), getDrug(), getDrugschedule(), getMeal(), getDosage());
    }
}
