package Principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            G_Banco g_banco = new G_Banco();
            Prestamo prestamo = new Prestamo();
            Banco banco = new Banco();
            boolean menu = true;
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

            while(menu == true){
                System.out.println(prestamo.getDefDinero() + banco.getDinero_Banco());
                g_banco.capturar();
                g_banco.imprimir();

                if(prestamo.getDefDinero() == 2){
                    System.out.println("\nSe agotaron los recursos del banco, intente mañana");
                    menu = false;
                }
                else{
                    System.out.println("\nEjecucion finalizada correctamente");
                    menu = false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
