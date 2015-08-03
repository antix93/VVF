package com.example.tizi.vvf;
import android.app.Application;

import com.example.tizi.vvf.AuxiliaryClass.Anagrafica;
import com.example.tizi.vvf.AuxiliaryClass.Orario;

/**
 * Created by Maffo on 03/08/2015.
 */

public class InterActivityData extends Application {

    //Properties
    private int motivoIntervento;
    private boolean[] mezziIntervento;
    private boolean[] personaleIntervento;
    private boolean[] entiIntervento;
    private String noteIntervento;
    private Anagrafica anagraficaIntervento;
    private Orario orariIntervento;

    //Getters and Setters
    public int getMotivoIntervento() {
        return motivoIntervento;
    }

    public void setMotivoIntervento(int motivoIntervento) {
        this.motivoIntervento = motivoIntervento;
    }

    public boolean[] getMezziIntervento() {
        return mezziIntervento;
    }

    public void setMezziIntervento(boolean[] mezziIntervento) {
        this.mezziIntervento = mezziIntervento;
    }

    public boolean[] getPersonaleIntervento() {
        return personaleIntervento;
    }

    public void setPersonaleIntervento(boolean[] personaleIntervento) {
        this.personaleIntervento = personaleIntervento;
    }

    public boolean[] getEntiIntervento() {
        return entiIntervento;
    }

    public void setEntiIntervento(boolean[] entiIntervento) {
        this.entiIntervento = entiIntervento;
    }

    public String getNoteIntervento() {
        return noteIntervento;
    }

    public void setNoteIntervento(String noteIntervento) {
        this.noteIntervento = noteIntervento;
    }

    public Anagrafica getAnagraficaIntervento() {
        return anagraficaIntervento;
    }

    public void setAnagraficaIntervento(Anagrafica anagraficaIntervento) {
        this.anagraficaIntervento = anagraficaIntervento;
    }



}

