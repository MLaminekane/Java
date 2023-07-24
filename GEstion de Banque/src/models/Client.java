package models;

import java.util.ArrayList;

public class Client {
  private static int nbrClient; 
  private int id;
  private String nom;
  private String prenom;
  private String tel;

  //one to many Client vers Comptes
  private ArrayList<Compte> comptes = new ArrayList<>();
  public void addCompte(Compte compte) {
    comptes.add(compte);
  }
  //Constructor
  public Client(String nom, String prenom, String tel) {
    this.nom = nom;
    this.prenom = prenom;
    this.tel = tel;
    id =++ nbrClient; 
  }
  public Client(int id, String nom, String prenom, String tel) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.tel = tel;
  }
  //Getters and setters
  public Client() {
    id=++nbrClient;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
  public String getPrenom() {
    return prenom;
  }
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  //tostring
  @Override
  public String toString() {
    return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + "]";
  }
  //equal
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Client other = (Client) obj;
    if (id != other.id)
      return false;
    return true;
  }
}