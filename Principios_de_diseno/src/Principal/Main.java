package Principal;

public class Main {

    public static void main(String[] args) {
        try{
            G_Prestamo p = new G_Prestamo();
            boolean menu = true;

            while(menu == true){
                if(p.getDefDinero() == 0 || p.getDefDinero() == 1){
                    p.capturar();
                    p.imprimir();
                }
                else if(p.getDefDinero() == 2){
                    System.out.prinln("\nSe agotaron los recursos del banco, intente mañana");
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
