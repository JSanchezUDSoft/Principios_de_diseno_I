package Principal;

public class G_Persona implements Operaciones{

    Persona persona = new Persona();

    public int ValidarEdad(String FechaN){
        try {
            int edad;

            String[] feachaRrray = FechaN.split("/");

            int dia = Integer.valuesOf(feachaRrray[0]);
            int mes = Integer.valuesOf(feachaRrray[1]) - 1;
            int ano = Integer.valuesOf(feachaRrray[2]);

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
            String b, c;
            int a;
            long f;

            System.out.println("\nDatos del solitante del Prestamo: ");
            System.out.println("\nDigite el número de identificación del solicitante: ");
            a = lec.nextInt();
            System.out.println("Digite el primer nombre: ");
            b = lec.next();
            System.out.println("Digite el primer y segundo apellido: ");
            c = lec.next();
            System.out.println("Digite el teléfono movil: ");
            f = lec.nextLong();

            Persona(a, b, c, f);
            setrPersona(1);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public void imprimir(){
        try{
            System.out.println("********PRESTAMO********");
            System.out.println("\nDatos del solicitante");
            System.out.println("C.C: " + getId_Persona());
            System.out.println("Nombre: " + persona.getNombre() + " " + persona.getApellido());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
