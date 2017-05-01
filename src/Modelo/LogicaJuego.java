/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

;
import Vista.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LogicaJuego {

    public void cambiarDatos(String palabra,String intentos, String numPalabras) {
        Menu mn = new Menu();
        char [] palabra_ori=mn.getPalabra_ori();
        char[] palabra_aux=mn.getPalabra_aux();
        int max_intentos=Integer.parseInt(intentos);
        int numeroPalabras=Integer.parseInt(numPalabras);
     
        for (int i = 0; i < palabra.length(); i++) {
            palabra_ori[i] = palabra.charAt(i);
            palabra_aux[i] = '_';
            
            mn.setPalabra_aux(palabra_aux);
            mn.setPalabra_ori(palabra_ori);
        }
       
        mn.setMax_intentos(max_intentos);
        mn.setMax_letras(numeroPalabras);
        
        JOptionPane.showMessageDialog(null, "Datos Cambiados Correctamente!!!");
    }
    //Compara la palabra original con la auxiliar   

    public void  compararPalabras() {
         Menu mn = new Menu();
        char [] palabra_ori=mn.getPalabra_ori();
        char[] palabra_aux=mn.getPalabra_aux();
        boolean encontrada=mn.isEncontrada();
        
        for (int i = 0; i < palabra_ori.length; i++) {
            if ((int) palabra_ori[i] != 0) {
                if (palabra_ori[i] == palabra_aux[i]) {
                    encontrada = true;
                } else {
                    encontrada = false;
                    break;
                }
            }
        }
        mn.setEncontrada(encontrada);
    }

    
//Busca letra en la palabra original y la pinta en la palabra auxiliar     
    public static void buscaLetraEnPalabra(char c) {
        System.out.println(" Letra ingresada " + c);
         Menu mn = new Menu();
        char [] palabra_ori=mn.getPalabra_ori();
        char[] palabra_aux=mn.getPalabra_aux();
        
        for (int i = 0; i < palabra_ori.length; i++) {
            if (c == palabra_ori[i]) {
                palabra_aux[i] = c;
            }
        }
    }

//Iniciar juego    
    public static void iniciarJuego() {
        limpiarPalabraAux();

        char letra;
        do {
            System.out.println("\n");

//Muestro la palabra             
            for (char l : palabra_aux) {
                if ((int) l != 0) {
                    System.out.print(" " + l);
                }
            }
            System.out.print(" \n\n Ingrese una letra : ");
            letra = new String(sc.next()).charAt(0);
            buscaLetraEnPalabra(letra);
            compararPalabras();
            intentos++;
            System.out.println(" Intentos " + intentos + " Max intentos " + max_intentos);
        } while (intentos < max_intentos && !encontrada);
        
        if (intentos < max_intentos && encontrada) {
            System.out.println(" Encontrada >> " + encontrada);
            JOptionPane.showMessageDialog(null, "G A N A S T E ");
            JOptionPane.showMessageDialog(null, letra, null, letra);
            System.out.println("  Numero de intentos requeridos : " + intentos);
        } else {
            
            JOptionPane.showMessageDialog(null, "G A M E     O V E R ");
            
        }
    }

    //Limpiar aux
    public static void limpiarPalabraAux() {
         Menu mn = new Menu();
        char [] palabra_ori=mn.getPalabra_ori();
        char[] palabra_aux=mn.getPalabra_aux();
        for (int i = 0; i < palabra_aux.length; i++) {
            palabra_aux[i] = ' ';
        }
        
        for (int i = 0; i < palabra.length(); i++) {
            palabra_aux[i] = '_';
        }
    }
}
