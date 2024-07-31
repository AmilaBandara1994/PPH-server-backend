package lk.earth.earthuniversity.report.dao;

import lk.earth.earthuniversity.report.entity.ClinicCountByClinictype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClinicCountByClinictypeDao extends JpaRepository<ClinicCountByClinictype,Integer> {

    @Query(value = "SELECT NEW ClinicCountByClinictype( ct.name, COUNT(ct.name) , SUM(c.patientcount))  FROM Clinic c, Clinictype ct  WHERE c.clinictype.id  = ct.id GROUP BY ct.id ORDER BY SUM(c.patientcount)")
    List<ClinicCountByClinictype> clinicCountByClinicType();

}

