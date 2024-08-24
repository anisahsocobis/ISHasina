/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hasina;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class Hasina {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tracer une courbe avec repère");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

          
            Points essai = new Points();
            essai.ensemble(100.0, 500.0);
            essai.ensemble(150.0, 450.0);
            essai.ensemble(200.0, 400.0);
            essai.ensemble(250.0, 350.0);
            essai.ensemble(300.0, 300.0);
            
            Courbe graphe = new Courbe(essai);
            frame.add(graphe);
            frame.setVisible(true);
        });
    }
}
