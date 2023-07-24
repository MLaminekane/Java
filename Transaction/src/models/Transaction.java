package models;

public class Transaction {
    // Attributs de classe/Statiques
    private static int nbreTrans;
    // Attributs d'instances
    private int id;
    private TypeTrans type;
    private double montant;
    //Constructeur par défaut
    public Transaction(){
        this.id =++ nbreTrans;
    }
    //Constructeurs par surcharge
    public Transaction(int id,TypeTrans type,double montant){
        this.id=id;
        this.type=type;
        this.montant=montant;
    }
    public Transaction(TypeTrans type,double montant){
        nbreTrans++;
        this.id=id;
        this.type=type;
        this.montant=montant;
    }
    public static int getNbreTrans() {
        return nbreTrans;
    }
    public int getId() {
        return id;
    }
    public TypeTrans getType() {
        return type;
    }
    public double getMontant() {
        return montant;
    }
    public static void setNbreTrans(int nbreTrans) {
        Transaction.nbreTrans = nbreTrans;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setType(TypeTrans type) {
        this.type = type;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public void afficheTrans(){
        System.out.println(this.getId()+"|"+this.getMontant()+"|"+this.getType().name());
    }
}
