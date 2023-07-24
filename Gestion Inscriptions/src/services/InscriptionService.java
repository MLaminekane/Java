package services;

import models.*;
import models.enums.Filiere;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InscriptionService {
    private ArrayList<Classe> classes=new ArrayList<>();
    private ArrayList<Personne> personnes=new ArrayList<>();
    private ArrayList <Inscription> inscriptions=new ArrayList<>();

    public InscriptionService() {
        
    }

    public Personne getPersonnebyTel(String tel){
       return personnes.stream().filter(t->t.getTel()==tel).findFirst()
    .orElse(null);   

    }

    public void addClasse(Classe classe){
        classes.add(classe);
    }
    public ArrayList<Classe> listerClasse(){
        return classes;
    }

    public ArrayList<Classe> listerClasse(Filiere filiere){
        // ArrayList <Classe> listType =new ArrayList<>();
        // // for(Classe cl:classes){
        // //     if (cl.getFiliere() ==filiere){
        // //         listType.add(cl);
        // //     }
        // // }

        return (ArrayList <Classe>) classes.stream().
        filter(cl->cl.getFiliere()==filiere)
        .collect(Collectors.toList());    
    }

    public Classe searchClasseById(int id){
        return classes.stream().filter(cl->cl.getId()==id).findFirst()
        .orElse(null);   
    
    }

    public void saveStudent(Etudiant etudiant){
        personnes.add(etudiant);
    }

    
}
