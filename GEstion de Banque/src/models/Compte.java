package models;

import java.text.DecimalFormat;

import models.enums.TypesComptes;


public abstract class Compte {
  private static int nbrCompte;
  protected int id;
  protected double solde;
  protected String numero; 
  private Client client;
  protected TypesComptes type;
  
  //attributs de relation ou navigationnel
  //many to one de Compte vers Clients
  public Client getClient() {
    return client;
  }
  public void setClient(Client client) {
    this.client = client;
  }
  //Contrutor
  public Compte(double solde) {
    id=++nbrCompte;
    this.solde = solde;
    this.numero = genNumero();
  }
  public Compte(int id, double solde) {
    this.id = id;
    this.solde = solde;
    this.numero = genNumero();
  }
  public Compte() {
    id=++nbrCompte;
    numero = genNumero();
  }
  //Getters and setters
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public double getSolde() {
    return solde;
  }
  public void setSolde(double solde) {
    this.solde = solde;
  }
  public String getNumero() {
    return numero;
  }
  public void setNumero(String numero) {
    this.numero = numero;
  }
  private String genNumero(){
    DecimalFormat df = new DecimalFormat("00000");
    return "CPT"+df.format(id);
  }
  public boolean retrait(double montant) {
    if(montant > solde) return false;
    solde -= montant;
    return true;
  }
  //attributes
  public TypesComptes getType() {
    return type;
  }
  public boolean depot(double montant) {
    solde += montant;
    return true;
  } 
  public boolean virement(double montant, Compte compte) {
    if(this.retrait(montant)){
      return compte.depot(montant);
    }
    return false;
  }
  //tostring sans le overide d'heritage
  public String consultation() {
    return "Compte [id:" + id + ", solde:" + solde + ", numero:" + numero + ", type:" + type + "Client:" + client.getNom() +", "+client.getPrenom()+", "+client.getTel()+ "]";
  }
  //equals
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
    Compte other = (Compte) obj;
    if (numero == null) {
      if (other.numero != null)
        return false;
    } else if (!numero.equals(other.numero))
      return false;
    return true;
  }


}
