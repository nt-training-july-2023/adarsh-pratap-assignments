package Annotations;

/**
 * Class to give the area of different shapes 
 * 
 * 
 * @author adarsh
 * @version 1.0
 * @since 25-07-2023
 */

public class JavaDoc {
	
	/**
	 * method to find the Area of rectangle 
	 * 
	 * @param length of integer type value
	 * @param width of integer type value
	 * @return double value
	 */
	
	public double AreaOfRectangle(int length , int width) {
		return length* width;
		
	}
	
	/**
	 * method to find the area of Circle
	 * 
	 * 
	 * @param radius takes float type value
	 * @return double type value 
	 */
	
	public double AreaOfCircle(float radius) {
		return (3.14*radius*radius);
	}
	
	/**
	 * method to find the area of triangle
	 * 
	 * @param base int type value 
	 * @param height int type value 
	 * @return double value
	 */
	
	public double AreaOfTriangle(int base , int height) {
		return (0.5*base*height);
	}
	
	/**
	 * main method where the execution of program begins 
	 * 
	 * 
	 * @param args
	 * 
	 * 
	 */

	public static void main(String[] args) {
		
		
		JavaDoc doc = new JavaDoc();
		
		System.out.println(doc.AreaOfCircle(2));
		
		System.out.println(doc.AreaOfRectangle(2, 4));
		
		System.out.println(doc.AreaOfTriangle(2, 4));
		
		
		

	}

}
