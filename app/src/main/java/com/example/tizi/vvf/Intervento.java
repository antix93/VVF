package com.example.tizi.vvf;

import java.util.Date;

/**
 * Created by maffo on 15/05/15.
 */
public class Intervento {

    public int numeroProgressivo;
    public Date dataIntervento;
    public String motivoIntervento;
    public String noteIntervento;
    public String[] entiIntervenuti;
    public String[] personaleIntervenuto;
    public String[] mezziIntervenuti;
    public String richiedente;
    public String proprietario;
    public String affittuario;
    public String altro;
    public String orarioUscita;
    public String orarioChiamata;

    public String getMotivoIntervento() {
        return motivoIntervento;
    }

    public void setMotivoIntervento(String motivoIntervento) {
        this.motivoIntervento = motivoIntervento;
    }

    public String getNoteIntervento() {
        return noteIntervento;
    }

    public void setNoteIntervento(String noteIntervento) {
        this.noteIntervento = noteIntervento;
    }

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

    public String getOrarioUscita() {
        return orarioUscita;
    }

    public void setOrarioUscita(String orarioUscita) {
        this.orarioUscita = orarioUscita;
    }

    public String getOrarioChiamata() {
        return orarioChiamata;
    }

    public void setOrarioChiamata(String orarioChiamata) {
        this.orarioChiamata = orarioChiamata;
    }

    public String getOrarioArrivo() {
        return orarioArrivo;
    }

    public void setOrarioArrivo(String orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
    }

    public String getOrarioPartenza() {
        return orarioPartenza;
    }

    public void setOrarioPartenza(String orarioPartenza) {
        this.orarioPartenza = orarioPartenza;
    }

    public String getOrarioRientro() {
        return orarioRientro;
    }

    public void setOrarioRientro(String orarioRientro) {
        this.orarioRientro = orarioRientro;
    }

    public String orarioArrivo;
    public String orarioPartenza;
    public String orarioRientro;

    public int getNumeroProgressivo() {
        return numeroProgressivo;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    public Date getDataIntervento() {
        return dataIntervento;
    }

    public void setDataIntervento(Date dataIntervento) {
        this.dataIntervento = dataIntervento;
    }

    public String[] getEntiIntervenuti() {
        return entiIntervenuti;
    }

    public void setEntiIntervenuti(String[] entiIntervenuti) {
        this.entiIntervenuti = entiIntervenuti;
    }

    public String[] getPersonaleIntervenuto() {
        return personaleIntervenuto;
    }

    public void setPersonaleIntervenuto(String[] personaleIntervenuto) {
        this.personaleIntervenuto = personaleIntervenuto;
    }

    public String[] getMezziIntervenuti() {
        return mezziIntervenuti;
    }

    public void setMezziIntervenuti(String[] mezziIntervenuti) {
        this.mezziIntervenuti = mezziIntervenuti;
    }
}
