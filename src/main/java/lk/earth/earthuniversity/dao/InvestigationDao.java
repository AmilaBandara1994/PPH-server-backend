package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Appointment;
import lk.earth.earthuniversity.entity.Investigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvestigationDao extends JpaRepository<Investigation,Integer> {
    @Query(value = "select i  from Investigation i where i.id = :id")
    Investigation findByMyId(@Param("id") Integer id);

    @Query(value = "select i  from Investigation i where i.name = :name")
    Investigation findByName(@Param("name") String name);

//    @Query(value = "select a from Appointment a where a.patient.id = :patientid")
//    List<Appointment> findByPatientId(@Param("patientid") Integer patientid);
//
//
//
//    @Query(value = "select count(*)  from Appointment a where a.clinic.id = :id")
//    Long countByClinic(@Param("id") Integer id);



//    @Query(value = "select d from Doctor d join Doctorclinictype dc on  dc.doctor.id = d.id join Clinictype  c on dc.clinictype.id = c.id where c.id = :id")
//    List<Doctor> findAllDoctorsByCategoryId(@Param("id") Integer id);
//
//    @Query(value = "SELECT d.id FROM Doctor d where d.employee.id = :id")
//    Doctor findDoctorByEmployeeId(@Param("id") int id);
}

