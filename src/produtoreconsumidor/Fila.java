/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.concurrent.Semaphore;

public class Fila {

    private int item;

    private Semaphore semaforoConsumidor = new Semaphore(0);
    private Semaphore semaforoProdutor = new Semaphore(1);

    //COM CONTROLE
    
    // Colocando um item no buffer
    public void putComControle(int item) {
        try {
            semaforoProdutor.acquire();

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        this.item = item;
        System.out.println("Produtor produziu o item: " + item);
        
        semaforoConsumidor.release();
    }
    
    public void getComControle() {
        try {
            semaforoConsumidor.acquire();

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        System.out.println("Consumidor consumiu o item: " + item);
      
        semaforoProdutor.release();
    }


 //SEM controle
    
    public void putSemControle(int item) {
        this.item = item;
        System.out.println("Produtor produziu o item: " + item);

    }
    public void getSemControle() {
        System.out.println("Consumidor consumiu o item: " + item);
    }
}
