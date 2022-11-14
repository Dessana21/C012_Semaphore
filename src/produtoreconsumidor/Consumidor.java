/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable {

    private Fila fila;
    private int controle;

    public Consumidor(Fila fila, int controle) {
        this.fila = fila;
        this.controle = controle;
    }

    @Override
    public void run() {

        //com controle
        if (controle == 1) {

            for (int i = 0; i < 5; i++) {

                fila.getComControle();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        } else {
            //sem controle
                for (int j = 0; j < 5; j++) {

                    fila.getSemControle();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                        }

                }
            }

    }

}
