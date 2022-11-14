/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
//trabalhando com threads
public class Produtor implements Runnable {

//criando a fila e passando para o construtor
    private Fila fila;
    private int controle;

    public Produtor(Fila fila, int controle) {
        this.fila = fila;
        this.controle = controle;
    }

    @Override
    public void run() {

        if (controle == 1) { // 1 = com controle
           
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                int numx = random.nextInt(100);

                fila.putComControle(numx);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        } else {

            for (int j = 0; j < 5; j++) {
                Random random = new Random();
                int numy = random.nextInt(100);
                fila.putSemControle(numy);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
