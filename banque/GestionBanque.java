package banque;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionBanque {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Compte> comptes = new ArrayList<>();

    while (true) {
        System.out.println("1- Ajouter un client");
        System.out.println("2- Lister les clients");
        System.out.println("3- Afficher un client par telephone");
        System.out.println("4- Creer un compte");
        System.out.println("5- Lister les comptes");
        System.out.println("6- Afficher les comptes d'un client");
        System.out.println("7- Faire une transaction");
        System.out.println("8- Quitter");
        System.out.print("Entrez votre choix : ");
        int choix = sc.nextInt();
        System.out.print("\033[H\033[2J"); // clear console
        System.out.flush(); // clear console

        switch (choix) {
            case 1:
                ajouterClient(clients, sc);
                break;
            case 2:
                listerClients(clients);
                break;
            case 3:
                afficherClientParTelephone(clients, sc);
                break;
            case 4:
                creerCompte(comptes, clients, sc);
                break;
            case 5:
                listerComptes(comptes);
                break;
            case 6:
                afficherComptesClient(comptes, clients, sc);
                break;
            case 7:
                faireTransaction(comptes, sc);
                break;
            case 8:
                System.out.println("Au revoir!");
                System.exit(0);
            default:
                System.out.println("Choix invalide!");
                break;
        }
    }
  }

  private static void ajouterClient(ArrayList<Client> clients, Scanner sc) {
    System.out.print("Entrez le nom du client : ");
    String nom = sc.next();
    System.out.print("Entrez le prénom du client : ");
    String prenom = sc.next();
    System.out.print("Entrez l'adresse du client : ");
    String adresse = sc.next();
    System.out.print("Entrez le téléphone du client : ");
    String telephone = sc.next();
    Client client = new Client(nom, prenom, adresse, telephone);
    clients.add(client);
    System.out.println("Le client a été ajouté avec succès!");
  }

  private static void listerClients(ArrayList<Client> clients) {
    System.out.println("Liste des clients :");
    for (Client client : clients) {
        System.out.println(client.toString());
    }
  }

  private static void afficherClientParTelephone(ArrayList<Client> clients, Scanner sc) {
    System.out.print("Entrez le téléphone du client : ");
    String telephone = sc.next();
    for (Client client : clients) {
        if (client.getTelephone().equals(telephone)) {
            System.out.println(client.toString());
            return;
        }
    }
    System.out.println("Aucun client n'a été trouvé avec ce numéro de téléphone.");
  }

  private static void creerCompte(ArrayList<Compte> comptes, ArrayList<Client> clients, Scanner sc) {
    System.out.print("Entrez le numéro du client : ");
    int numClient = sc.nextInt();
    Client client = clients.get(numClient - 1);
    System.out.print("Entrez le solde initial du compte : ");
    double solde = sc.nextDouble();
    Compte compte = new Compte(client, solde);
    comptes.add(compte);
    System.out.println("Le compte a été créé avec succès!");
  }
  
  private static void listerComptes(ArrayList<Compte> comptes) {
    System.out.println("Liste des comptes :");
    for (Compte compte : comptes) {
        System.out.println(compte.toString());
    }
  }
  
  private static void afficherComptesClient(ArrayList<Compte> comptes, ArrayList<Client> clients, Scanner sc) {
    System.out.print("Entrez le numéro du client : ");
    int numClient = sc.nextInt();
    Client client = clients.get(numClient - 1);
    System.out.println("Comptes de " + client.getNom() + " " + client.getPrenom() + " :");
    for (Compte compte : comptes) {
        if (compte.getClient().equals(client)) {
            System.out.println(compte.toString());
        }
    }
  }
  
  private static void faireTransaction(ArrayList<Compte> comptes, Scanner sc) {
    System.out.print("Entrez le numéro du compte à débiter : ");
    int numCompteDebit = sc.nextInt();
    Compte compteDebit = comptes.get(numCompteDebit - 1);
    System.out.print("Entrez le numéro du compte à créditer : ");
    int numCompteCredit = sc.nextInt();
    Compte compteCredit = comptes.get(numCompteCredit - 1);
    System.out.print("Entrez le montant de la transaction : ");
    double montant = sc.nextDouble();
    if (compteDebit.debiter(montant)) {
        compteCredit.crediter(montant);
        System.out.println("La transaction a été effectuée avec succès!");
    } else {
        System.out.println("Le compte n'a pas suffisamment de fonds.");
    }
  }
  }

  class Compte {
    private static int nbComptes = 0;
    private int numero;
    private Client client;
    private double solde;
    
    public Compte(Client client, double solde) {
        nbComptes++;
        numero = nbComptes;
        this.client = client;
        this.solde = solde;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public Client getClient() {
        return client;
    }
    
    public double getSolde() {
        return solde;
    }
    
    public boolean debiter(double montant) {
        if (montant <= solde) {
            solde -= montant;
            return true;
        } else {
            return false;
        }
    }
    
    public void crediter(double montant) {
        solde += montant;
    }
    
    public String toString() {
        return "Compte numéro " + numero + " : solde = " + solde + "€";
    }
  }
  
  
  class Client {
    private static int nbClients = 0;
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    
    public Client(String nom, String prenom, String adresse, String telephone) {
        nbClients++;
        numero = nbClients;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public String toString() {
        return "Client numéro " + numero + " : " + prenom + " " + nom + " (adresse : " + adresse + ", téléphone : " + telephone + ")";
    }
}
  