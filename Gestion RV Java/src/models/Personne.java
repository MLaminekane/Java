package models;

public class Personne {
  protected int id;
  protected static int nb;
  protected String nomComplet;
  protected String tel;

  public Personne() {
    nb++;
    this.id = nb;
  }

  public Personne(String nomComplet, String tel) {
    nb++;
    this.id = nb;
    this.nomComplet = nomComplet;
    this.tel = tel;
  }

  public Personne(int id, String nomComplet, String tel) {
    this.id = id;
    this.nomComplet = nomComplet;
    this.tel = tel;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNomComplet() {
    return nomComplet;
  }
  public void setNomComplet(String nomComplet) {
    this.nomComplet = nomComplet;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  @Override
  public String toString() {
    return "Personne [id=" + id + ", nomComplet=" + nomComplet + ", tel=" + tel + "]";
  }
  public Object getStatut() {
    return null;
  }
  
}
