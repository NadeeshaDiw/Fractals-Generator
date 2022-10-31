import javax.swing.*;

public class Fractals {

	//keep the width and height of the panel
	public static int width = 800;
	public static int height = 800; 

    public static void main(String [] args){
	
    	try {
    		if (args[0].toLowerCase().equals("mandelbrot") || args[0].toLowerCase().equals("julia")){
    			JFrame frame = new JFrame(args[0]+" Set");				//initializing the Jpanel
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
    			//if required set is mandelbrot then printing the corresponding set
    			if(args[0].toLowerCase().equals("mandelbrot")) {
    				Mandelbrot m =null;
				
    				//according to argumet count initialize the mandelbrot object to print the set
    				try {
    					if(args.length == 1) {m = new Mandelbrot(width, height);}
    					if(args.length == 5) {m = new Mandelbrot(width, height, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), 1000);}
    					if(args.length == 6) {m = new Mandelbrot(width, height, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]));}
				
    					frame.setContentPane(m); //initialize the JFrame with the mandelbrot object
    				}
    				catch (Exception e){ //if any exception is thrown print the error messages
    					System.out.println("\t-- INCORRECT PARAMETER PASSING --");
    					usage();
    					System.out.println(" <a> <b> <c> <d> <iteration>\n");
    					System.out.println("To set the Region of Interest for the image : [a < real < b] [c < imaginary < d]");
    					System.out.println("Or leave blank for the default settings     : [-1 < real < 1] [-1 < imaginary < 1] [1000 iterations]");
    					return;
    				}
    			}
			
    			//if required set is julia then printing the corresponding set
    			else if(args[0].toLowerCase().equals("julia")) {
    				Julia j = null;
				
    				//according to argumet count initialize the julia object to print the set
    				try {
    					if(args.length == 1) {j = new Julia(width, height);}
    					if(args.length == 4) {j = new Julia(width, height, Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]));}
				
    					frame.setContentPane(j); //initialize the JFrame with the julia object
    				}
    				catch (Exception e){ //if any exception is thrown print the error messages
    					System.out.println("\t-- INCORRECT PARAMETER PASSING --");
    					usage();
    					System.out.println(" <a> <b> <iteration>\n");
    					System.out.println("To set the Complex number                : [a - real] [b - imaginary]");
    					System.out.println("Or leave blank for the default settings  : [-0.4 - real] [0.6 - imaginary] [1000 iterations]");
    					return;	
    				}
    			}
			
    			//set the other parametrs of the JFrame object
    			frame.pack(); 
    			frame.setLocationRelativeTo(null); 
    			frame.setVisible(true);
    		}
    		else {
    			System.out.println("Wrong Set Name !!");
    		}
    	}
    	catch (Exception e){
			//if wrong argument passed print error messages
			usage();
			System.out.print("\n");
			return;
        }
    }

	//method to print the usage
    public static void usage(){ 
        System.out.print("USAGE : java Fractals <Set Name>");
    }

}