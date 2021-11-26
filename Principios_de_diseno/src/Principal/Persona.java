package Principal;

import java.util.Scanner;

public class Persona{
    private int     Id_Persona;
    private String  Nombre;
    private String  Apellido;
    private String    Celular;
    private int     rPersona;
    Scanner lec = new Scanner(System.in);

    public Persona() {}

    public Persona(int id_Persona, String nombre, String apellido, String celular) {
        this.Id_Persona = id_Persona;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Celular = celular;
    }

    public void registrarPersona(int id_Persona, String nombre, String apellido, String celular){
        setId_Persona(id_Persona);
        setNombre(nombre);
        setApellido(apellido);
        setCelular(celular);
    }

    public int getId_Persona() {
        return Id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        try{
            while(id_Persona < 0){
                System.out.println("NÚMERO DE DOCUMENTO NO VALIDO, INTENTE NUEVAMENTE");
                id_Persona = lec.nextInt();
            }
            this.Id_Persona = id_Persona;
        }
        catch(Exception e){
            System.out.println("Excepcion: " + e);
        }
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

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        try{
            while(celular.length() < 0){
                System.out.println("TELEFONO NO VALIDO, INTENTE NUEVAMENTE");
                celular = lec.next();
            }
            this.Celular = celular;
        }
        catch(Exception e){
            System.out.println("Excepcion: " + e);
        }
    }

    public int getrPersona() {
        return rPersona;
    }

    public void setrPersona(int rPersona) {
        this.rPersona = rPersona;
    }
}
