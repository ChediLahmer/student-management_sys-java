package com.example.dualist;


import java.time.LocalDate;
import java.util.Date;

public class babsence {
    private int idenseignant;
    private int idetudiant;
    private int idmatiere;
    private  int numseance;
    private LocalDate date;

    public babsence(int idetudiant, int idenseignant, int idmatiere, int numseance, LocalDate date) {
        this.idenseignant = idenseignant;
        this.idetudiant = idetudiant;
        this.idmatiere = idmatiere;
        this.numseance = numseance;
        this.date = date;
    }

    public int getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(int idetudiant) {
        this.idetudiant = idetudiant;
    }

    public int getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(int idenseignant) {
        this.idenseignant = idenseignant;
    }

    public int getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(int idmatiere) {
        this.idmatiere = idmatiere;
    }

    public int getNumseance() {
        return numseance;
    }

    public void setNumseance(int numseance) {this.numseance = numseance;}
    public LocalDate getDate() {  return date; }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
