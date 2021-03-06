package ShapeFactory;

public class main {
	public static void main(String[] args) throws Exception {
		ShapeFactory factory = null;
		String giveShape = "triangle";
		if (giveShape.equalsIgnoreCase("circle")) {
			factory = new CircleFactory();
		} else if (giveShape.equalsIgnoreCase("rectangle")) {
			factory = new RectagleFactory();
		} else {
			throw new Exception ("No such shape");
		}
		
		Shape shape = factory.createShape();
		shape.draw();
		
	}
}
