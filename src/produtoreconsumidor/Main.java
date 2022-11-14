/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Saída de Dados
        System.out.println("Escolha sua opção:");
        System.out.println("1 - Com Controle");
        System.out.println("2 - Sem controle");
        
        Scanner teclado = new Scanner(System.in);
        int op;
        op = teclado.nextInt();

        Fila fila = new Fila();
        Produtor produtor = new Produtor(fila,op);
        Consumidor consumidor = new Consumidor(fila,op);

        Thread produtorThread = new Thread(produtor);
        Thread consumidorThread = new Thread(consumidor);

        produtorThread.start();

        consumidorThread.start();
        
      
    }
    
    

}
