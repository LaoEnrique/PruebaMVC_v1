/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cronometro;
import Modelo.Imagen;
import com.sun.glass.events.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Ahorcado extends javax.swing.JFrame implements Runnable {

    Thread crono;
    char letra;

    /**
     * Creates new form Ahorcado
     */
    public Ahorcado() {
        initComponents();
        crono = new Thread(this);
        crono.start();
        cambiaEstado();
        String pal = "";
        String palErr = "";
        definirPalabra();

    }

    //arreglo de palabras que se van a adivinar
    String arrayPalabras[] = {"hola", "adios", "itson"};

    private String Random() {
        int num = (int) (Math.random() * (arrayPalabras.length));
        return arrayPalabras[num];
    }

    public void definirPalabra() {

        char pal[] = Random().toCharArray();
       ;
        //llena un string con "_" 
        for (int i = 0; i < pal.length; i++) {
            palabra_ori[i] = pal.;
            palabra_aux[i] = '_';
        }
        System.out.println(" Palabra definida exitosamente!!!");
    }

    //Busca letra en la palabra original y la pinta en la palabra auxiliar     
    public static void buscaLetraEnPalabra(char c) {
        System.out.println(" Letra ingresada " + c);
        for (int i = 0; i < palabra_ori.length; i++) {
            if (c == palabra_ori[i]) {
                palabra_aux[i] = c;
            }
        }
    }
//Compara la palabra original con la auxiliar   

    public static void compararPalabras() {
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
    }
    int minutos = 0, segundos = 0, horas = 0;

    public void run() {
        try {
            for (;;) {

                if (segundos == 10) {
                    JOptionPane.showMessageDialog(null, "Se te acabo el tiempo");
                    JOptionPane.showMessageDialog(null, "Cambio de turno");
                    this.estado = estado++;
                    cambiaEstado(estado);
                    segundos = 0;
                    crono.resume();
                }
                // if (minutos == 59) {
                //    minutos = 0;
                //    horas++;
                // }
                segundos++;

                cronometro.setText(horas + ":" + minutos + ":" + segundos);
                crono.sleep(1000);

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cambiaEstado(int numEsta) {
        int numEstad = numEsta;
        if (numEstad == 7) {

            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/7.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            JOptionPane.showMessageDialog(null, "GAMER OVER");
            crono.stop();
            estado++;
        } else if (numEstad == 6) {

            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/6.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();

            estado++;
        } else if (numEstad == 5) {

            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/5.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();

            estado++;
        } else if (numEstad == 4) {
            crono.suspend();
            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/4.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();

            estado++;
        } else if (numEstad == 3) {

            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/3.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();

            estado++;
        } else if (numEstad == 2) {

            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/2.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();

            estado++;
        }
    }

    public void cambiaEstado() {
        if (estado == 7) {

            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/7.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
            JOptionPane.showMessageDialog(null, "GAMER OVER");
            crono.stop();
            estado++;
        } else if (estado == 6) {
            crono.suspend();
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
            JOptionPane.showMessageDialog(null, "Cambio de turno");
            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/6.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            segundos = 0;
            crono.resume();
            estado++;
        } else if (estado == 5) {
            crono.suspend();
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
            JOptionPane.showMessageDialog(null, "Cambio de turno");
            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/5.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            segundos = 0;
            crono.resume();
            estado++;
        } else if (estado == 4) {
            crono.suspend();
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
            JOptionPane.showMessageDialog(null, "Cambio de turno");
            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/4.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            segundos = 0;
            crono.resume();
            estado++;
        } else if (estado == 3) {
            crono.suspend();
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
            JOptionPane.showMessageDialog(null, "Cambio de turno");
            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/3.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            segundos = 0;
            crono.resume();
            estado++;
        } else if (estado == 2) {
            crono.suspend();
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
            JOptionPane.showMessageDialog(null, "Cambio de turno");
            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/2.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            segundos = 0;
            crono.resume();
            estado++;
        } else if (estado == 1) {

            imagenPanel.removeAll();
            Imagen Imagen = new Imagen("/imagenes/1.png");
            imagenPanel.add(Imagen);
            imagenPanel.repaint();
            estado++;
        }
    }
    //Atributos de clase  
    private static final int max_letras = 10;
    private static boolean encontrada = false;
    public static char[] palabra_ori = new char[max_letras];
    public static char[] palabra_aux = new char[max_letras];

    public static String palabra;

    int estado = 1;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelJuego = new javax.swing.JPanel();
        cronometro = new javax.swing.JLabel();
        imagenPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnA = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnH = new javax.swing.JButton();
        btnI = new javax.swing.JButton();
        btnJ = new javax.swing.JButton();
        btnK = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnO = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnV = new javax.swing.JButton();
        btnW = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnY = new javax.swing.JButton();
        btnZ = new javax.swing.JButton();
        panelAdivinar = new javax.swing.JPanel();
        labelAdivinar = new javax.swing.JLabel();
        panelErrores = new javax.swing.JPanel();
        labelErrores = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelJuego.setBackground(new java.awt.Color(255, 255, 255));

        cronometro.setBackground(new java.awt.Color(255, 255, 255));
        cronometro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout imagenPanelLayout = new javax.swing.GroupLayout(imagenPanel);
        imagenPanel.setLayout(imagenPanelLayout);
        imagenPanelLayout.setHorizontalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
        imagenPanelLayout.setVerticalGroup(
            imagenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        jButton1.setText("Prueba...Sig..");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar Crono");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        jLabel3.setText("Parabra a adividar");

        jLabel4.setText("Letras Erroneas");

        jLabel5.setText("Turnos de 10 segundos");

        btnA.setBackground(new java.awt.Color(255, 255, 255));
        btnA.setText("A");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnC.setBackground(new java.awt.Color(255, 255, 255));
        btnC.setText("C");
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        btnB.setBackground(new java.awt.Color(255, 255, 255));
        btnB.setText("B");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnD.setBackground(new java.awt.Color(255, 255, 255));
        btnD.setText("D");
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        btnE.setBackground(new java.awt.Color(255, 255, 255));
        btnE.setText("E");
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnF.setBackground(new java.awt.Color(255, 255, 255));
        btnF.setText("F");
        btnF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFActionPerformed(evt);
            }
        });

        btnH.setBackground(new java.awt.Color(255, 255, 255));
        btnH.setText("H");
        btnH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHActionPerformed(evt);
            }
        });

        btnI.setBackground(new java.awt.Color(255, 255, 255));
        btnI.setText("I");
        btnI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIActionPerformed(evt);
            }
        });

        btnJ.setBackground(new java.awt.Color(255, 255, 255));
        btnJ.setText("J");
        btnJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJActionPerformed(evt);
            }
        });

        btnK.setBackground(new java.awt.Color(255, 255, 255));
        btnK.setText("K");
        btnK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKActionPerformed(evt);
            }
        });

        btnL.setBackground(new java.awt.Color(255, 255, 255));
        btnL.setText("L");
        btnL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLActionPerformed(evt);
            }
        });

        btnM.setBackground(new java.awt.Color(255, 255, 255));
        btnM.setText("M");
        btnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMActionPerformed(evt);
            }
        });

        btnN.setBackground(new java.awt.Color(255, 255, 255));
        btnN.setText("N");
        btnN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNActionPerformed(evt);
            }
        });

        btnO.setBackground(new java.awt.Color(255, 255, 255));
        btnO.setText("O");
        btnO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOActionPerformed(evt);
            }
        });

        btnP.setBackground(new java.awt.Color(255, 255, 255));
        btnP.setText("P");
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });

        btnQ.setBackground(new java.awt.Color(255, 255, 255));
        btnQ.setText("Q");
        btnQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQActionPerformed(evt);
            }
        });

        btnR.setBackground(new java.awt.Color(255, 255, 255));
        btnR.setText("R");
        btnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRActionPerformed(evt);
            }
        });

        btnS.setBackground(new java.awt.Color(255, 255, 255));
        btnS.setText("S");
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        btnT.setBackground(new java.awt.Color(255, 255, 255));
        btnT.setText("T");
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        btnU.setBackground(new java.awt.Color(255, 255, 255));
        btnU.setText("U");
        btnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUActionPerformed(evt);
            }
        });

        btnV.setBackground(new java.awt.Color(255, 255, 255));
        btnV.setText("V");
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });

        btnW.setBackground(new java.awt.Color(255, 255, 255));
        btnW.setText("W");
        btnW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWActionPerformed(evt);
            }
        });

        btnX.setBackground(new java.awt.Color(255, 255, 255));
        btnX.setText("X");
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        btnY.setBackground(new java.awt.Color(255, 255, 255));
        btnY.setText("Y");
        btnY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYActionPerformed(evt);
            }
        });

        btnZ.setBackground(new java.awt.Color(255, 255, 255));
        btnZ.setText("Z");
        btnZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZActionPerformed(evt);
            }
        });

        panelAdivinar.setBackground(new java.awt.Color(255, 255, 255));
        panelAdivinar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelAdivinarLayout = new javax.swing.GroupLayout(panelAdivinar);
        panelAdivinar.setLayout(panelAdivinarLayout);
        panelAdivinarLayout.setHorizontalGroup(
            panelAdivinarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAdivinar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelAdivinarLayout.setVerticalGroup(
            panelAdivinarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAdivinar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        panelErrores.setBackground(new java.awt.Color(255, 255, 255));
        panelErrores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelErroresLayout = new javax.swing.GroupLayout(panelErrores);
        panelErrores.setLayout(panelErroresLayout);
        panelErroresLayout.setHorizontalGroup(
            panelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelErrores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelErroresLayout.setVerticalGroup(
            panelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelErrores, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelAdivinar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelJuegoLayout.createSequentialGroup()
                                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                                .addComponent(btnL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnM))
                                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                                .addComponent(btnF)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnH)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnO)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnP))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJuegoLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(btnJ)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnK))))
                                    .addGroup(panelJuegoLayout.createSequentialGroup()
                                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnV)
                                            .addComponent(btnQ))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                                .addComponent(btnR)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnS)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnT)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnU))
                                            .addGroup(panelJuegoLayout.createSequentialGroup()
                                                .addComponent(btnW)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnX)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnY)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnZ))))
                                    .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(panelErrores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelJuegoLayout.createSequentialGroup()
                                            .addComponent(btnA)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnB)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnC)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnD)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnE)))
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJuegoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(btnReiniciar))
                .addGap(86, 86, 86))
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(panelAdivinar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(panelErrores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnA)
                            .addComponent(btnC)
                            .addComponent(btnB)
                            .addComponent(btnD)
                            .addComponent(btnE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnF)
                            .addComponent(btnH)
                            .addComponent(btnI)
                            .addComponent(btnJ)
                            .addComponent(btnK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnL)
                            .addComponent(btnM)
                            .addComponent(btnN)
                            .addComponent(btnO)
                            .addComponent(btnP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQ)
                            .addComponent(btnR)
                            .addComponent(btnS)
                            .addComponent(btnT)
                            .addComponent(btnU))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnV)
                            .addComponent(btnW)
                            .addComponent(btnX)
                            .addComponent(btnY)
                            .addComponent(btnZ))))
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReiniciar)
                        .addGap(9, 9, 9))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cambiaEstado();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        segundos = 0;
        crono.resume();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        btnC.setBackground(Color.blue);
    }//GEN-LAST:event_btnCActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        btnB.setBackground(Color.blue);
    }//GEN-LAST:event_btnBActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        btnD.setBackground(Color.blue);
    }//GEN-LAST:event_btnDActionPerformed

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
        btnE.setBackground(Color.blue);
        segundos = 0;
        crono.resume();
        btnE.setEnabled(false);
    }//GEN-LAST:event_btnEActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        btnA.setBackground(Color.blue);

        letra = btnA.getText().charAt(0);
        buscaLetraEnPalabra(letra);
        compararPalabras();
        //Muestro la palabra             
        for (char l : palabra_aux) {
            if ((int) l != 0) {
                labelAdivinar.setText(palabra_aux.toString());
                System.out.print(" " + l);
            }
        }
    }//GEN-LAST:event_btnAActionPerformed

    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPActionPerformed
        btnP.setBackground(Color.blue);
        segundos = 0;
        crono.resume();
        btnP.setEnabled(false);
    }//GEN-LAST:event_btnPActionPerformed

    private void btnRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRActionPerformed

        btnR.setEnabled(false);
        btnR.setBackground(Color.blue);
        segundos = 0;
        crono.resume();
    }//GEN-LAST:event_btnRActionPerformed

    private void btnFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFActionPerformed
        btnF.setBackground(Color.blue);
    }//GEN-LAST:event_btnFActionPerformed

    private void btnHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHActionPerformed
        btnH.setBackground(Color.blue);
    }//GEN-LAST:event_btnHActionPerformed

    private void btnIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIActionPerformed
        btnI.setBackground(Color.blue);
    }//GEN-LAST:event_btnIActionPerformed

    private void btnJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJActionPerformed
        btnJ.setBackground(Color.blue);
    }//GEN-LAST:event_btnJActionPerformed

    private void btnKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKActionPerformed
        btnK.setBackground(Color.blue);
    }//GEN-LAST:event_btnKActionPerformed

    private void btnLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLActionPerformed
        btnL.setBackground(Color.blue);
    }//GEN-LAST:event_btnLActionPerformed

    private void btnMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMActionPerformed
        btnM.setBackground(Color.blue);
    }//GEN-LAST:event_btnMActionPerformed

    private void btnNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNActionPerformed
        btnN.setBackground(Color.blue);
    }//GEN-LAST:event_btnNActionPerformed

    private void btnOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOActionPerformed
        btnO.setBackground(Color.blue);
    }//GEN-LAST:event_btnOActionPerformed

    private void btnQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQActionPerformed
        btnQ.setBackground(Color.blue);
    }//GEN-LAST:event_btnQActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        btnS.setBackground(Color.blue);
    }//GEN-LAST:event_btnSActionPerformed

    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        btnT.setBackground(Color.blue);
    }//GEN-LAST:event_btnTActionPerformed

    private void btnUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUActionPerformed
        btnU.setBackground(Color.blue);
    }//GEN-LAST:event_btnUActionPerformed

    private void btnVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVActionPerformed
        btnV.setBackground(Color.blue);
    }//GEN-LAST:event_btnVActionPerformed

    private void btnWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWActionPerformed
        btnW.setBackground(Color.blue);
    }//GEN-LAST:event_btnWActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        btnX.setBackground(Color.blue);
    }//GEN-LAST:event_btnXActionPerformed

    private void btnYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYActionPerformed
        btnY.setBackground(Color.blue);
    }//GEN-LAST:event_btnYActionPerformed

    private void btnZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZActionPerformed
        btnZ.setBackground(Color.blue);
    }//GEN-LAST:event_btnZActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnD;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnF;
    private javax.swing.JButton btnH;
    private javax.swing.JButton btnI;
    private javax.swing.JButton btnJ;
    private javax.swing.JButton btnK;
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnM;
    private javax.swing.JButton btnN;
    private javax.swing.JButton btnO;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnQ;
    private javax.swing.JButton btnR;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnU;
    private javax.swing.JButton btnV;
    private javax.swing.JButton btnW;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnY;
    private javax.swing.JButton btnZ;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel cronometro;
    private javax.swing.JPanel imagenPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelAdivinar;
    private javax.swing.JLabel labelErrores;
    private javax.swing.JPanel panelAdivinar;
    private javax.swing.JPanel panelErrores;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
