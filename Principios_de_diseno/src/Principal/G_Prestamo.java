package Principal;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

public class G_Prestamo implements Operaciones{

    public void capturar(){
        try{

            int a, ncuotas, f_mes;
            double b;
            String c, d;

            Scanner lec = new Scanner(System.in);
            Prestamo prestamo = new Prestamo();

            System.out.println("\n********DATOS DEL PRESTAMO********");
            System.out.println("\nDigite el id del prestamo: ");
            a = lec.nextInt();
            System.out.println("Digite el valor del prestamo");
            b = lec.nextDouble();
            System.out.println("Digite en cuantas cuotas desea pagar el prestamo: ");
            ncuotas = lec.nextInt();
            while(ncuotas > 6 || ncuotas <0){
                if(ncuotas > 6){
                    System.out.println("El número de cuotas debe ser inferior a 6, intente nuevamente");
                    System.out.println("Digite en cuantas cuotas desea pagar el prestamo: ");
                    ncuotas = lec.nextInt();
                }

                else if(ncuotas < 0){
                    System.out.println("El número de cuotas debe ser mayor a 0 e inferior a 6, intente nuevamente");
                    System.out.println("Digite en cuantas cuotas desea pagar el prestamo: ");
                    ncuotas = lec.nextInt();
                }
            }

            //Fecha actual calendar
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year  = localDate.getYear();
            Calendar c1 = Calendar.getInstance();//fecha actual

            c1.set(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());

            System.out.println("Fecha de autorización del préstamo(dd/mm/aaaa): ");//Validar primeros 20 dias del mes
            c = lec.next();

            String[] f_a = c.split("/");

            int dia = Integer.valueOf(f_a[0]);
            int mes = Integer.valueOf(f_a[1]) - 1;
            int anio = Integer.valueOf(f_a[2]);

            Calendar c2 = Calendar.getInstance();//fecha autorizacion
            c2.set(anio, mes, dia);

            if(dia > 20){
                int diferencia;
                System.out.println("El prestamo debe autorizarse en los primeros 20 dias del mes, por lo tanto el sistema le asignara la fecha de autorizacion automaticamente");

                diferencia = 31 - dia;

                c2.add(Calendar.DAY_OF_MONTH, diferencia);

                diferencia = c2.get(Calendar.DAY_OF_MONTH);

                if(diferencia == 31){
                    c2.add(Calendar.DAY_OF_YEAR, 1);
                }
            }

            c = c2.getTime().toString();

            c2.add(Calendar.DAY_OF_WEEK,7);

            d = c2.getTime().toString();//fecha tentativa de entrega del prestamo

            Calendar c3 = Calendar.getInstance();//fecha tentativa de entrega del prestamo
            c3.set(c2.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));


            prestamo.setN(ncuotas);

            String[] fechasPago = new String[prestamo.getN()];
            String[] m = new String[prestamo.getN()];



            //Fechas de pago
            for (int i = 0; i < ncuotas; i++) {
                c3.add(Calendar.DAY_OF_MONTH, 30);
                m[i] = c3.getTime().toString();
            }

            prestamo.registrarPrestamo(a, b, m, c, d);
            G_Banco g_banco = new G_Banco();
            g_banco.imprimir();

        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ingrese la fecha en formato (dd/mm/aaaa)");
            Prestamo prestamo = new Prestamo();
            prestamo.setValidacion(false);
            Persona persona = new Persona();
            persona.setrPersona(2);
        }
        catch(NumberFormatException e){
            System.out.println("Ingrese un valor numerico");
            Prestamo prestamo = new Prestamo();
            prestamo.setValidacion(false);

        }
    }
    public void imprimir() {
        try{
            Prestamo prestamo = new Prestamo();
            System.out.println("Número de prestamo: " + prestamo.getId_Prestamo());
            System.out.println("Valor: " + prestamo.getValor());
            System.out.println("Fecha de autorización del prestamo: " + prestamo.getFecha_Aut());
            System.out.println("Fecha tentativa de entrega: " + prestamo.getFecha_Entrega());
            for (int i = 0; i < prestamo.getFechas_Pago().length; i++) {
                System.out.println("Cuota # " + (i+1) + " = " + prestamo.getFechas_Pago()[i]);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
