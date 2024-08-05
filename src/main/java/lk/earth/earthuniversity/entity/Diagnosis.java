package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Diagnosis {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "onsetduration")
    private String onsetduration;
    @Basic
    @Column(name = "disease")
    private String disease;
    @Basic
    @Column(name = "bpllevel")
    private String bpllevel;
    @Basic
    @Column(name = "bloodpresure")
    @Pattern(regexp = "^\\d+(\\s+)?[A-Z]+||[A-Z][a-z]$", message = "Invalid Number")
    private String bloodpresure;
    @Basic
    @Column(name = "heartrate")
    @Pattern(regexp = "^\\d+(\\s+)?[A-Z]+||[A-Z][a-z]$", message = "Invalid Number")
    private String heartrate;
    @Basic
    @Column(name = "temperature")
    @Pattern(regexp = "^\\d+(\\s+)?[A-Z]+||[A-Z][a-z]$", message = "Invalid Number")
    private String temperature;
    @Basic
    @Column(name = "respiratoryreate")
    @Pattern(regexp = "^\\d+(\\s+)?[A-Z]+||[A-Z][a-z]$", message = "Invalid Number")
    private String respiratoryreate;
    @Basic
    @Column(name = "height")
    @Pattern(regexp = "^\\d+(\\s+)?[A-Z]+||[A-Z][a-z]$", message = "Invalid Number")
    private String height;
    @Basic
    @Column(name = "weight")
    @Pattern(regexp = "^\\d+(\\s+)?[A-Z]+||[A-Z][a-z]$", message = "Invalid Number")
    private String weight;
    @Basic
    @Column(name = "examination")
    private String examination;
    @Basic
    @Column(name = "allergy")
    private String allergy;
    @Basic
    @Column(name = "medicalhistory")
    private String medicalhistory;
    @Basic
    @Column(name = "surgicalhistory")
    private String surgicalhistory;
    @Basic
    @Column(name = "doctornote")
    private String doctornote;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "time")
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id", nullable = false)
    private Appointment appointment;
    @ManyToOne
    @JoinColumn(name = "severity_id", referencedColumnName = "id", nullable = false)
    private Severity severity;
    @ManyToOne
    @JoinColumn(name = "treatmentplan_id", referencedColumnName = "id", nullable = false)
    private Treatmentplan treatmentplan;
    @ManyToOne
    @JoinColumn(name = "diagnosisstatus_id", referencedColumnName = "id", nullable = false)
    private Diagnosisstatus diagnosisstatus;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "diagnosis_id")
    private Collection<Diseasediagnosis> diseasediagnoses;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "diagnosis_id")
    private Collection<Symptomsdiagnosis> symptomsdiagnoses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "diagnosis_id")
    private Collection<Allergydiagnosis> allergydiagnoses;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOnsetduration() {
        return onsetduration;
    }

    public void setOnsetduration(String onsetduration) {
        this.onsetduration = onsetduration;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getBpllevel() {
        return bpllevel;
    }

    public void setBpllevel(String bpllevel) {
        this.bpllevel = bpllevel;
    }

    public String getBloodpresure() {
        return bloodpresure;
    }

    public void setBloodpresure(String bloodpresure) {
        this.bloodpresure = bloodpresure;
    }

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getRespiratoryreate() {
        return respiratoryreate;
    }

    public void setRespiratoryreate(String respiratoryreate) {
        this.respiratoryreate = respiratoryreate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }

    public void setMedicalhistory(String medicalhistory) {
        this.medicalhistory = medicalhistory;
    }

    public String getSurgicalhistory() {
        return surgicalhistory;
    }

    public void setSurgicalhistory(String surgicalhistory) {
        this.surgicalhistory = surgicalhistory;
    }

    public String getDoctornote() {
        return doctornote;
    }

    public void setDoctornote(String doctornote) {
        this.doctornote = doctornote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Treatmentplan getTreatmentplan() {
        return treatmentplan;
    }

    public void setTreatmentplan(Treatmentplan treatmentplan) {
        this.treatmentplan = treatmentplan;
    }

    public Diagnosisstatus getDiagnosisstatus() {
        return diagnosisstatus;
    }

    public void setDiagnosisstatus(Diagnosisstatus diagnosisstatus) {
        this.diagnosisstatus = diagnosisstatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Collection<Diseasediagnosis> getDiseasediagnoses() {
        return diseasediagnoses;
    }

    public void setDiseasediagnoses(Collection<Diseasediagnosis> diseasediagnoses) {
        this.diseasediagnoses = diseasediagnoses;
    }

    public Collection<Symptomsdiagnosis> getSymptomsdiagnoses() {
        return symptomsdiagnoses;
    }

    public void setSymptomsdiagnoses(Collection<Symptomsdiagnosis> symptomsdiagnoses) {
        this.symptomsdiagnoses = symptomsdiagnoses;
    }

    public Collection<Allergydiagnosis> getAllergydiagnoses() {
        return allergydiagnoses;
    }

    public void setAllergydiagnoses(Collection<Allergydiagnosis> allergydiagnoses) {
        this.allergydiagnoses = allergydiagnoses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis)) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return Objects.equals(getId(), diagnosis.getId()) && Objects.equals(getOnsetduration(), diagnosis.getOnsetduration()) && Objects.equals(getDisease(), diagnosis.getDisease()) && Objects.equals(getBpllevel(), diagnosis.getBpllevel()) && Objects.equals(getBloodpresure(), diagnosis.getBloodpresure()) && Objects.equals(getHeartrate(), diagnosis.getHeartrate()) && Objects.equals(getTemperature(), diagnosis.getTemperature()) && Objects.equals(getRespiratoryreate(), diagnosis.getRespiratoryreate()) && Objects.equals(getHeight(), diagnosis.getHeight()) && Objects.equals(getWeight(), diagnosis.getWeight()) && Objects.equals(getExamination(), diagnosis.getExamination()) && Objects.equals(getAllergy(), diagnosis.getAllergy()) && Objects.equals(getMedicalhistory(), diagnosis.getMedicalhistory()) && Objects.equals(getSurgicalhistory(), diagnosis.getSurgicalhistory()) && Objects.equals(getDoctornote(), diagnosis.getDoctornote()) && Objects.equals(getDescription(), diagnosis.getDescription()) && Objects.equals(getTime(), diagnosis.getTime()) && Objects.equals(getAppointment(), diagnosis.getAppointment()) && Objects.equals(getSeverity(), diagnosis.getSeverity()) && Objects.equals(getTreatmentplan(), diagnosis.getTreatmentplan()) && Objects.equals(getDiagnosisstatus(), diagnosis.getDiagnosisstatus()) && Objects.equals(getEmployee(), diagnosis.getEmployee()) && Objects.equals(getDiseasediagnoses(), diagnosis.getDiseasediagnoses()) && Objects.equals(getSymptomsdiagnoses(), diagnosis.getSymptomsdiagnoses()) && Objects.equals(getAllergydiagnoses(), diagnosis.getAllergydiagnoses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOnsetduration(), getDisease(), getBpllevel(), getBloodpresure(), getHeartrate(), getTemperature(), getRespiratoryreate(), getHeight(), getWeight(), getExamination(), getAllergy(), getMedicalhistory(), getSurgicalhistory(), getDoctornote(), getDescription(), getTime(), getAppointment(), getSeverity(), getTreatmentplan(), getDiagnosisstatus(), getEmployee(), getDiseasediagnoses(), getSymptomsdiagnoses(), getAllergydiagnoses());
    }
}
