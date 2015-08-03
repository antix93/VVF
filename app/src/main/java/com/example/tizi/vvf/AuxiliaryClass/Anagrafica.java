package com.example.tizi.vvf.AuxiliaryClass;

public class Anagrafica{

    //Properties
    private String richiedente;
    private String proprietario;
    private String affittuario;
    private String altro;
    private boolean compiled;
    //Constructor
    public Anagrafica(){
        this.compiled = false;
        this.richiedente = "";
        this.proprietario = "";
        this.affittuario = "";
        this.altro = "";
    }
    public Anagrafica(String richiedente, String proprietario, String affittuario, String altro) {

        this.richiedente = richiedente;
        this.proprietario = proprietario;
        this.affittuario = affittuario;
        this.altro = altro;
        this.compiled = true;
    }

    //Getters and Setters
    public String getRichiedente() {
        return richiedente;
    }

    public void setRichiedente(String richiedente) {
        this.richiedente = richiedente;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getAffittuario() {
        return affittuario;
    }

    public void setAffittuario(String affittuario) {
        this.affittuario = affittuario;
    }

    public String getAltro() {
        return altro;
    }

    public void setAltro(String altro) {
        this.altro = altro;
    }

    public boolean isCompiled() {
        return compiled;
    }

    public void setCompiled(boolean compiled) {
        this.compiled = compiled;
    }
}
