import java.util.Scanner;
import java.util.Arrays;

public class notes {
  private static int[] notes = new int[4];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.println("1- Saisir Notes;");
      System.out.println("2- Afficher le tableau de notes");
      System.out.println("3- Afficher la note Min et Note Max");
      System.out.println("4- Modifier une note a une Position i");
      System.out.println("5- Trier le Tableau de Notes par ordre Croissant");
      System.out.println("6- Supprimer un note a une Position i");
      System.out.println("7- Ajouter un note");
      System.out.println("8- Tranferer dans un tableau toutes les notes >=10");
      System.out.println("9- Quitter");
      System.out.print("Entrez votre choix : ");
      int choix = sc.nextInt();
      System.out.print("\033[H\033[2J");
      switch (choix) {
        case 1:
          notes = saisirNotes();
          break;
        case 2:
          affNotes(notes);
          break;
        case 3:
          afficherMinMax(notes);
          break;
        case 4:
          notes = modifierNote(notes);
          break;
        case 5:
          trieOrdreCroissant(notes);
          break;
        case 6:
          notes = suppNotes(notes);
          break;
        case 7:
          notes = ajouterNotes(notes);
          break;
        case 8:
          notes = transfNotes(notes);
          break;
        case 9:
          System.out.println("Bye !");
          System.exit(0);
        default:
          System.out.println("choice invalid!");
          break;
      }
    }
  }  
  private static int[] saisirNotes(){
    int tabNotes = 4;
    Scanner scanner = new Scanner(System.in);
    System.out.println("entrer les notes: ");
    for (int i = 0; i < tabNotes; i++) {
      do {
        System.out.print("note " + (i+1) + ":" );
        notes[i] = scanner.nextInt();
        if (notes[i] > 20 || notes[i] < 0){
          System.out.println("Note should be between 0 and 20. Retry.");
        }
      } while (notes[i] > 20 || notes[i] < 0);     
    }
    return notes;
  }
  private static void affNotes(int[] tabNotes) {
    for (int i = 0; i < tabNotes.length; i++) {
      System.out.println("Note " + (i+1) + " : " + tabNotes[i]);
    }
  }

  private static void afficherMinMax(int[] tabNotes){
    int min = tabNotes[0];
    int max = tabNotes[0];
    for (int i=1; i < tabNotes.length; i++){
      if (tabNotes[i] < min){
        min = tabNotes[i];
      }else if (tabNotes[i] > max){
        max = tabNotes[i];
      }
    }
    System.out.println("Min: " + min);
    System.out.println("Max: " + max);
  }
  public static int[] modifierNote(int[] tabNotes){
    affNotes(tabNotes);
    Scanner scanner = new Scanner(System.in);
    System.out.print("Position de la note à modifier : ");
    int position = scanner.nextInt() - 1; 
    if (position < 0 || position >= tabNotes.length) {
        System.out.println("Position de la note invalide.");
        return tabNotes;
    }
    int[] nouveauTabNotes = new int[tabNotes.length];
    System.arraycopy(tabNotes, 0, nouveauTabNotes, 0, position);
    System.out.print("Nouvelle valeur : ");
    nouveauTabNotes[position] = scanner.nextInt();
    System.arraycopy(tabNotes, position + 1, nouveauTabNotes, position, tabNotes.length - position - 1);
    System.out.println("Modification réussie.");
    return nouveauTabNotes;
  }

  private static void trieOrdreCroissant(int[] tabNotes){
    Arrays.sort(tabNotes);
    System.out.println("ascending order: ");
    for (int i = 0; i < tabNotes.length; i++){
      System.out.println("note " + (i+1) + ": " + tabNotes[i]);
    }
  }
  private static int[] suppNotes(int[] tabNotes){
    affNotes(tabNotes);
    Scanner scanner = new Scanner(System.in);
    System.out.print("Note position to remove: ");
    int position = scanner.nextInt() - 1; 
    if (position < 0 || position >= tabNotes.length) {
        System.out.println("Note position invalid.");
        return tabNotes;
    }
    int[] newTabNotes = new int[tabNotes.length - 1];
    System.arraycopy(tabNotes, 0, newTabNotes, 0, position);
    System.arraycopy(tabNotes, position + 1, newTabNotes, position, tabNotes.length - position - 1);
    System.out.println("Remove Successful.");
    return newTabNotes;
  }
  private static int[] ajouterNotes(int[] tabNotes) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Position de la note à ajouter : ");
    int position = scanner.nextInt() - 1;
    if (position < 0 || position > tabNotes.length) {
        System.out.println("Position inalid.");
        return tabNotes;
    }
    int note;
    do {
        System.out.print("Note to add : ");
        note = scanner.nextInt();
        if (note > 20 || note < 0) {
            System.out.println("Note should be between 0 and 20. Retry.");
        }
    } while (note > 20 || note < 0);

    int[] newTabNotes = new int[tabNotes.length + 1];
    System.arraycopy(tabNotes, 0, newTabNotes, 0, position);
    newTabNotes[position] = note;
    System.arraycopy(tabNotes, position, newTabNotes, position + 1, tabNotes.length - position);
    return newTabNotes;
  }
  private static int[] transfNotes(int[] tabNotes) {
    int[] newTabNotes = new int[tabNotes.length];
    int newIndex = 0;
    for (int i = 0; i < tabNotes.length; i++) {
        if (tabNotes[i] >= 10) {
            newTabNotes[newIndex] = tabNotes[i];
            newIndex++;
        }
    }
    if (newIndex == 0) {
        System.out.println("Note >= 10 not present.");
        return null;
    } else {
        int[] resultTabNotes = new int[newIndex];
        System.arraycopy(newTabNotes, 0, resultTabNotes, 0, newIndex);
        System.out.println("Successful Transfer.");
        System.out.println("New Note Array: ");
        for (int i = 0; i < resultTabNotes.length; i++){
          System.out.println("note " + (i+1) + ": " + tabNotes[i]);
        }
        return resultTabNotes;
    }
  }
}