package Principal;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;


/** +---------------------------------!!!G_Persona----------------------------------+
 * |Clase que se encarga de implementar los metodos de la interfaz Operaciones y --|*
 * |metodos relacionados con los datos de las personas----------------------------- *
 * +-----------------------------------------------------------------------------+**/

public class G_Persona implements Operaciones{

    Scanner lec = new Scanner(System.in);

    /** +-------------------------------!!!validarEdad()--------------------------------+
     * |Metodo que se encarga de verificar que la persona tiene la mayoria de edad------*
     * +------------------------------------------------------------------------------+*/

    public int ValidarEdad(String FechaN){
        try {
            int edad;

            String[] fechaArray = FechaN.split("/");//Se crea una cadena donde se va a separar cada dato por medio de un /

            int dia = Integer.valueOf(fechaArray[0]);//La variable dia toma la primera posición de la cadena
            int mes = Integer.valueOf(fechaArray[1]) - 1;//La variable mes toma la segunda posición de la cadena
            int ano = Integer.valueOf(fechaArray[2]);//La variable año toma la última posición de la cadena

            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();//Se crea una variable que se le asigna el año de la fecha local

            edad = year - ano;//A la variable year se le resta la variable ano

            if (edad < 18) {
                return 0;
            } else {
                return 1;
            }
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Ingrese la fecha en formato (dd/mm/aaaa)");
            return 2;
        }
        catch(Exception e){
            System.out.println(e);
            return 2;
        }
    }

    /** +---------------------------!!!validarDataCredito()-----------------------------+
     * |Metodo que se encarga de analizar si la persona está capacitada para recibir un|*
     * |prestamo----------------------------------------------------------------------- *
     * +------------------------------------------------------------------------------+*/

    public boolean validarDataCredito(int v){
        try{
            if(v == 1){
                System.out.println("El solicitante esta reportado en las centrales de riesgo, por lo tanto no puede solicitar un prestamo hasta que cumpla con sus obligaciones");
                return false;
            }
            else if(v == 2){
                return true;
            }
            else{
                System.out.println("Opción incorrecta, vuelva a iniciar");
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


    /** +--------------------------------!!!capturar()----------------------------------+
     * |Metodo que se encarga de capturar, validar y procesar los datos solicitados co-|*
     * |rrespondientes a las personas------------------------------------------------- *
     * +------------------------------------------------------------------------------+*/

    public void capturar(){
        try{
            /** +------------------------------------!!!---------------------------------------+
             *  |Solicitud y almacenamiento en variables de los datos del prestamo------------|*
             * +------------------------------------------------------------------------------+*/
            Persona persona = new Persona();// Se crea un objeto de tipo persona
            long a;// Representa el número de identifación de la persona
            long f;// Representa el número celular de la persona
            String b;// Representa el nombre de la persona
            String c;// Representa el primer apellido de la persona
            String d;// Representa el segundo apellido de la persona

            System.out.println("\nDatos del solitante del Prestamo: ");
            System.out.println("\nDigite el número de identificación del solicitante: ");
            a = guardar(lec.next());//
            System.out.println("Digite el primer nombre: ");
            b = lec.next();//Se ingresa el nombre de la persona y se guarda en la variable b
            System.out.println("Digite el primer apellido: ");
            c = lec.next();//Se ingresa el primer apellido de la persona y se guarda en la variable c
            System.out.println("Digite el segundo apellido");
            d = lec.next();//Se ingresa el segundo apellido de la persona y se guarda en la variable c
            System.out.println("Digite el teléfono movil: ");
            f = guardar(lec.next());//

            persona.registrarPersona(a, b, c+d, f);//Se envian los datos capturados a registrarPersona
            persona.setrPersona(1);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }


    /** +--------------------------------!!!imprimir()----------------------------------+
     * |Metodo que se encarga de imprimir los datos de la persona que ya fueron captur-|*
     * |ados previamente--------------------------------------------------------------- *
     * +------------------------------------------------------------------------------+*/

    public void imprimir(){
        try{
            Persona persona = new Persona();
            System.out.println("********PRESTAMO********");
            System.out.println("\nDatos del solicitante");
            System.out.println("C.C: " + persona.getId_Persona());
            System.out.println("Nombre: " + persona.getNombre() + " " + persona.getApellido());
            System.out.println("Celular: " + persona.getCelular());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /** +--------------------------------!!!guardar()-----------------------------------+
     * |Metodo que se encarga de convertir un String a Long-----------------------------*
     * +------------------------------------------------------------------------------+*/

    public long guardar(String str){
        long x=0;
        if(verificarDato(str)==true){
            x = Long.parseLong(str);
        }
        else{
            System.out.println("Dato invalido");
            capturar();
        }
        return x;
    }

    public boolean verificarDato(String str){
        boolean f = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                f = false;
                break;
            }
        }
        return f;
    }
}
