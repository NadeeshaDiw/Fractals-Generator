import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

//Class Mandelbrot is extending the JPanel and implements the Fractals_Set interface
public class Mandelbrot extends JPanel implements Fractals_Set{

	//define the class variables for the Mandelbrot set
     private int width, height;
     private double re_left, re_right;
     private double im_down, im_up;
     private int iter;
     private Complex z = new Complex(0, 0); //initialize Zo with ZERO
     private  Complex c;

     //Overloading the constructor with new parameters
     public Mandelbrot(int width, int height, double re_left, double re_right, double im_down, double im_up, int iteration) {
          this.width = width;
          this.height = height;
          this.re_left = re_left;
          this.re_right = re_right;
          this.im_down = im_down;
          this.im_up = im_up;
          this.iter = iteration;
          setPreferredSize(new Dimension(width, height)); 
     }

     //Overloading the constructor
     public Mandelbrot(int width, int height){
          this.width = width;
          this.height = height;
          this.re_left = -1;
          this.re_right = 1;
          this.im_down = -1;
          this.im_up = 1;
          this.iter = 1000;
          setPreferredSize(new Dimension(width, height)); 
     }

     //Overriding the printPoint method
     private static void printPoint(Graphics2D frame, Color c, int x, int y) {
          frame.setColor(c); 
          frame.draw(new Line2D.Double(x, y, x, y)); 
     }

     //Overriding the PaintComponent method
     public void paintComponent(Graphics g) { 
          super.paintComponent(g);

          //iterate through the all points in the panel
          for(int x = 0; x < this.width; x++){
               for(int y = (this.height-1); y >= 0; y--){

                    int temp_y = (height-1) - y;
                    int map_point [] = {x, temp_y};
                    double axis [] = {this.re_left, this.re_right, this.im_down, this.im_up};
                    
                    //take the mapped points in the region of interest
                    double [] point = Fractals_Set.map(this.width, this.height, map_point, axis);

                    //initialize the complex number with the mapped point
                    c = new Complex(point[0], point[1]);

                    //take the iteration number (diverging number)
                    int n = Fractals_Set.fractal_calculate(this.z, this.c, this.iter);
                    
                    //if point in the region of intrest, mark that with black color
                    if (n == this.iter){

                         printPoint((Graphics2D)g, Color.black, x, y);

                    }else {
                         //if the point in not in the set, assign a color for it based on the it's iteration number
                         float hue = n / 256.0f;
                         float saturation = 1f;
                         float brightness = n / (n + 8f);

                         Color clr = Color.getHSBColor(hue, saturation, brightness);
                         printPoint((Graphics2D)g, clr, x, y);
                    }
               }
          }
     }
}
