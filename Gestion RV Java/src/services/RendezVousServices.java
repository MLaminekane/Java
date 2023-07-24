package services;
import models.*;
import models.enums.Statut;

import java.util.*;
import java.util.stream.Collectors;


public class RendezVousServices {
  private ArrayList<Patient> patientList = new ArrayList<Patient>();
  private ArrayList<Personne> persons = new ArrayList<Personne>();

  public RendezVousServices(){

  }
  
  public void addPersonne(Personne personne){
    this.add(personne);
  }
  
  private void add(Personne personne) {
    // Add the person to the appropriate list based on their type
    if (personne instanceof Patient) {
      patientList.add((Patient) personne);
    } else {
      persons.add(personne);
    }
  }
  
  public ArrayList<Patient> ListerPatient(){
    return patientList;
  }
  
  public ArrayList<Patient> ListerPatient(Statut statut){
    return (ArrayList<Patient>) patientList.stream().filter(p -> p.getStatut()==statut).collect(Collectors.toList());
  }
}
