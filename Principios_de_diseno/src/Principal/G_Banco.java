package Principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class G_Banco implements Operaciones{

    public void definirDineroBanco() {

        Prestamo prestamo = new Prestamo();
        Banco banco = new Banco();
        double dinero;
        Scanner lec = new Scanner(System.in);

        System.out.println("Digite cuanto dinero tiene el banco para prestar el dia de hoy: ");
        dinero = lec.nextDouble();

        while(dinero < 0){
            System.out.println("INGRESE UN VALOR MAYOR QUE 0: ");
            dinero = lec.nextDouble();
        }

        if(dinero == 0){
            System.out.println("El banco no tiene dinero para prestar, vuelva mas tarde");
            prestamo.setDefDinero(2);
        }

        else{
            banco.setDinero_Banco(dinero);
            prestamo.setDefDinero(1);
        }
    }

    public void capturar() {
        G_Persona g_persona = new G_Persona();
        G_Prestamo g_prestamo = new G_Prestamo();
        Persona persona = new Persona();
        Prestamo prestamo = new Prestamo();
        Banco banco = new Banco();
        try{
                Scanner lec = new Scanner(System.in);
                int op;
                String fechaN;

                if(prestamo.getDefDinero() == 0){
                    definirDineroBanco();
                }

                else {

                    System.out.println("\nDigite la fecha de nacimiento del solicitante en este formato(dd/mm/aaaa): ");
                    fechaN = lec.next();

                    int a = g_persona.ValidarEdad(fechaN);

                    if (a == 1) {
                        System.out.println("Digite 1 si el usuario esta reportado o 2 si no lo esta: ");
                        boolean data = g_persona.validarDataCredito(lec.nextInt());

                        if (data == true) {
                            System.out.println("Desea capturar los datos del solicitante [1:Si, 0:No]: ");
                            op = lec.nextInt();
                            if (op == 1) {
                                g_persona.capturar();
                                g_prestamo.capturar();
                                persona.setrPersona(1);
                                prestamo.setValidacion(true);
                            } else if (op == 0) {
                                g_prestamo.capturar();
                                G_Banco g_banco = new G_Banco();
                                prestamo.setValidacion(true);
                            } else {
                                System.out.println("Opcion incorrecta");
                                prestamo.setValidacion(false);
                            }
                        }

                    } else if (a == 0) {
                        System.out.println("El solicitante es menor de edad");
                        prestamo.setValidacion(false);
                    } else if (a == 2) {
                        prestamo.setValidacion(false);
                    } else {
                        prestamo.setValidacion(false);
                    }
                }
        }
        catch(InputMismatchException e){
            System.out.println("Ingreso un dato no valido");
            prestamo.setDefDinero(3);
            prestamo.setValidacion(false);
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Ingrese la fecha en formato (dd/mm/aaaa)");
            persona.setrPersona(2);
            prestamo.setValidacion(false);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void imprimir() {
        Persona persona = new Persona();
        Prestamo prestamo = new Prestamo();
        G_Persona g_persona = new G_Persona();
        G_Prestamo g_prestamo = new G_Prestamo();
        try{
            int op = persona.getrPersona();

            //if(prestamo.getValidacion() == true){
                if(op == 1){
                    g_persona.imprimir();
                    g_prestamo.imprimir();
                }

                else if(op == 2){
                    System.out.println("Datos invalidos, intente nuevamente");
                }

                else{
                    System.out.println("\n********DATOS DEL PRESTAMO********");
                    g_prestamo.imprimir();
                }
            //}

            /*else{
                //System.out.println("Datos invalidos, intente nuevamente");
            }*/
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
