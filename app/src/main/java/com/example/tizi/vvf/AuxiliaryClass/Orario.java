package com.example.tizi.vvf.AuxiliaryClass;

public class Orario{

    //Properties
    private String orarioUscita;
    private String orarioArrivo;
    private String orarioChiamata;
    private String orarioRientro;

    //Constructor
    public Orario(String orarioUscita, String orarioArrivo, String orarioChiamata, String orarioRientro) {
        this.orarioUscita = orarioUscita;
        this.orarioArrivo = orarioArrivo;
        this.orarioChiamata = orarioChiamata;
        this.orarioRientro = orarioRientro;
    }


    //Getters and Setters
    public String getOrarioUscita() {
        return orarioUscita;
    }

    public void setOrarioUscita(String orarioUscita) {
        this.orarioUscita = orarioUscita;
    }

    public String getOrarioArrivo() {
        return orarioArrivo;
    }

    public void setOrarioArrivo(String orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
    }

    public String getOrarioChiamata() {
        return orarioChiamata;
    }

    public void setOrarioChiamata(String orarioChiamata) {
        this.orarioChiamata = orarioChiamata;
    }

    public String getOrarioRientro() {
        return orarioRientro;
    }

    public void setOrarioRientro(String orarioRientro) {
        this.orarioRientro = orarioRientro;
    }


}
