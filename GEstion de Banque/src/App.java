import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Cheque;
import models.Client;
import models.Compte;
import models.Epargne;
import models.enums.TypesComptes;
import services.ComptesServices;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);
        ComptesServices comptesServices = new ComptesServices();
        int choix;
        do {
            System.out.println("1. Ajouter Client");
            System.out.println("2. Lister Clients");
            System.out.println("3. Ajouter Compte");
            System.out.println("4. Lister Comptes");
            System.out.println("5. Lister Les Comptes Par Type");
            System.out.println("6. Faire Une Operation");
            System.out.println("6. Quitter");
            System.out.println("Faites Votre Choix: ");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    sc.nextLine();
                    Client client = new Client();
                    System.out.println("Entrer le nom:");
                    client.setNom(sc.nextLine());
                    System.out.println("Entrer le prenom:");
                    client.setPrenom(sc.nextLine());
                    System.out.println("Entrer le tel:");
                    client.setTel(sc.nextLine());
                    comptesServices.addClient(client);
                    break;
                case 2:
                    ArrayList<Client> clients = comptesServices.listerClients();
                    clients.forEach(System.out::println);
                    break;
                case 3:
                    Compte compte;
                    int choixType;
                    TypesComptes type;
                    System.out.println("Entrer l'id du Client: ");
                    client = comptesServices.getClientById(sc.nextInt());
                    if  (client == null){
                        System.out.println("Client non trouve");
                    }else{
                        System.out.println("Entrer le solde:");
                        double solde = sc.nextDouble();
                        do {
                            System.out.println("Le Type: ");
                            System.out.println("    Epargne: ");
                            System.out.println("    Cheque: ");
                            choixType = sc.nextInt();
                        } while (choixType<1 || choixType>2);
                        type = choixType == 1 ? TypesComptes.Epargne : TypesComptes.Cheque;
                        if (type == TypesComptes.Cheque){
                            System.out.println("Entrer les frais: ");
                            double frais = sc.nextDouble();
                            compte = new Cheque(solde, frais);
                        }
                        else{
                            sc.nextLine();
                            compte = new Epargne(solde);
                            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            System.out.println("Entrer Date Debut Blocage");
                            LocalDate dateDebut = LocalDate.parse(sc.nextLine(),dt);
                            System.out.println("Entrer Date Fin Blocage");
                            LocalDate dateFin = LocalDate.parse(sc.nextLine(),dt);
                            ((Epargne)compte).setDateDebutBlocage(dateDebut);
                            ((Epargne)compte).setDateFinBlocage(dateFin);
                        }
                        client.addCompte(compte);
                        compte.setClient(client);
                        comptesServices.addCompte(compte);
                    }
                    break;
                case 4:
                    ArrayList<Compte> comptes = comptesServices.listerComptes();
                    comptes.forEach(c->{
                        System.out.println(c.consultation());
                    });
                    break;
                case 5:
                    do {
                        System.out.println("Le Type: ");
                        System.out.println("    Epargne: ");
                        System.out.println("    Cheque: ");
                        choixType = sc.nextInt();
                    } while (choixType<1 || choixType>2);
                    type = choixType == 1 ? TypesComptes.Epargne : TypesComptes.Cheque;
                    comptesServices.listerComptes().stream().
                                    filter(c->c.getType()==type).
                                    collect(Collectors.toList()).
                                    forEach(System.out::println);;
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Entrer le Numero du Compte");
                    compte = comptesServices.getCompteByNumero(sc.nextLine());
                    if (compte==null){
                        System.out.println("Compte Inexistant");
                    }else{
                        do {
                            System.out.println("Entrer L'Operation: ");
                            System.out.println("    1: Depot");
                            System.out.println("    2: Retrait");
                            System.out.println("    3: Virement");
                            choixType = sc.nextInt();
                        } while (choixType<1 || choixType>3);
                        System.out.println("Entrer Le Montant: ");
                        double montant = sc.nextDouble();
                        if  (choixType==1){
                            compte.depot(montant);

                        }else if (choixType==2){
                            if (compte.retrait(montant)){
                                System.out.println("Retrait avec Succes");
                            }else{
                                System.out.println("Retrait Impossible");
                            }
                        }else{
                            compte.virement(montant, compte);
                        }
                    }
                    break;
            }   
        } while (choix!=7);
        sc.close();
    }
}