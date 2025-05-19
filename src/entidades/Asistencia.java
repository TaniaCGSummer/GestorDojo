
package entidades;

import java.util.Date;

public class Asistencia {

    private int id;
    private int deportistaid;
    private int claseid ;
    private Date fecha;
    private boolean presente;
    private String observaciones;

    public Asistencia(int id, int deportistaid, int claseid, Date fecha, boolean presente, String observaciones) {
        this.id = id;
        this.deportistaid = deportistaid;
        this.claseid = claseid;
        this.fecha = fecha;
        this.presente = presente;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeportistaid() {
        return deportistaid;
    }

    public void setDeportistaid(int deportistaid) {
        this.deportistaid = deportistaid;
    }

    public int getClaseid() {
        return claseid;
    }

    public void setClaseid(int claseid) {
        this.claseid = claseid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    

}
