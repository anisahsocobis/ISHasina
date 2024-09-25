/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package hasina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

/*public class Courbe extends JPanel {
    private Points points;
    private Point2D pointSurvole;

    public Courbe(Points points) {
        this.points = points;

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}

            @Override
            public void mouseMoved(MouseEvent e) {
                pointSurvole = getPointAt(e.getPoint());
                repaint();
            }
        });
    }

    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int margin = 50;
    int width = getWidth() - margin * 2;
    int height = getHeight() - margin * 2;

    // Dessin des axes
    g2.setColor(Color.BLACK);
    g2.drawLine(margin, margin + height, margin + width, margin + height); // Axe des X
    g2.drawLine(margin, margin + height, margin, margin); // Axe des Y

    g2.setFont(new Font("Arial", Font.PLAIN, 12));

    // Modifier l'axe des Y pour afficher les années de 2015 à 2025
    int startYear = 2015;
    int endYear = 2025;
    int yearRange = endYear - startYear;

    for (int i = 0; i <= 10; i++) {
        int y = margin + height - i * (height / 10);
        int year = startYear + i;

        // Dessiner la ligne de graduation et afficher l'année
        g2.drawLine(margin - 5, y, margin + 5, y);
        g2.drawString(String.valueOf(year), margin - 40, y + 5);
    }

    // Reste du code pour l'axe des X (inchangé)
    for (int i = 0; i <= 10; i++) {
        int x = margin + i * (width / 10);
        g2.drawLine(x, margin + height - 5, x, margin + height + 5);
        g2.drawString(String.valueOf(i * 50), x - 10, margin + height + 20); // Pour les valeurs de l'axe X
    }

    // Dessin des points et courbes (adapté pour l'axe des Y basé sur les années)
    g2.setColor(Color.BLUE);
    List<Point2D> pointList = points.afficherPoints();
    for (int i = 0; i < pointList.size() - 1; i++) {
        int x1 = margin + (int) (pointList.get(i).getX() * (width / 500.0));
        int y1 = margin + height - (int) ((pointList.get(i).getY() - startYear) * (height / (double) yearRange));
        int x2 = margin + (int) (pointList.get(i + 1).getX() * (width / 500.0));
        int y2 = margin + height - (int) ((pointList.get(i + 1).getY() - startYear) * (height / (double) yearRange));

        g2.drawLine(x1, y1, x2, y2);
    }

    g2.setColor(Color.RED);
    for (Point2D point : pointList) {
        int x = margin + (int) (point.getX() * (width / 500.0));
        int y = margin + height - (int) ((point.getY() - startYear) * (height / (double) yearRange));
        g2.fillOval(x - 4, y - 4, 8, 8);
    }

    if (pointSurvole != null) {
        int x = margin + (int) (pointSurvole.getX() * (width / 500.0));
        int y = margin + height - (int) ((pointSurvole.getY() - startYear) * (height / (double) yearRange));
        g2.setColor(Color.BLACK);
        String text = String.format("(%.2f, %.2f)", pointSurvole.getX(), pointSurvole.getY());
        g2.drawString(text, x + 10, y - 10);
    }
}



    private Point2D getPointAt(Point mousePoint) {
        int margin = 50;
        int width = getWidth() - margin * 2;
        int height = getHeight() - margin * 2;
        double mouseX = mousePoint.getX() - margin;
        double mouseY = (height + margin) - mousePoint.getY();
        
        List<Point2D> pointList = points.afficherPoints();
        Point2D closestPoint = null;
        double minDistance = Double.MAX_VALUE;

        for (Point2D point : pointList) {
            int x = margin + (int) (point.getX() * (width / 500.0));
            int y = margin + height - (int) (point.getY() * (height / 500.0));
            double distance = Math.sqrt(Math.pow(mouseX - x, 2) + Math.pow(mouseY - y, 2));
            if (distance < minDistance) {
                minDistance = distance;
                closestPoint = point;
            }
        }
        return closestPoint;
    }
}

class Point2D {
    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class Courbe extends JPanel {
    private List<Points> pointsList; 
    private List<Color> courbeColors; 
    private Point2D pointSurvole;

    public Courbe(List<Points> pointsList, List<Color> courbeColors) {
        this.pointsList = pointsList;
        this.courbeColors = courbeColors;

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}

            @Override
            public void mouseMoved(MouseEvent e) {
                pointSurvole = getPointAt(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int margin = 50;
        int width = getWidth() - margin * 2;
        int height = getHeight() - margin * 2;

        g2.setColor(Color.BLACK);
        g2.drawLine(margin, margin + height, margin + width, margin + height); // Axe des X
        g2.drawLine(margin, margin + height, margin, margin); // Axe des Y

        g2.setFont(new Font("Arial", Font.PLAIN, 12));

        // Modifier l'axe des Y pour afficher les années de 2015 à 2025
        int startYear = 2015;
        int endYear = 2025;
        int yearRange = endYear - startYear;

        for (int i = 0; i <= 10; i++) {
            int y = margin + height - i * (height / 10);
            int year = startYear + i;

            g2.drawLine(margin - 5, y, margin + 5, y);
            g2.drawString(String.valueOf(year), margin - 40, y + 5);
        }

        for (int i = 0; i <= 10; i++) {
            int x = margin + i * (width / 10);
            g2.drawLine(x, margin + height - 5, x, margin + height + 5);
            g2.drawString(String.valueOf(i * 50), x - 10, margin + height + 20); // Pour les valeurs de l'axe X
        }

        for (int j = 0; j < pointsList.size(); j++) {
            Points points = pointsList.get(j);
            List<Point2D> pointList = points.afficherPoints();
            
            g2.setColor(courbeColors.get(j));

            for (int i = 0; i < pointList.size() - 1; i++) {
                int x1 = margin + (int) (pointList.get(i).getX() * (width / 500.0));
                int y1 = margin + height - (int) ((pointList.get(i).getY() - startYear) * (height / (double) yearRange));
                int x2 = margin + (int) (pointList.get(i + 1).getX() * (width / 500.0));
                int y2 = margin + height - (int) ((pointList.get(i + 1).getY() - startYear) * (height / (double) yearRange));

                g2.drawLine(x1, y1, x2, y2);
            }

            g2.setColor(Color.RED);
            for (Point2D point : pointList) {
                int x = margin + (int) (point.getX() * (width / 500.0));
                int y = margin + height - (int) ((point.getY() - startYear) * (height / (double) yearRange));
                g2.fillOval(x - 4, y - 4, 8, 8);
            }
        }

        if (pointSurvole != null) {
            int x = margin + (int) (pointSurvole.getX() * (width / 500.0));
            int y = margin + height - (int) ((pointSurvole.getY() - startYear) * (height / (double) yearRange));
            g2.setColor(Color.BLACK);
            String text = String.format("(%.2f, %.2f)", pointSurvole.getX(), pointSurvole.getY());
            g2.drawString(text, x + 10, y - 10);
        }
    }

    private Point2D getPointAt(Point mousePoint) {
        int margin = 50;
        int width = getWidth() - margin * 2;
        int height = getHeight() - margin * 2;
        double mouseX = mousePoint.getX() - margin;
        double mouseY = (height + margin) - mousePoint.getY();

        List<Point2D> closestPoints = null;
        Point2D closestPoint = null;
        double minDistance = Double.MAX_VALUE;

        for (Points points : pointsList) {
            List<Point2D> pointList = points.afficherPoints();
            for (Point2D point : pointList) {
                int x = margin + (int) (point.getX() * (width / 500.0));
                int y = margin + height - (int) ((point.getY() - 2015) * (height / (double) 10));
                double distance = Math.sqrt(Math.pow(mouseX - x, 2) + Math.pow(mouseY - y, 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPoint = point;
                }
            }
        }
        return closestPoint;
    }
}

class Point2D {
    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}