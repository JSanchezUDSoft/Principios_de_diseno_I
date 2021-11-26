package Principal;

import java.util.Scanner;

public class Persona{

    private static Long     Id_Persona;//Identifiación del cliente
    private static String   Nombre;// Primer nombre del cliente
    private static String   Apellido;// Primer y segundo apellido del cliente
    private static Long     Celular;// Número celular del cliente
    private static int      rPersona;// Validación de registro de cliente
    Scanner lec = new Scanner(System.in);

    public Persona() {}

    public Persona(long id_Persona, String nombre, String apellido, long celular) {
        this.Id_Persona = id_Persona;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Celular = celular;
    }

    /** +-----------registrarPersona------------------------+
     *  |Guarda los datos para registrar el cliente--------|*
     * +--------------------------------------------------+*/
    public void registrarPersona(long id_Persona, String nombre, String apellido, long celular){
        setId_Persona(id_Persona);
        setNombre(nombre);
        setApellido(apellido);
        setCelular(celular);
    }

    public long getId_Persona() {
        return Id_Persona;
    }

    public void setId_Persona(long id_Persona) {
        try{
            /** +------------------------------------!!!-----------------------------------------------------+
             *  |Verifica si el numero de identidad es un número y de lo contrario lo pide nuevamente-------|*
             * +--------------------------------------------------------------------------------------------+*/
            while(id_Persona < 0){
                System.out.println("NÚMERO DE DOCUMENTO NO VALIDO, INTENTE NUEVAMENTE");
                G_Persona g_persona = new G_Persona();
                g_persona.capturar();
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

    public long getCelular() {
        return Celular;
    }

    public void setCelular(long celular) {
        try{
            /** +------------------------------------!!!-----------------------------------------------------+
             *  |Verifica si el número de celular es un número y de lo contrario lo pide nuevamente---------|*
             * +--------------------------------------------------------------------------------------------+*/
            while(celular < 0){
                System.out.println("TELEFONO NO VALIDO, INTENTE NUEVAMENTE");
                G_Persona g_persona = new G_Persona();
                g_persona.capturar();
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