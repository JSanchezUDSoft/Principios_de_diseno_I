package Principal;

public class Persona {
    private int Id_Persona;
    private String Nombre;
    private String Apellido;
    private long Celular;

    public Persona() {
    }

    public Persona(int id_Persona, String nombre, String apellido, long celular) {
        Id_Persona = id_Persona;
        Nombre = nombre;
        Apellido = apellido;
        Celular = celular;
    }

    public int getId_Persona() {
        return Id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        Id_Persona = id_Persona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public long getCelular() {
        return Celular;
    }

    public void setCelular(long celular) {
        Celular = celular;
    }
}
