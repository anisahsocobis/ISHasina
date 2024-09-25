/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hasina;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;

/**
 *
 * @author ASUS
 */
public class Hasina {
    /*public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tracer une courbe avec repère");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            Points essai = new Points();
            essai.ensemble(100.0, 2015.0);
            essai.ensemble(150.0, 2016.0);
            essai.ensemble(200.0, 2017.0);
            essai.ensemble(250.0, 2018.0);
            essai.ensemble(300.0, 2019.0);
            
            Courbe graphe = new Courbe(essai);
            frame.add(graphe);
            frame.setVisible(true);
        });
    }*/
    public static void main(String[] args) {
    JFrame frame = new JFrame("Tracer plusieurs courbes avec repère");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);

    Points courbe1 = new Points();
    courbe1.ensemble(100.0, 2015.0);
    courbe1.ensemble(150.0, 2016.0);
    courbe1.ensemble(200.0, 2017.0);
    courbe1.ensemble(250.0, 2018.0);
    courbe1.ensemble(300.0, 2019.0);

    Points courbe2 = new Points();
    courbe2.ensemble(100.0, 2017.0);
    courbe2.ensemble(150.0, 2018.0);
    courbe2.ensemble(200.0, 2019.0);
    courbe2.ensemble(250.0, 2020.0);
    courbe2.ensemble(300.0, 2021.0);

    List<Points> courbes = List.of(courbe1, courbe2);

    List<Color> couleurs = new ArrayList<>();
    couleurs.add(Color.BLUE);
    couleurs.add(Color.GREEN);
    Courbe graphe = new Courbe(courbes, couleurs);
    frame.add(graphe);
    frame.setVisible(true);
}
}
