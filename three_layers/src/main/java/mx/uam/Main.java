package mx.uam;

import java.util.List;

import mx.uam.dal.PersonaDao;
import mx.uam.dal.entities.Persona;

public class Main {
    public static void main(String[] args) {
      PersonaDao gestor = new PersonaDao();
      List<Persona> personas =  gestor.getAll();
      for (Persona persona : personas) {
        System.out.println(persona);
      }

      gestor.delete(2);
      System.out.println("RESULTADO");
      List<Persona> p =  gestor.getAll();
      for (Persona persona : p) {
        System.out.println(persona);
      }

    }
}