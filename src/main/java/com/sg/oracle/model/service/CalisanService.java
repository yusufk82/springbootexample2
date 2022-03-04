package com.sg.oracle.model.service;


import com.sg.oracle.model.entity.Calisan;
import com.sg.oracle.utility.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalisanService extends AbstractCalisanService
{
    @Override
    public Calisan idyeGoreBul(String id)
    {
        Calisan calisan = calisanRepository.findById(id).orElseThrow(()
                ->new RuntimeException());

        return calisan;
    }

    @Override
    protected List<Calisan> maasaGoreBul(Double limit)
    {
        return calisanRepository.findByMaasGreaterThan(limit);
    }

    @Override
    public List<Calisan> tumVarliklariCek()
    {
        return calisanRepository.findAll();
    }

    @Override
    public Calisan kaydet(Calisan varlik)
    {
        try
        {
            return  calisanRepository.save(varlik);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralException(e);
            return null;
        }
    }

    @Override
    public Calisan duzenle(Calisan calisan)
    {
        try
        {

            return  calisanRepository.save(calisan);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralException(e) ;
            return null;
        }
    }

    @Override
    public void sil(String id)
    {
        try
        {
            calisanRepository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralException(e);
        }
    }

}
