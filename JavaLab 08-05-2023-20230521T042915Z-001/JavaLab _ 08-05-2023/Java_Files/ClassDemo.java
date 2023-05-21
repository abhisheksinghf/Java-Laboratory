class Box
{
//	class variables
	double width;
	double height;
	double depth;
}
public class ClassDemo {
	public static void main(String args[])
	{
		double vol;
//		Object creation
		Box mybox = new Box();
		mybox.width = 10;//accessing class members using object variable mybox
		mybox.depth = 15;
		mybox.height = 20;
		vol = mybox.width*mybox.height*mybox.depth;
		
//		Printing the volume
		System.out.println("Volume of Box is "+vol);
	}
}
