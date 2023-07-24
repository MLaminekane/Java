import java.util.*;
import models.enums.*;
import java.util.ArrayList;
import services.*;
import models.*;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int choix;
        RendezVousServices rendezVousServices = new RendezVousServices();
        do {
            System.out.println("1-Ajouter un Patient");
            System.out.println("2-Lister les Patients");
            System.out.println("3-Ajouter un Medecin ");
            System.out.println("4-Lister les Medecins");
            System.out.println("5-Ajouter un Rendez-vous");
            System.out.println("6-Lister les rendez-vous d'un Patient");
            System.out.println("7-Lister les rendez-vous d'un Medecin");
            System.out.println("8-Annuler Rendez-vous");
            System.out.println("9-Quitter");
            System.out.print("Faites votre choix");
            choix = sc.nextInt();
            switch(choix){
                case 1:
                    Patient patient = new Patient();
                    System.out.println("Entrez le nom complet du patient:");
                    sc.nextLine();
                    patient.setNomComplet(sc.nextLine());
                    System.out.println("Entrez le numero de telephone du patient:");
                    patient.setTel(sc.nextLine());
                    System.out.println("Entrez l'adresse du patient:");
                    patient.setAddress(sc.nextLine());
                    rendezVousServices.addPersonne(patient);
                    System.out.println("Patient ajoute avec succes: " + patient);
                    break;
                case 2:
                    System.out.println("2-Lister les Patients");
                    ArrayList<Patient> patientList = rendezVousServices.ListerPatient();
                    patientList.forEach(System.out::println);
                    break;
                case 3:
                    Medecin medecin = new Medecin();
                    System.out.println("Entrez le nom complet du Medecin:");
                    sc.nextLine();
                    medecin.setNomComplet(sc.nextLine());
                    System.out.println("Entrez le numero de telephone du medecin:");
                    medecin.setTel(sc.nextLine());
                    System.out.println("Specialite du medecin: ");
                    medecin.setSpecialite(getSpecialite());
                    rendezVousServices.addPersonne(medecin);
                    System.out.println("Patient ajoute avec succes: " + medecin);
                case 9:
                    System.out.println("Bye");
                    System.exit(9);
                default:
                    System.out.println("choix invalide");
                    break;
            } 
        } while (choix!=9);
    }
    public static Statut getStatut(){
        int choix;
        Statut statut;
        do{
            System.out.println("Sélectionner un votre status: ");
            System.out.println("1-En_Cours \n 2-Accepted \n 3-Refused");
            choix=sc.nextInt()-1;
        }while(choix<1 || choix>2);
        switch(choix){
            case 1:
                statut = Statut.En_Cours;
            break;
            case 2:
                statut = Statut.Accepted;
            break;
            default:
                statut = Statut.Refused;
            break;
        }
        return statut;
    }
    
    public static Specialite getSpecialite(){
        int choix;
        Specialite specialite;
        do{
            System.out.println("Sélectionner un votre status: ");
            System.out.println("1-Ophtalmologue \n 2-Dentiste \n 3-Cardiologue");
            choix=sc.nextInt()-1;
        }while(choix<1 || choix>2);
        switch(choix){
            case 1:
                specialite = Specialite.Ophtalmologue;
            break;
            case 2:
                specialite = Specialite.Dentiste;
            break;
            default:
                specialite = Specialite.Cardiologue;
            break;
        }
        return specialite;
    }
}
