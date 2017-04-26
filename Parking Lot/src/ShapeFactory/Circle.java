package ShapeFactory;

public class Circle implements Shape {
	private double radius; 
	Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method. radius is " + radius + ".");

	}

}
