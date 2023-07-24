package models;
import java.util.ArrayList;
import models.enums.Statut;

public class hopital {
  private Statut statut;

  public Statut getStatut() {
    return statut;
  }


  public void setStatut(Statut statut) {
    this.statut = statut;
  }


  private ArrayList<RendezVous> rendezVous;


  public hopital(Statut statut, ArrayList<RendezVous> rendezVous) {
    this.statut = statut;
    this.rendezVous = rendezVous;
  }


  public void addRendezVous(RendezVous rendezVous){

    this.rendezVous.add(rendezVous);
  }
}
