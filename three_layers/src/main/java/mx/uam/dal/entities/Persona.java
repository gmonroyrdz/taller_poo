package mx.uam.dal.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String edad;
    private String genero;
    private Date fechaNacimiento;
    private List<Direccion> direcciones;
    public Persona(){
        this.fechaNacimiento = Calendar.getInstance().getTime();
        this.direcciones = new ArrayList<Direccion>();
    }
    
    public Persona(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String genero,
            Date fechaNacimiento, List<Direccion> direcciones) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.direcciones = direcciones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public String getEdad() {
        return edad;
    }
    public String getGenero() {
        return genero;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public List<Direccion> getDirecciones() {
        return direcciones;
    }


    public String toString(){
        StringBuilder str = new StringBuilder();
        String sep = ",";
        str.append(id);
        str.append(sep);
        str.append(nombre);
        str.append(sep);
        str.append(apellidoPaterno);
        str.append(sep);
        str.append(apellidoMaterno);
        str.append(sep);
        str.append(edad);
        str.append(sep);
        str.append(fechaNacimiento.toString());
        str.append("| Direcciones:[");
        for (Direccion direccion : direcciones) {
            str.append(direccion.getCalle());
            str.append(sep);
            str.append(direccion.getNumExt());
        }
        str.append("]");

        return str.toString();

    }
    
}
