package lk.earth.earthuniversity.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Investigation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "reporteddate")
    private Date reporteddate;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "report")
    private byte[] report;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "conclution")
    private String conclution;

    @ManyToOne
    @JoinColumn(name = "reporttype_id", referencedColumnName = "id", nullable = false)
    private Reporttype reporttype;
    @ManyToOne
    @JoinColumn(name = "investigationstatus_id", referencedColumnName = "id", nullable = false)
    private Investigationstatus investigationstatus;
    @ManyToOne
    @JoinColumn(name = "investigationresult_id", referencedColumnName = "id")
    private Investigationresult investigationresult;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id", nullable = false)
//    private Diagnosis diagnosis;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "diagnosis_id")
//    private Diagnosis diagnosis;

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id", nullable = false)
    private Appointment appointment;

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

    public Date getReporteddate() {
        return reporteddate;
    }

    public void setReporteddate(Date reporteddate) {
        this.reporteddate = reporteddate;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public byte[] getReport() {
        return report;
    }

    public void setReport(byte[] report) {
        this.report = report;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConclution() {
        return conclution;
    }

    public void setConclution(String conclution) {
        this.conclution = conclution;
    }

    public Reporttype getReporttype() {
        return reporttype;
    }

    public void setReporttype(Reporttype reporttype) {
        this.reporttype = reporttype;
    }

    public Investigationstatus getInvestigationstatus() {
        return investigationstatus;
    }

    public void setInvestigationstatus(Investigationstatus investigationstatus) {
        this.investigationstatus = investigationstatus;
    }

    public Investigationresult getInvestigationresult() {
        return investigationresult;
    }

    public void setInvestigationresult(Investigationresult investigationresult) {
        this.investigationresult = investigationresult;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Investigation)) return false;
        Investigation that = (Investigation) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getReporteddate(), that.getReporteddate()) && Objects.equals(getDate(), that.getDate()) && Arrays.equals(getReport(), that.getReport()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getConclution(), that.getConclution()) && Objects.equals(getReporttype(), that.getReporttype()) && Objects.equals(getInvestigationstatus(), that.getInvestigationstatus()) && Objects.equals(getInvestigationresult(), that.getInvestigationresult()) && Objects.equals(getEmployee(), that.getEmployee()) && Objects.equals(getAppointment(), that.getAppointment());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getReporteddate(), getDate(), getDescription(), getConclution(), getReporttype(), getInvestigationstatus(), getInvestigationresult(), getEmployee(), getAppointment());
        result = 31 * result + Arrays.hashCode(getReport());
        return result;
    }
}
