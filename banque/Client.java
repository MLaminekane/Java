package banque;
public class Client {
  private String nom;
  private String prenom;
  private String adresse;
  private String telephone;
  
  public Client(String nom, String prenom, String adresse, String telephone) {
      this.nom = nom;
      this.prenom = prenom;
      this.adresse = adresse;
      this.telephone = telephone;
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
  
  @Override
  public String toString() {
      return nom + " " + prenom + " (" + telephone + ")";
  }
}
