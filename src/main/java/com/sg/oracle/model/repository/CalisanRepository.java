package com.sg.oracle.model.repository;


import com.sg.oracle.model.entity.Calisan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalisanRepository extends JpaRepository<Calisan, String>
{
    // SELECT * FROM CALISANLAR WHERE MAAS > 7000;
    List<Calisan> findByMaasGreaterThan(Double upperLimit);

    // SELECT * FROM CALISANLAR WHERE MAAS >= 7000;
    List<Calisan> findByMaasGreaterThanEqual(Double upperLimit);
}
