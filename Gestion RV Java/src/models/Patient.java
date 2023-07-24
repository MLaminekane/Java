package models;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Personne {
  private String Address;
  private List<RendezVous> rendezVous;

  public Patient(String nomComplet, String tel, String address) {
    super(nomComplet, tel);
    this.Address = address;
    this.rendezVous = new ArrayList<>();
  }

  public Patient(int id, String nomComplet, String tel, String address) {
    super(id, nomComplet, tel);
    this.Address = address;
    this.rendezVous = new ArrayList<>();
  }

  public Patient() {
    super();
    this.rendezVous = new ArrayList<>();
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    this.Address = address;
  }

  public void addRendezVous(RendezVous rendezVous) {
    this.rendezVous.add(rendezVous);
  }

  public List<RendezVous> getRendezVous() {
    return rendezVous;
  }

  public void setRendezVous(List<RendezVous> rendezVous) {
    this.rendezVous = rendezVous;
  }

  @Override
  public String toString() {
    return super.toString() + " Address=" + Address + ", rendezVous=" + rendezVous + "]";
  }

}