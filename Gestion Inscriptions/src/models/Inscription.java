package models;

public class Inscription {
    private int id;
    private String date;
    private String montant;
    private Etudiant etudiant;
    private Classe classe;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMontant() {
        return montant;
    }
    public void setMontant(String montant) {
        this.montant = montant;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        etudiant.addInscription(this);
    }
    @Override
    public String toString() {
        return "Inscription [id=" + id + ", date=" + date + ", montant=" + montant + ", etudiant=" + etudiant + "]";
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
        classe.addInscription(this);
    }

    
}
