import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Polynomial {
	 private double[] coeffs;
	 public Polynomial(double... coeffs) {
		 this.coeffs = coeffs;
	 }
	 public Polynomial(String filename) { 
		 Scanner in = null; 
		   try { 
		       in = new Scanner(new File(filename));  // open file 
		    } catch (FileNotFoundException e) { 
		       e.printStackTrace(); 
		    } 
		    int degree = in.nextInt();      // read the degree 
		    coeffs = new double[degree+1];  // allocate the array 
		    for (int i=0; i<coeffs.length; i++) { 
		       coeffs[i] = in.nextDouble(); 
		    } 
	 }
		    
	 public int getDegree() {
		 return coeffs.length-1;
	 }
	 @Override
	 public String toString() {
		 String string = "";
		 int i = 0;
		 int e = coeffs.length-1;
		 while(i < coeffs.length-1) {
			 if(e==1) {
				 string += coeffs[i] + "x" ;
			 } else {
				 if(coeffs[i] == 0) {
					 
				 } else {
					 string += coeffs[i] + "x^" + e + " + ";
				 }
			 }
			 e--;
			 i++;
		 }
		 if(coeffs[coeffs.length-1] != 0) {
		 string += " + " + coeffs[coeffs.length-1];
		 }
		 return string;
	 }
	 public double evaluate(double x) {
		 double result = 0d;
		 for(int i = 0; i < coeffs.length;i++) {
			 result += coeffs[i]*Math.pow(x, i);
		 }
		 return result;
	 }
	 public Polynomial add(Polynomial p) {
		 Polynomial sum = new Polynomial(coeffs);
		 int l = 0;
		 int m = 0;
		 if(sum.coeffs.length >= p.coeffs.length) {
			 l = p.coeffs.length-1;
			 m = sum.coeffs.length-1;
			 while(l>=0) {
				 sum.coeffs[m] += p.coeffs[l];
				 //p.coeffs[l] = sum.coeffs[m] + p.coeffs[l];
				 m--;
				 l--;
			 }
			 return new Polynomial(sum.coeffs);
		 } else {
			 l = sum.coeffs.length-1;
			 m = p.coeffs.length-1;
			 while(l>=0) {
				 p.coeffs[m] += sum.coeffs[l];
				 m--;
				 l--;
			 }
			 return new Polynomial(p.coeffs);
		 } 
	 }
	 //coeffs[i+j] para meter cada numero en la posición correcta (como al multiplicar)
	 /*
	 public Polynomial multiply(Polynomial p) {
		 Polynomial mul = new Polynomial(coeffs);
		 int i = mul.coeffs.length-1;
		 double[] res = new double[(p.coeffs.length + mul.coeffs.length)];
		 for(int j = 0; i < res.length; i++) {
			 res[j] = 0;
		 }
		 
		 while(i >= 0) {
			 for (int j = 0; j<=mul.coeffs.length-1; j++) {
				 res[i+j] += (mul.coeffs[j]*p.coeffs[i]);
			 }
			 i--;
		 }
		 Polynomial result = new Polynomial(res);
		 return result;
	 }*/
}
