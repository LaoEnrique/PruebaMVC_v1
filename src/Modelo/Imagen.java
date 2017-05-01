/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Imagen extends javax.swing.JPanel {

    String dir;
    public Imagen(String dir) {
        this.dir=dir;
        this.setSize(300, 320); //se selecciona el tamaño del panel
         
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        Dimension height = getSize();

        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        
            ImageIcon Img = new ImageIcon(getClass().getResource(dir));
        //se dibuja la imagen que tenemos en el paquete imagenes //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
       
        setOpaque(false);
        super.paintComponent(grafico);
    }
}
