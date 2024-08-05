package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Bank;
import lk.earth.earthuniversity.entity.Drugschedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugscheduleDao extends JpaRepository<Drugschedule,Integer> {

}

