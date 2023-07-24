import java.util.Scanner;

public class App {
   //Enumeration a Revenir
    private static Scanner scanner=new Scanner(System.in);//Attributs  double[] notes;// double notes[]
    private final static int N=10;//Taille de Reservation
    private static double[] notes=new double[N] ;
    private static int nbreNote;
    public static void main(String[] args) throws Exception {
        int choix;
        do {
           
            System.out.println("1. Saisir  un tableau de N notes");   
            System.out.println("2. Afficher le tableau de notes");   
            System.out.println("3. Afficher la note Min et Note Max");    
            System.out.println("4. Modifier un note a une Position i");    
            System.out.println("5. Trier le Tableau de Notes par ordre Croissant");   
            System.out.println("6. Supprimer un note a une Position i");   
            System.out.println("7. Ajouter un note a une Position i");   
            System.out.println("8. Tranferer dans un tableau toutes les notes >=10");   
            System.out.println("9.Quitter"); 
            System.out.println("Faites votre choix"); 
            choix=scanner.nextInt();
            switch (choix) {
                case 1:
                   do{
                          System.out.println("Entrer le nombre de notes");
                          nbreNote=scanner.nextInt();
                   }while(nbreNote<0 || nbreNote>N);
                   saisieTableau();
                break;
                case 2:
                    afficheTableau();
                break;
                case 3:
                    afficheNoteMinEtMax();
                break;
                    case 4 : 
                    modfierNoteAUnePos();
                    afficheTableau();
                 break;
                    case 8 : 
                    tranfereNoteSupMoy();
                 break;
                default:
                    break;
            }
        }while (choix!=9); 
    }

    public static double isNote(){
        double note;
        do {
            System.out.println("Entrer une note");
            note=scanner.nextDouble();
            if(note<0 || note>20)
              System.out.println("Note comprise entre 0 et 20");
        } while (note<0 || note>20); 
        return note;
    }

   public  static void saisieTableau(){
        for (int index = 0; index < nbreNote; index++) {
               notes[index]=isNote();
        }
    }

    public  static void afficheTableau(){
        for (int index = 0; index < nbreNote; index++) {
             System.out.print(notes[index]+"|");        
        }
        System.out.println(""); 
    }

    public  static void afficheNoteMinEtMax(){
        double min=20,max=0;

        for (int index = 0; index < nbreNote; index++) {
            if(min>notes[index]) {
                min=notes[index];
            }
            if(max<notes[index]) {
                max=notes[index];
            }     
        }
        System.out.println("Note Max : "+max); 
        System.out.println("Note Min : "+min);          
    }

    public  static void modfierNoteAUnePos(){
        int pos;
        do{
            System.out.println("Entrer la Position: ");
            pos=scanner.nextInt();
       }while(pos<0 || pos>nbreNote);

        double note=isNote();
        notes[pos]=note;
        System.out.println(""); 
    }

    public  static void tranfereNoteSupMoy(){
        double noteSupMoy[]=new double[nbreNote];
        int nbreVal=0;
        for (int index = 0; index < nbreNote; index++) {
           if(notes[index]>=10)  {
            noteSupMoy[nbreVal++]=notes[index];
           }     
        }
    }
}