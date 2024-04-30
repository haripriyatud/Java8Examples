
interface Calculate{
	default double areaOfCircle(double r){
		return 3.14*r*r;
	       
	    }
	public int areaOfSquare(int side);
	public int areaOfRectangle(int length,int breadth);
}




public class AreaCalculation implements Calculate {
	
	
	@Override
	public int areaOfSquare(int side) {
	return side*side;
	}
	

	@Override
	public int areaOfRectangle(int length, int breadth) {
		return length*breadth;
	}


	public static void main(String[] args) {
	
		
		AreaCalculation al = new AreaCalculation();
		System.out.println("Area of Square: "+ al.areaOfSquare(5));
		System.out.println("Area of Circle: " + al.areaOfCircle(7));
		System.out.println("Area of Rectangle: "+ al.areaOfRectangle(7,5));

	}




}
