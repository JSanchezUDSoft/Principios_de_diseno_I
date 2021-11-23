package Principal;

public class Persona {
    private int     Id_Persona;
    private String  Nombre;
    private String  Apellidos;
    private long    Celular;

    public Persona() {
    }

    public Persona(int id_Persona, String nombre, String apellidos, long celular) {
        Id_Persona = id_Persona;
        Nombre = nombre;
        Apellidos = apellidos;
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

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public long getCelular() {
        return Celular;
    }

    public void setCelular(long celular) {
        Celular = celular;
    }
}
