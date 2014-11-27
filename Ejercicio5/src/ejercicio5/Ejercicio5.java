package ejercicio5;

import java.util.ArrayList;

/**
 *
 * @author dfloresalarcon
 */
public class Ejercicio5 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> lista = new ArrayList();
        lista.add(20);
        lista.add(23);
        lista.add(12);
        lista.add(67);
        lista.add(10);
        lista.add(45);
        lista.add(1);
        lista.add(88);
        lista.add(11);
        lista.add(65);
        lista.add(4);
        lista.add(24);
        lista.add(56);
        lista.add(54);
        lista.add(26);
        lista.add(6);
        lista.add(78);
        lista.add(77);
        lista.add(55);
        lista.add(9);

        //mayor de 23: 11
        //menor de 57: 15
        //multiplos de 5: 5
        //Total: 31 numeros totales
        Contador con = new Contador();
        Mayor23 mas23 = new Mayor23(con, lista);
        Menor57 menos57 = new Menor57(con, lista);
        Multiplosde5 multi5 = new Multiplosde5(con, lista);

        mas23.start();
        menos57.start();
        multi5.start();

        mas23.join();
        menos57.join();
        multi5.join();

        System.out.println("total encontrados: "+con.getContador());
        System.out.println("----Finalizado----");

        VariableEnComun mayor23 = new VariableEnComun("mayor23", lista, con);
        VariableEnComun menor57 = new VariableEnComun("menor57", lista, con);
        VariableEnComun multiplos5 = new VariableEnComun("multiplos5", lista, con);

        mayor23.start();
        menor57.start();
        multiplos5.start();

        mayor23.join();
        menor57.join();
        multiplos5.join();

        System.out.println("total encontrados: "+ con.getContador());
        System.out.println("----Finalizado----");

    }
}
