package Principal;


public class Main {

    public static void main(String[] args) {
        try{
            G_Banco g_banco = new G_Banco();
            Prestamo prestamo = new Prestamo();
            Banco banco = new Banco();

            boolean menu = true;


            while(menu == true){
                if(prestamo.getDefDinero() == 0){
                    System.out.println(prestamo.getDefDinero() +"\t"+ banco.getDinero_Banco());
                    g_banco.capturar();
                }

                else if(prestamo.getDefDinero() == 1){
                    System.out.println(prestamo.getDefDinero() +"\t"+ banco.getDinero_Banco());
                    g_banco.capturar();
                    g_banco.imprimir();
                }

                else if(prestamo.getDefDinero() == 2){
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
