package entidades;

import java.sql.Date;

public class Deportista {
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String telefono;
    private String email;
    private String direccion;
    private Date fechaInscripcion;
    private String estado;
    private String contactoEmergencia;

    public Deportista() {}

   public Deportista(int id, String nombre, String apellido, Date fechaNacimiento, String telefono,
                  String email, String direccion, Date fechaInscripcion, String estado, String contactoEmergencia) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.telefono = telefono;
    this.email = email;
    this.direccion = direccion;
    this.fechaInscripcion = fechaInscripcion;
    this.estado = estado;
    this.contactoEmergencia = contactoEmergencia;
}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }
 
    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }
   
}



    