package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Appointment;
import lk.earth.earthuniversity.entity.Doctorpayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorpaymentDao extends JpaRepository<Doctorpayment,Integer> {


    @Query(value = "select d  from Doctorpayment d where d.id = :id")
    Doctorpayment findByMyId(@Param("id") Integer id);

//    @Query(value = "select a  from Appointment a where a.number = :number")
//    Appointment findByNumber(@Param("number") String number);
//
//    @Query(value = "select a from Appointment a where a.patient.id = :patientid")
//    List<Appointment> findByPatientId(@Param("patientid") Integer patientid);
//
//
//
//    @Query(value = "select count(*)  from Appointment a where a.clinic.id = :id")
//    Long countByClinic(@Param("id") Integer id);
}

