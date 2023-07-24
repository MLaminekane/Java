import java.util.ArrayList;
import java.util.Scanner;


import models.enums.Filiere;
import models.Classe;
import services.*;

public class App {
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int choix;
        InscriptionService inscriptionService=new InscriptionService();
        do{
        clear();
        System.out.println("1...Ajouter une classe");
        System.out.println("2...Lister toutes les classes");
        System.out.println("3...Lister les classes par Filiere");
        System.out.println("4...Faire une Inscription");
        System.out.println("5...Faire une Réinscription");
        System.out.println("6...Lister Les Etudiants D'Une Classe");
        System.out.println("7...Quitter");
        System.out.println("Faites votre choix");
        choix=scanner.nextInt();
        switch(choix){
            case 1:
            clear();
            Classe cl=new Classe();
            scanner.nextLine();
            System.out.println("Entrer une classe");
            cl.setLibelle(scanner.nextLine());
            cl.setFiliere(getFiliere());
            inscriptionService.addClasse(cl);
            clear();
            break;
            case 2:
                clear();
                ArrayList<Classe> classList=inscriptionService.listerClasse();
                classList.forEach(System.out::println);
                System.out.println("Press Any Key To Continue...");
                scanner.next();
                clear();
                break;
            case 3:
                clear();
                Filiere filiere =getFiliere();
                classList=inscriptionService.listerClasse(filiere);
                classList.forEach(System.out::println);
                System.out.println("Press Any Key To Continue...");
                scanner.next();
                clear();
                      
                break;
            
            case 4:
                clear();
                classList=inscriptionService.listerClasse();
                classList.forEach(System.out::println);
                System.out.println("Saisir l'id de la classe");
                int idClasse=scanner.nextInt();
                Classe classe=inscriptionService.searchClasseById(idClasse);
                if(classe !=null){
                    
                }else{
                    System.out.println("Cette classe n'existe pas!!!!");
                }
                clear();
                break;
        }
        }while(choix!=7);
        scanner.close();
    }

    public static void clear(){
        System.out.print("\033[H\033[2J"); 
        System.out.flush();  
    }
    public static Filiere getFiliere(){
        int choix;
        Filiere filiere;
        do{
            System.out.println("Sélectionner une filière");
            System.out.println("1...GLRS\n2...MAIE\n3...ETSE\n4...IAGE");
            choix=scanner.nextInt()-1;
        }while(choix<0 || choix>3);
        switch(choix){
            case 0:
            filiere=Filiere.GLRS;
            break;
            case 1:
            filiere=Filiere.MAIE;
            break;
            case 2:
            filiere=Filiere.ETSE;
            break;
            default:
            filiere=Filiere.IAGE;
            break;
        }
        return filiere;
    }
}
