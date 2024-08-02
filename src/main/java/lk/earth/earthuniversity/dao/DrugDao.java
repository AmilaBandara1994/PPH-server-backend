package lk.earth.earthuniversity.dao;


import lk.earth.earthuniversity.entity.Drug;
import lk.earth.earthuniversity.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugDao extends JpaRepository<Drug,Integer> {

    @Query(value = "select a  from Drug a where a.id = :id")
    Drug findByMyId(@Param("id") Integer id);

    @Query(value = "select a  from Drug a where a.code =:getcode")
    Drug findByDrugCode(@Param("getcode") String getcode);

    @Query(value = "select a  from Drug a where a.name = :getname")
    Drug findByDrugName( @Param("getname") String getname);


    @Query(value = "select a  from Drug a where a.name = :code   AND   a.name = :name")
    Drug findByDrugCodeName( @Param("code") String code,  @Param("name") String name  );


//    @Query(value = "select a from Drug a where a.patient.id = :patientid")
//    List<Drug> findByPatientId(@Param("patientid") Integer patientid);
//
//
//
//    @Query(value = "select count(*)  from Drug a where a.clinic.id = :id")
//    Long countByClinic(@Param("id") Integer id);

}

