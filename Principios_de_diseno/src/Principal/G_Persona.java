package Principal;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class G_Persona implements Operaciones{

    Scanner lec = new Scanner(System.in);

    public int ValidarEdad(String FechaN){
        try {
            int edad;

            String[] fechaArray = FechaN.split("/");

            int dia = Integer.valueOf(fechaArray[0]);
            int mes = Integer.valueOf(fechaArray[1]) - 1;
            int ano = Integer.valueOf(fechaArray[2]);

            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();

            edad = year - ano;

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

    public void capturar(){
        try{
            Persona persona = new Persona();
            long a, f;
            String b, c, d;

            System.out.println("\nDatos del solitante del Prestamo: ");
            System.out.println("\nDigite el número de identificación del solicitante: ");
            a = guardar(lec.next());
            System.out.println("Digite el primer nombre: ");
            b = lec.next();
            System.out.println("Digite el primer apellido: ");
            c = lec.next();
            System.out.println("Digite el segundo apellido");
            d = lec.next();
            System.out.println("Digite el teléfono movil: ");
            f = guardar(lec.next());

            persona.registrarPersona(a, b, c+d, f);
            persona.setrPersona(1);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

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
