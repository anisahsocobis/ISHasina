/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hasina;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.List;
/*public class Points {
    List<Point2D> points = new ArrayList<>();
    public void ensemble(double x, double y){
        
            points.add(new Point2D(x, y));
    }
    public List afficherPoints(){
        return points; 
    }
}*/
import java.util.ArrayList;
import java.util.List;

class Points {
    private List<Point2D> points;

    public Points() {
        points = new ArrayList<>();
    }

    public void ensemble(double x, double y) {
        points.add(new Point2D(x, y));
    }

    public List<Point2D> afficherPoints() {
        return points;
    }
}
