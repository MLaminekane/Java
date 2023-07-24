package models;

import java.time.LocalDate;

import models.enums.TypesComptes;

public class Epargne extends Compte{
  @Override
  public String consultation() {
    // TODO Auto-generated method stub
    return super.consultation()+","+ " Date Debut de Blocage: "+ dateDebutBlocage + "," + " Date Fin de Blocage: "+ dateFinBlocage + "]";
  }
  private final double taux = 0.5;
  private LocalDate dateDebutBlocage;
  private LocalDate dateFinBlocage;

  public Epargne(double solde, LocalDate dateDebutBlocage, LocalDate dateFinBlocage) {
    super(solde);
    super.type = TypesComptes.Epargne;
    this.dateDebutBlocage = dateDebutBlocage;
    this.dateFinBlocage = dateFinBlocage;
  }
  public Epargne(int id, double solde, LocalDate dateDebutBlocage, LocalDate dateFinBlocage) {
    super(id, solde);
    super.type = TypesComptes.Epargne;
    this.dateDebutBlocage = dateDebutBlocage;
    this.dateFinBlocage = dateFinBlocage;
  }
  public Epargne() {
    super.type = TypesComptes.Epargne;
  }
  public Epargne(double solde) {
    super(solde);
    super.type = TypesComptes.Epargne;
  }
  public double getTaux() {
    return taux;
  }
  public LocalDate getDateDebutBlocage() {
    return dateDebutBlocage;
  }
  public void setDateDebutBlocage(LocalDate dateDebutBlocage) {
    this.dateDebutBlocage = dateDebutBlocage;
  }
  public LocalDate getDateFinBlocage() {
    return dateFinBlocage;
  }
  public void setDateFinBlocage(LocalDate dateFinBlocage) {
    this.dateFinBlocage = dateFinBlocage;
  }
  @Override
  public boolean depot(double montant) {
    if (dateDebutBlocage.isBefore(LocalDate.now()) && dateFinBlocage.isAfter(LocalDate.now())){
      return false;
    }
    return super.depot(montant);
  }
  @Override
  public boolean retrait(double montant) {
    if (dateDebutBlocage.isBefore(LocalDate.now()) && dateFinBlocage.isAfter(LocalDate.now())){
      return false;
    }    return super.retrait(montant);
  }
}