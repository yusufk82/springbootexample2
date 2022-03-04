package com.sg.oracle.controller;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuController {

    public String biletAl() {

        return "bus_ticket?faces-redirect=true";
    }

    public String calisanEkle() {

        return "calisanlar?faces-redirect=true";
    }
}
