package com.mycompany.ut2lab2_ad_pablojimenezjorquera;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personaje")
public class Personaje {

    private String nombre;
    private String rango;

    //constructor vacío indispensable para el estándar JavaBean y JAXB
    public Personaje() {
    }

    public Personaje(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
}