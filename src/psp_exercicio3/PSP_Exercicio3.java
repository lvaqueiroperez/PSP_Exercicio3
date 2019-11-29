package psp_exercicio3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.*;

public class PSP_Exercicio3 extends Thread {
    //solo va si es public static ???
    public static int contSubHilos = 0;

    public PSP_Exercicio3(String str) {

        super(str);

    }

    //run CON MINUS !!!
    @Override
    public void run() {
        //Si no ponemos una condición, tras crear el primer Hilo se accedería a Run()
        //para mostrar su nombre y crear otro hilo que también se iniciaría con un start(),
        //dando lugar a otra ejecución del mismo código de Run(), y así indefinidamente

        PSP_Exercicio3 subhilos = null;

        System.out.println("Comienza " + getName());

        if (contSubHilos != 0) {

            for (int i = 0; i < 10; i++) {
                System.out.println(getName());

                try {
                    sleep((int) (Math.random() * (100 - 600) + 600));
                } catch (InterruptedException ex) {
                    Logger.getLogger(PSP_Exercicio3.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        if (contSubHilos < 5) {

            contSubHilos++;
            subhilos = new PSP_Exercicio3("SUBHILO " + contSubHilos);
            subhilos.start();

            //Ponemos un join para que se ejecute ese hilo antes de que se
            //acabe el anterior, y así consecutivamente
            try {
                subhilos.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Exercicio3.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //Como el primer hilo es el "padre" de todos los demás subhilos, éste
        //será el último que acabe !
        System.out.println("Acaba hilo " + getName());

    }

    public static void main(String[] args) {

        PSP_Exercicio3 h1 = new PSP_Exercicio3("HILO 1");

        h1.start();

    }

}
