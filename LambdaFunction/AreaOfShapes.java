package LambdaFunction;

import java.util.Scanner;

interface Shape{
	double area();
}

public class AreaOfShapes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Shape circle = ()->{
			System.out.print("Enter the Radius of Circle : ");
			int radius = sc.nextInt();
			
			return 3.14*radius*radius;
		};
		
		Shape rectangle = ()->{
			System.out.print("Enter the length of rectangle : ");
			int length = sc.nextInt();
			System.out.print("Enter the length of rectangle : ");
			int breadth = sc.nextInt();
			
			return length*breadth;
		};
		
		Shape square = ()->{
			System.out.print("Enter the side of Square : ");
			int side = sc.nextInt();
			return side*side;
		};
		
		Shape sphere = ()->{
			System.out.print("Enter the radius of Sphere : ");
			int s = sc.nextInt();
			return (4*3.14*s*s);
		};
		
		Shape cube =()->{
			System.out.print("Enter the side of cube :");
			int side = sc.nextInt();
			return 6*side*side;
		};
		
		System.out.println("Area of cube : " +  cube.area());
		System.out.println("Area of circle : " +  circle.area());
		System.out.println("Area of rectangle : " +  rectangle.area());
		System.out.println("Area of sphere : " +  sphere.area());
		System.out.println("Area of square : " +  square.area());
		
		
		
	}

}
