package models;

import java.util.ArrayList;

public class Etudiant extends Personne {
   private String tuteur;
   private ArrayList <Inscription> inscriptions=new ArrayList<>();

   public Etudiant(int id, String nomComplet, String tel, String tuteur) {
    super(id, nomComplet, tel);
    this.tuteur = tuteur;
}



public Etudiant(String nomComplet, String tel, String tuteur) {
    super(nomComplet, tel);
    this.tuteur = tuteur;
}

public Etudiant(){
    super();
   }

public String getTuteur() {
    return tuteur;
}

public void setTuteur(String tuteur) {
    this.tuteur = tuteur;
}

public void addInscription(Inscription inscription){
    inscriptions.add(inscription);
}
public ArrayList<Inscription> getInscriptions() {
    return inscriptions;
}

@Override
public String toString() {
    return super.toString()+ "[,  tuteur=" + tuteur + "]";
}

   
}
