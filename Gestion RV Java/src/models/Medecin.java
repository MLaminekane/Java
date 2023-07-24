package models;

import models.enums.Statut;
import java.util.ArrayList;

public class Medecin extends Personne {
  private String Specialite;
  private ArrayList<Statut> statut = new ArrayList<Statut>();

  public Medecin(String nomComplet, String tel, String specialite) {
    super(nomComplet, tel);
    Specialite = specialite;
  }
  public Medecin(String specialite) {
    Specialite = specialite;
  }
  public Medecin() {
    super();
  }

  public String getSpecialite() {
    return Specialite;
  }

  public void setSpecialite(String specialite) {
    Specialite = specialite;
  }

  public Medecin(int id, String nomComplet, String tel,String Specialite) {
    super(id, nomComplet, tel);
    this.Specialite = Specialite;
  }
  @Override
  public String toString() {
    return super.toString()+ " Specialite=" + Specialite + "]";
  }
}