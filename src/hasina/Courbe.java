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

public class Courbe extends JPanel {
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

        g2.setColor(Color.BLACK);
        g2.drawLine(margin, margin + height, margin + width, margin + height);
        g2.drawLine(margin, margin + height, margin, margin);

        g2.setFont(new Font("Arial", Font.PLAIN, 12));
        for (int i = 0; i <= 10; i++) {
            int x = margin + i * (width / 10);
            int y = margin + height - i * (height / 10);
            g2.drawLine(x, margin + height - 5, x, margin + height + 5);
            g2.drawString(String.valueOf(i * 50), x - 10, margin + height + 20);

            g2.drawLine(margin - 5, y, margin + 5, y);
            g2.drawString(String.valueOf(i * 50), margin - 40, y + 5);
        }

        g2.setColor(Color.BLUE);
        List<Point2D> pointList = points.afficherPoints();
        for (int i = 0; i < pointList.size() - 1; i++) {
            int x1 = margin + (int) (pointList.get(i).getX() * (width / 500.0));
            int y1 = margin + height - (int) (pointList.get(i).getY() * (height / 500.0));
            int x2 = margin + (int) (pointList.get(i + 1).getX() * (width / 500.0));
            int y2 = margin + height - (int) (pointList.get(i + 1).getY() * (height / 500.0));

            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setColor(Color.RED);
        for (Point2D point : pointList) {
            int x = margin + (int) (point.getX() * (width / 500.0));
            int y = margin + height - (int) (point.getY() * (height / 500.0));
            g2.fillOval(x - 4, y - 4, 8, 8);
        }

        if (pointSurvole != null) {
            int x = margin + (int) (pointSurvole.getX() * (width / 500.0));
            int y = margin + height - (int) (pointSurvole.getY() * (height / 500.0));
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
