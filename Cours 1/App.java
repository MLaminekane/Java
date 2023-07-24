import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        /*
         * Types Primitifs => Types Valeurs
         * int,long, short, char , boolean,void
         *  Reels=> float, double(defaut)
         */
         // int x=2;
         // double y=12.5;
         // float z=12.5f;
          //Constantes 
          final double PI=3.14;
        /**
         * Classes=> Attributs + methodes
         * Convention Ecriture d'une Classe => PascalCase
         * MaPremiereClasseJava
         * JDK
         *  Chaines => String  => java.lang
         *  Environnement=>System
         *    System.in => Clavier
         *    System.out=>Ecran
         *  Classe de Saisie =>Scanner
         *     Methodes  => CamelCase  
         *      nextInt():Lire un entier
         *      nextDouble()
         *      nextFloat()
         *      nextBoolean()
         *      nextLine(): Lire une chaine de plusieurs mots
         *      next(): Lire une chaine d'un mot
         * Creer Par Programmeurs => UML
            * Description de Donnees  => entites(DC)
            * Services  => servives ou metiers(DUC)
            * Vues => Affichage et Saisie
            * Repository  => models => Classes de Persistences ou Accees 
            *                aux donnees
          Etapes pour Manipuler une Classe
             1. Declaration un objet de la Classe
             2. Instanciation ou creation de l'objet
             3. Donner un etat a l'etat  
         */
        String chaine ;//Chaine
        //1-Declaration de l'objet
        Scanner scanner;
        scanner=new Scanner(System.in);
       /*  int x;
        double y,s;
        System.out.println("Entrer un Entier");
        x=scanner.nextInt();
        System.out.println("Entrer un Reel");
        y=scanner.nextDouble();
        s=x+y;
        System.out.println("La Somme  est "+s);
        System.out.println("La Somme  est "+(x+y));
        System.out.println(s+"est la Somme ");*/
        int x;
        double y;
        do {
            System.out.println("Entrer un Entier");
            x=scanner.nextInt();
        } while (x<=0);
        
        System.out.println("Entrer un Reel");
        y=scanner.nextDouble();
        if(x>y){
            System.out.println(x+" , "+y);   
        }else{
            System.out.println(y+" , "+x);  
        }
     

        //Tableaux  => Classe
        /*
         * type[]  => Tableau
         * 1-Declation
         * int[] t;  double[] f;
         * String[] ch;
         * 2-Instanciation
         *  type[] tab=new  type[N] ;
         *  int[] t=new int[10];
         *  String[] ch=new String[5];
         */

         int[] t;
         final int N=5;
         t=new  int[N];
        
         for (int index = 0; index <N ; index++) {
            System.out.println("Entrer un Entier");
            t[index] =scanner.nextInt();
         }
         for (int index = 0; index <N ; index++) {
            if(t[index]%2==0){
                System.out.println(t[index]);
            }
         }
         /*
          * Menu Suivant
              1. Saisir  un tableau de N notes
              2. Afficher le tableau de notes
              3. Afficher la note Min et Note Max
              4. Modifier un note a une Position i
              5. Trier le Tableau de Notes par ordre Croissant
              6. Supprimer un note a une Position i
              7. Ajouter un note a une Position i
              8. Tranferer dans un tableau toutes les notes >=10
              9.Quitter
              NB : 
                1. 0<=Note<=20
          */


         scanner.close();
    }
}