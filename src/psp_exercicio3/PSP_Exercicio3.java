package psp_exercicio3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PSP_Exercicio3 extends Thread {

    int cont = 0;
    public static PSP_Exercicio3[] Aobjetos = new PSP_Exercicio3[5];

    public PSP_Exercicio3(String str) {

        super(str);

    }

    //run CON MINUS !!!
    @Override
    public void run() {

        System.out.println("Comienza hilo " + getName());

        while (cont != 5) {

            Aobjetos[cont].start();
            try {
                Aobjetos[cont].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Exercicio3.class.getName()).log(Level.SEVERE, null, ex);
            }

            cont++;

        }

        System.out.println("Acaba Hilo " + getName());

    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            PSP_Exercicio3.Aobjetos[i] = new PSP_Exercicio3("SubHilo " + Integer.toString(i));

        }

        PSP_Exercicio3 h1 = new PSP_Exercicio3("Maria");
        h1.start();
        System.out.println("Acaba main");

    }

}
