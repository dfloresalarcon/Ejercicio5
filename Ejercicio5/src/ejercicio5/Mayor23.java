/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dfloresalarcon
 */
public class Mayor23 extends Thread {

    
    Contador con;
    ArrayList<Integer> lista;

    public Mayor23(Contador con, ArrayList<Integer> lista) {
        this.con = con;
        this.lista = lista;
    }

    /**
     * @return the con
     */
    public Contador getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Contador con) {
        this.con = con;
    }
    
    @Override
    public void run() {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > 23) {
                int num = 0;
                synchronized (con) {
                    System.out.println(" _ _ _Mayor que 23 Proceso: " + lista.get(i));
                    num = con.getContador();
                    try {
                        sleep((long) (Math.random() * (1000 - 500) + 500));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(VariableEnComun.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    con.setContador(num + 1);
                }
            }
        }
    }

}
