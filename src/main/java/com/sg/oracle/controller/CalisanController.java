package com.sg.oracle.controller;

import com.sg.oracle.model.entity.Calisan;
import com.sg.oracle.model.service.AbstractCalisanService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CalisanController extends BaseController{

    private List<Calisan> calisanList=new ArrayList<>();
    private Calisan calisan=new Calisan();

    @Autowired
    private AbstractCalisanService abstractCalisanService;

    public String kaydet(){

        this.abstractCalisanService.kaydet(getCalisan());
        setCalisan(new Calisan());
        mesajYaz(FacesMessage.SEVERITY_INFO,"Kayıt","Çalışan Kaydedildi.");
        return null;
    }

    public List<Calisan> getCalisanList() {
        return calisanList=this.abstractCalisanService.tumVarliklariCek();
    }

    public void setCalisanList(List<Calisan> calisanList) {
        this.calisanList = calisanList;
    }

    public Calisan getCalisan() {
        return calisan;
    }

    public void setCalisan(Calisan calisan) {
        this.calisan = calisan;
    }
}
