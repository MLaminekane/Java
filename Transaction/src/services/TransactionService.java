package services;

import models.Transaction;
import models.TypeTrans;

public class TransactionService {
    private final int N=10;
    
    private Transaction[] transactions=new Transaction[N];
    public Transaction[] getTransactions() {
        return transactions;
    }
    public Transaction[] getTransactions(TypeTrans type) {
        Transaction[] transactionsType=new Transaction[nbreTrans];
        for(int index=0;index<nbreTrans;index++){
            if(transactions[index].getType()==type){
                transactionsType[index]=transactions[index];
            }
        }
        return transactionsType;
    }
    private int nbreTrans;
    public void addTransaction(Transaction t){
        transactions[nbreTrans]=t;
        nbreTrans++;
    }
    public void listerTransactions(){};
    /*
Ajouter une Transaction dans le Tableau
Lister toutes Transactions du Tableau
Lister les Transactions du Tableau Par Type
 */
}
