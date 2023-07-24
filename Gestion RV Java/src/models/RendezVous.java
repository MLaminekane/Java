package models;

import models.enums.Statut;

public class RendezVous {
  private int id;
  private String date;
  private Statut statut;
  private Medecin medecin;
  private Patient patient;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getDate() {
    return date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
  
  public Statut getStatut() {
    return statut;
  }
  
  public void setStatut(Statut statut) {
    this.statut = statut;
    statut.addRendezVous(this);
  }
  
  public Patient getPatient() {
    return patient;
  }
  
  public void setPatient(Patient patient) {
    this.patient = patient;
    patient.addRendezVous(this);
  }
  
  public Medecin getMedecin() {
    return medecin;
  }
  
  public void setMedecin(Medecin medecin) {
    this.medecin = medecin;
  }
  
  @Override
  public String toString() {
    return "RendezVous [id=" + id + ", date=" + date + ", statut=" + statut + ", medecin=" + medecin + ", patient="
        + patient + "]";
  }
  
}
