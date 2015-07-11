package com.example.tizi.vvf;

import java.util.Date;

/**
 * Created by maffo on 15/05/15.
 */
public class Intervento {

    public int numeroProgressivo;
    public boolean dataIntervento;
    public boolean motivoIntervento;
    public boolean noteIntervento;
    public boolean entiIntervenuti;
    public boolean personaleIntervenuto;
    public boolean mezziIntervenuti;
    public boolean anagrafica;
    public boolean orari;

    public Intervento(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
        dataIntervento = false;
        motivoIntervento = false;
        noteIntervento = false;
        entiIntervenuti = false;
        personaleIntervenuto = false;
        mezziIntervenuti = false;
        anagrafica = false;
        orari = false;
    }
    public boolean[] toArray(){
        boolean[] array = new boolean[7];
        array[0] = motivoIntervento;
        array[1] = personaleIntervenuto;
        array[2] = entiIntervenuti;
        array[3] = mezziIntervenuti;
        array[4] = orari;
        array[5] = anagrafica;
        array[6] = noteIntervento;
        return array;
    }
}



