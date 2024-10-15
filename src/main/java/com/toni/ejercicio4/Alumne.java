package com.toni.ejercicio4;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Alumne {

    private int id;
    private String nom;
    private String cognom;
    private String curs;


    public Alumne(int id, String nom, String cognom, String curs) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.curs = curs;
    }

    public Alumne(){

    }

@XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement
    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    @XmlElement
    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }
}
