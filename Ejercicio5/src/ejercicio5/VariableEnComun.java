/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Piter
 */
public class VariableEnComun extends Thread {

    Contador con;
    private String nombre;
    private ArrayList<Integer> lista;

    public VariableEnComun() {
    }

    public VariableEnComun(String nombre, ArrayList<Integer> lista, Contador con) {
        this.nombre = nombre;
        this.lista = lista;
        this.con=con;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        if (getNombre().equalsIgnoreCase("mayor23")) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) > 23) {

                    synchronized (con) {
                        System.out.println(" _ _ _Mayor que 23 Proceso: " + lista.get(i));
                        int num = con.getContador();
                        try {
                            sleep((long) (Math.random() * (1000 - 500) + 500));
                        } catch (InterruptedException ex) {
                            Logger.getLogger(VariableEnComun.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        con.setContador(num+1);
                    }
                }
            }
        }
        if (getNombre().equalsIgnoreCase("menor57")) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) < 57) {

                    synchronized (con) {
                        int num = con.getContador();
                        System.out.println(" _ _ Menor que 57 Proceso: " + lista.get(i));

                        try {
                            sleep((long) (Math.random() * (1000 - 500) + 500));
                        } catch (InterruptedException ex) {
                            Logger.getLogger(VariableEnComun.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        con.setContador(num+1);
                    }
                }
            }
        }
        if (getNombre().equalsIgnoreCase("multiplos5")) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) % 5 == 0) {

                    synchronized (con) {
                        int num = con.getContador();
                        System.out.println(" _ Multiplos de 5 Proceso: " + lista.get(i));

                        try {
                            sleep((long) (Math.random() * (1000 - 500) + 500));
                        } catch (InterruptedException ex) {
                            Logger.getLogger(VariableEnComun.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        con.setContador(num+1);
                    }
                }
            }
        }
    }
}
