package OOD1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numOfSpotType = {{3, 2}};
		ParkingLot newLot = new ParkingLot(1, numOfSpotType);
		Vehicle v1 = new Truck();
		boolean success1 = newLot.park(v1);
		System.out.println("Already parked a Truck? :" + success1);
		Vehicle v2 = new Truck();
		boolean success2 = newLot.park(v2);
		System.out.println("Already parked a Truck? :" + success2);
		Vehicle v3 = new Truck();
		boolean success3 = newLot.park(v3);
		System.out.println("Already parked a Truck? :" + success3);
		Vehicle v4 = new Car();
		boolean hasSpot = newLot.hasSpot(v4);
		System.out.println("Has spot for a car? :" + hasSpot);
		boolean unparkV2 = newLot.leave(v2);
		System.out.println("Successfully unpark V2 ? :" + unparkV2);
		boolean unparkV3 = newLot.leave(v2);
		System.out.println("Successfully unpark V3 ? :" + unparkV3);
	}
	


}
