package Modelo;

/**
 *
 * @author ces ces2601[arroba]gmail.com
 */
import Vista.Ahorcado;
import javax.swing.JFrame;

public class Cronometro implements Runnable {

    Thread crono;
    javax.swing.JLabel tiempo = new javax.swing.JLabel();
    
    Ahorcado ad=new Ahorcado();
     

    /**
     * Creates new form cronometro
     */
    public Cronometro() {
       crono = new Thread(this);
        crono.start();
    }

    int minutos = 0, segundos = 0, horas = 0;

    public void run() {
        try {
            for (;;) {
                if (segundos == 59) {
                    segundos = 0;
                    minutos++;
                }
                if (minutos == 59) {
                    minutos = 0;
                    horas++;
                }
                segundos++;

                tiempo.setText(horas + ":" + minutos + ":" + segundos);
                crono.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String args[]) {
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Cronometro();
            }
        });
    }

}
