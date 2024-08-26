package lk.earth.earthuniversity.report.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorCountBySpeciality {


    @Id
    private Integer id;
    private String clinictype;
    private Long count;

    public DoctorCountBySpeciality() {
    }

    public DoctorCountBySpeciality(String clinictype, Long count) {
        this.clinictype = clinictype;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClinictype() {
        return clinictype;
    }

    public void setClinictype(String clinictype) {
        this.clinictype = clinictype;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
