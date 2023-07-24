package models;

import java.util.ArrayList;

import models.enums.Poste;

public class Admin extends Personne {
    private Poste poste;
    // OneToMany
    private ArrayList<Classe> classes=new ArrayList<>();

    public void addClasse(Classe classe){
        classes.add(classe);
    }
    public Admin(String nomComplet, String tel, Poste poste) {
        super(nomComplet, tel);
        this.poste = poste;
    }
    public Admin(int id, String nomComplet, String tel, Poste poste) {
        super(id, nomComplet, tel);
        this.poste = poste;
    }
    public Admin() {
        // super Représente la classe mère super()=>Personne()
        super();
    }
    public Poste getPoste() {
        return poste;
    }
    public void setPoste(Poste poste) {
        this.poste = poste;
    }
    public ArrayList<Classe> getClasses() {
        return classes;
    }
    @Override
    public String toString() {
        return super.toString()+"[ poste=" + poste + "]";
    }
}
