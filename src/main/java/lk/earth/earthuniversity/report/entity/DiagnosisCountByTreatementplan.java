package lk.earth.earthuniversity.report.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiagnosisCountByTreatementplan {

    @Id
    private Integer id;
    private String  treatmentplan;
    private Long count;

    private double percentage;

    public DiagnosisCountByTreatementplan() {  }

    public DiagnosisCountByTreatementplan(String treatmentplan, Long count) {
        this.treatmentplan = treatmentplan;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTreatmentplan() {
        return treatmentplan;
    }

    public void setTreatmentplan(String treatmentplan) {
        this.treatmentplan = treatmentplan;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
