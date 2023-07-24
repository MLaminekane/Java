package models;

import models.enums.TypesComptes;

public class Cheque extends Compte{
  @Override
  public String consultation() {
    // TODO Auto-generated method stub
    return super.consultation() + "Frais: "+ frais + "]";
  }
  private double frais;

  public Cheque() {
    super();
    super.type = TypesComptes.Cheque;
  }
  public Cheque(int id, double solde, double frais) {
    super(id, solde);
    super.type = TypesComptes.Cheque;
    this.frais = frais;
  }
  public Cheque(double solde, double frais) {
    super(solde);
    super.type = TypesComptes.Cheque;
    this.frais = frais;
  }
  public double getFrais() {
    return frais;
  }
  public void setFrais(double frais) {
    this.frais = frais;
  }
  @Override
  public boolean depot(double montant) {
    // super.solde += montant - frais; //ou solde ou this.solde
    // return true;
    //ou bien
    return super.depot(montant - frais);
  }
  
}

