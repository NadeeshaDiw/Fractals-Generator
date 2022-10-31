//class definition for Complex class
public class Complex {

    //define the class varibles fro the Comlex class
    private double real;
    private double imaginary;

    //Constructor oveloading 
    public Complex (double x, double y){
        this.real = x;
        this.imaginary = y;
    }

    //Getter methods for accessing the real and imaginary parts of a complex number object
    public double get_real(){return this.real;}
    public double get_imaginary(){return this.imaginary;}

    //method to return the squared absolute value of an complex number
    public static double squred_abs(Complex c) {
		double result = Math.pow(c.get_real(), 2) + Math.pow(c.get_imaginary(), 2);
        return result;
    }

    //method to return the additon of two complex number
    public static Complex add(Complex a, Complex b){
        Complex result = new Complex((a.get_real() + b.get_real()), (a.get_imaginary() + b.get_imaginary()));
        return result;
    }

    //method to return squred complx number
    public static Complex squred(Complex c){
        Complex result = new Complex((Math.pow(c.get_real(), 2) - Math.pow(c.get_imaginary(), 2)), (2*c.get_real()*c.get_imaginary()));
        return result;
    }
}