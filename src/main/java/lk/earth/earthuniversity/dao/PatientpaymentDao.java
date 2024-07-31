package lk.earth.earthuniversity.dao;


import lk.earth.earthuniversity.entity.Appointment;
import lk.earth.earthuniversity.entity.Patientpayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Date;

public interface PatientpaymentDao extends JpaRepository<Patientpayment,Integer> {
    @Query(value = "select p  from Patientpayment p where p.id = :id")
    Patientpayment findByMyId(@Param("id") Integer id);

//    @Query(value = "select a  from Patientpayment a where a.number = :number")
//    Patientpayment findByNumber(@Param("number") Integer number);

    @Query(value = "select a  from Patientpayment a where a.date = :date")
    Patientpayment findByDatetime(@Param("date") Timestamp date);

    @Query(value = "select p  from Patientpayment p where p.appointment.id = :id")
    Patientpayment findByAppointment(@Param("id") Integer id);

    @Query(value = "select count(*)  from Patientpayment a where a.appointment.id = :id")
    Long countByClinic(@Param("id") Integer id);



}

