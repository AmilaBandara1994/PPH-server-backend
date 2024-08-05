package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Bank;
import lk.earth.earthuniversity.entity.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DosageDao extends JpaRepository<Dosage,Integer> {

}

