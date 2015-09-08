package com.example.tizi.vvf;

import android.app.Application;
import com.example.tizi.vvf.AuxiliaryClass.Anagrafica;
import com.example.tizi.vvf.AuxiliaryClass.Mezzo;
import com.example.tizi.vvf.AuxiliaryClass.Orario;

/**
 * Created by Maffo on 03/08/2015.
 */

public class InterActivityData extends Application {

    //Properties
    private int motivoIntervento;
    private Mezzo[] mezziIntervento;
    private boolean[] personaleIntervento;
    private boolean[] entiIntervento;
    private String noteIntervento;
    private Anagrafica anagraficaIntervento;
    private Orario orariIntervento;
    private boolean frozen;

    //Getters and Setters
    public int getMotivoIntervento() {
        return motivoIntervento;
    }

    public void setMotivoIntervento(int motivoIntervento) {
        this.motivoIntervento = motivoIntervento;
    }

    public Mezzo[] getMezziIntervento() {
        return mezziIntervento;
    }

    public void setMezziIntervento(Mezzo[] mezziIntervento) {
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

    public Orario getOrariIntervento() {
        return orariIntervento;
    }

    public void setOrariIntervento(Orario orariIntervento) {
        this.orariIntervento = orariIntervento;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean[] getSelectedArray(){
        boolean[]selected = new boolean[7];
        if(this.motivoIntervento != 0)selected[0]=true;
        if(this.personaleIntervento != null)selected[1]=true;
        if(this.entiIntervento != null)selected[2]=true;
        if(this.mezziIntervento != null)selected[3]=true;
        if(this.orariIntervento != null)selected[4]=true;
        if(this.anagraficaIntervento != null)selected[5]=true;
        if(this.noteIntervento != null && !this.noteIntervento.isEmpty())selected[6]=true;
        return selected;
    }

    //methods
    public void resetValues(){
        motivoIntervento = 0;
        mezziIntervento = null;
        personaleIntervento = null;
        entiIntervento = null;
        noteIntervento = "";
        anagraficaIntervento = null;
        orariIntervento = null;
        frozen = false;
    }
}

