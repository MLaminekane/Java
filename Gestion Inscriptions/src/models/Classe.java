package models;
import java.util.ArrayList;

import models.enums.Filiere;

public class Classe {
    private int id;
    private String libelle;
    private static int nbre;
    private Filiere filiere;
    private Admin admin;
    private ArrayList<Inscription> inscriptions;
    public Classe() {
        nbre++;
    }
    public Classe(String libelle, Filiere filiere) {
        nbre++;
        this.libelle = libelle;
        this.filiere = filiere;
    }
    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Classe [id=" + id + ", libelle=" + libelle + ", filiere=" + filiere + "]";
    }

    public Admin getAdmin() {
        return admin;
    }

    public void addInscription(Inscription inscription){
            this.inscriptions.add(inscription);
    }

    public ArrayList<Etudiant>geEtudiants(){
            ArrayList <Etudiant> et=new ArrayList<>();
            for(Inscription ins: inscriptions){
                et.add(ins.getEtudiant());
            }
            return et;
    }

    public void setAdmin(Admin admin) {
        // Lien Classe vers Admin
        this.admin = admin;
        // 
        admin.addClasse(this);
    }


    
}

