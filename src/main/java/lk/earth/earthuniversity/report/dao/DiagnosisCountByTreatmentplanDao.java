package lk.earth.earthuniversity.report.dao;

import lk.earth.earthuniversity.report.entity.DiagnosisCountByTreatementplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiagnosisCountByTreatmentplanDao extends JpaRepository<DiagnosisCountByTreatementplan,Integer> {

    @Query(value = "SELECT NEW DiagnosisCountByTreatementplan( d.treatmentplan.name, COUNT(d.treatmentplan.name) )  FROM Diagnosis d, Treatmentplan t WHERE d.treatmentplan.id  = t.id GROUP BY t.id")
    List<DiagnosisCountByTreatementplan> diagcountbytret();

}

