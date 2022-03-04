package com.sg.oracle.model.service;


import com.sg.oracle.model.entity.Calisan;
import com.sg.oracle.model.repository.CalisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractCalisanService implements VarlikService<Calisan, String>
{
    @Autowired
    protected CalisanRepository calisanRepository;

    protected abstract List<Calisan> maasaGoreBul(Double limit);


    public abstract Calisan duzenle(Calisan calisan);
}
