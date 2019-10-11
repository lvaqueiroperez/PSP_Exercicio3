package psp_exercicio3;

import java.util.ArrayList;

public class PSP_Exercicio3 extends Thread {

    int cont = 0;
    public static PSP_Exercicio3[] objetos = new PSP_Exercicio3[5];

    public PSP_Exercicio3(String str) {

        super(str);

    }

    //run CON MINUS !!!
    @Override
    public void run() {

        System.out.println("Comienza hilo " + getName());

        while (cont != 5) {

            objetos[cont].start();
            cont++;

            System.out.println("Comienza hilo " + objetos[cont].getName());
        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            PSP_Exercicio3.objetos[i] = new PSP_Exercicio3("SubHilo " + Integer.toString(i));

        }

        PSP_Exercicio3 h1 = new PSP_Exercicio3("Maria");
        h1.start();
        System.out.println("Acaba main");

    }

}
