import java.util.Scanner;
class AreaOfCircle
{
	double radius;
	
	public void setRadius(double r)
	{
		radius = r;
	}
	public double getRadius()
	{
		return (3.14*radius*radius);
	}
}
public class AreOfCircle {
	public static void main(String args[])
	{
		double rad;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Radius : ");
		rad = sc.nextDouble();
		
		AreaOfCircle cir = new AreaOfCircle();
		
		cir.setRadius(rad);
		
		System.out.println("The Area of Circle is "+cir.getRadius());
		
		
	}
}
