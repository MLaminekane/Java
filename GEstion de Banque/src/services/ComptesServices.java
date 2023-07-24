package services;

import java.util.ArrayList;

import models.Client;
import models.Compte;

public class ComptesServices {
  public ArrayList <Client> clients = new ArrayList<>();
  public ArrayList <Compte> comptes = new ArrayList<>();
  public void addClient(Client client){
    clients.add(client);
  }
  public ArrayList <Client> listerClients(){
    return clients;
  }
  public void addCompte(Compte compte){
    comptes.add(compte);
  }
  public ArrayList <Compte> listerComptes(){
    return comptes;
  }
  public Client getClientById(int id){
    return clients.stream()
                  .filter(cl->cl.getId()==id)
                  .findFirst()
                  .orElse(null);
  }
  public Compte getCompteByNumero(String numero){
    return comptes.stream()
                  .filter(cl->cl.getNumero().compareToIgnoreCase(numero)==0)
                  .findFirst()
                  .orElse(null);
  }
}
