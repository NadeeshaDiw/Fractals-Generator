interface Fractals_Set {

    //method to map apoint in the JPanel to the region f intrest
    public static double [] map(int width, int height, int [] point, double [] axis){
		double [] temp  = new double[2];

		temp[0] = (((axis[1] + Math.abs(axis[0])) / (width-1)) * point[0]) + axis[0]; //map the x cordinate to the region of intrest
		temp[1] = (((axis[3] + Math.abs(axis[2])) / (height-1)) * point[1]) + axis[2]; //map the y cordinate to the region of intrest
		
		return temp; //return the mapped coordinates
	}

    //method to identify the diverge number "n"
	public static int fractal_calculate(Complex z, Complex c, int iterartion){
        double comp = 4.0;
        int diverge_num = 0;
        for(int i = 0; i <= iterartion; i++){
            if(Complex.squred_abs(z) > comp){ //if abs(z) > 2 break the loop 
                diverge_num = i;
                break;
            }
            z = Complex.add(Complex.squred(z) , c); //else iterate
            diverge_num = i;
        }
        return diverge_num; //retun the iteration number
    }

}