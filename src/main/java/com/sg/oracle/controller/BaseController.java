package com.sg.oracle.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseController {

    public void mesajYaz( FacesMessage.Severity severity,String ozet,String mesaj) {
        FacesMessage facesMessage=new FacesMessage();
        facesMessage.setSeverity(severity);
        facesMessage.setSummary(ozet);
        facesMessage.setDetail(mesaj);
        FacesContext.getCurrentInstance().addMessage("mesaj",facesMessage);
    }
}
