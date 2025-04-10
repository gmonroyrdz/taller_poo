package mx.uam.bl;

import java.util.List;

import mx.uam.dal.DireccionDao;
import mx.uam.dal.PersonaDao;
import mx.uam.dal.entities.Direccion;
import mx.uam.dal.entities.Persona;


public class GestorPersona {
    private PersonaDao crudPersona;
    private DireccionDao crudDireccion;

    GestorPersona(){
        this.crudPersona = new PersonaDao();
        this.crudDireccion = new DireccionDao();
    }

    public void agregarPersona(String nombre, String apellidoP, String apellidoM){
        if(personaExiste(nombre, apellidoP, apellidoM))
            return;
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellidoPaterno(apellidoP);
        persona.setApellidoMaterno(apellidoM);
        crudPersona.save(persona);
        System.out.println("La persona fue regitrada exitósamente");

    }

    public void eliminarPersona(String nombre, String apellidoP, String apellidoM){
        // 1.- Verificar que la persona exista
        if (!personaExiste(nombre, apellidoP, apellidoM))
            return;
        // 2.- Si la persona existe, obtenemos su id
        Persona persona = getPersona(nombre, apellidoP, apellidoM);
        // 3.- Revisar si la persona tiene direcciones asociadas
        // 4.- En caso de que tenga direcciones, debemos eliminarlas todas
        List<Direccion> direcciones = crudDireccion.getAll();
        for (Direccion direccion : direcciones) {
            if(direccion.getId() == persona.getId() ){
                crudDireccion.delete(persona.getId());
            }
        }        
        // 5.- Con el id pedimos al crud que elimine la persona
        crudPersona.delete(persona.getId());
        System.out.println("La persona fue eliminada exitósamente (con las direcciones asociadas eliminadas) ... ");
    }

    private boolean personaExiste(String nombre, String apellidoP, String apellidoM){
        List<Persona> personas = crudPersona.getAll();
        for (Persona persona : personas) {
            if( persona.getNombre().equals(nombre) && 
                persona.getApellidoPaterno().equals(apellidoP) &&
                persona.getApellidoMaterno().equals(apellidoM)
            ){
                System.out.println("El usuario ya se encuentra registrado ...");
                return true;
            }            
        }
        return false;
    }

    private Persona getPersona(String nombre, String apellidoP, String apellidoM){
        List<Persona> personas = crudPersona.getAll();
        for (Persona persona : personas) {
            if( persona.getNombre().equals(nombre) && 
                persona.getApellidoPaterno().equals(apellidoP) &&
                persona.getApellidoMaterno().equals(apellidoM)
            ){
                System.out.println("El usuario ya se encuentra registrado ...");
                return persona;
            }            
        }
        return null;
    }

}
