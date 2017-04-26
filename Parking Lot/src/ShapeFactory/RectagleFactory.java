package ShapeFactory;

public class RectagleFactory implements ShapeFactory {

	@Override
	public Shape createShape() {
		// TODO Auto-generated method stub
		return new Rectangle(0, 0);
	}

}
