package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Bank;
import lk.earth.earthuniversity.entity.Prescription;
import lk.earth.earthuniversity.entity.Prescriptionstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrescriptionstatusDao extends JpaRepository<Prescriptionstatus,Integer> {

    @Query(value = "select a  from Prescriptionstatus a where a.id = :id")
    Prescriptionstatus findByMyId(@Param("id") Integer id);

}

