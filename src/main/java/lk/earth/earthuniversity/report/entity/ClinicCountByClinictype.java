package lk.earth.earthuniversity.report.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClinicCountByClinictype {

    @Id
    private Integer id;
    private String clinicType;
    private Long clinicCount;
    private Long patientCount;

    public ClinicCountByClinictype() {  }

    public ClinicCountByClinictype(String clinicType, Long clinicCount, Long patientCount) {
        this.clinicType = clinicType;
        this.clinicCount = clinicCount;
        this.patientCount = patientCount;
    }

    public String getClinicType() {
        return  clinicType;
    }
    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }
    public Long getClinicCount() {
        return clinicCount;
    }
    public void setClinicCount(Long clinicCount) {
        this.clinicCount = clinicCount;
    }
    public Long getPatientCount() {
        return patientCount;
    }
    public void setPatientCount(Long patientCount) {
        this.patientCount = patientCount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
