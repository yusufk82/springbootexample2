package com.sg.oracle.model.entity;



import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "CALISANLAR")
public class Calisan
{


    @Column(name = "CALISAN_ID")
    private int calisanID;

    @Column(name = "ADI")
    private String isim;

    @Column(name = "SOYADI")
    private String soyisim;

    private double maas;

    @Temporal(TemporalType.DATE)
    @Column(name = "ISE_GIRIS_TARIHI")
    private Date iseGirisTarihi;

    @Id
    @Column(name = "TCKN",length = 11)
    private String tckn;


    public int getCalisanID() {
        return calisanID;
    }

    public void setCalisanID(int calisanID) {
        this.calisanID = calisanID;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public Date getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(Date iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calisan calisan = (Calisan) o;
        return calisanID == calisan.calisanID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(calisanID);
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanID=" + calisanID +
                ", isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", maas=" + maas +
                ", iseGirisTarihi=" + iseGirisTarihi +
                '}';
    }
}
