package mx.uam.dal.entities;

public class Direccion {
    private String calle;
    private String numExt;
    private int personaId;
    public Direccion(){

    }
    public int getId(){
        return this.personaId;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNumExt() {
        return numExt;
    }
    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }
    
}
