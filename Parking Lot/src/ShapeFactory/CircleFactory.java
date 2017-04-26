package ShapeFactory;

public class CircleFactory implements ShapeFactory {

	@Override
	public Shape createShape() {
		// TODO Auto-generated method stub
		return new Circle(0);
	}

}
