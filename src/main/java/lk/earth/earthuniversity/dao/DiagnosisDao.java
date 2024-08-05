package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Diagnosis;
import lk.earth.earthuniversity.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiagnosisDao extends JpaRepository<Diagnosis,Integer> {
    @Query(value = "select a  from Diagnosis a where a.id = :id")
    Diagnosis findByMyId(@Param("id") Integer id);

//    @Query(value = "select a  from Diagnosis a where a.code =:getcode")
//    Diagnosis findByDiagnosisCode(@Param("getcode") String getcode);
//
//    @Query(value = "select a  from Diagnosis a where a.name = :getname")
//    Diagnosis findByDiagnosisName( @Param("getname") String getname);


//    @Query(value = "select a  from Diagnosis a where a.name = :code   AND   a.name = :name")
//    Diagnosis findByDiagnosisCodeName( @Param("code") String code,  @Param("name") String name  );
}

