package OOD1;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
// Basic Functionality: for a given vehicle, tell if there is available slot.
// Possible Extensions: give the spot location, assign spot to vehicle...
	private Level[] levels;
	// constructor
	public ParkingLot(int numOfLevels, int[][] numOfSpots) {
		levels = new Level[numOfLevels];
		for (int i = 0; i < numOfLevels; i++) {
			levels[i] = new Level(numOfSpots[i][0], numOfSpots[i][1]);
		}
	}
	// given a vehicle, tell me whether I can park
	public boolean hasSpot(Vehicle v) {
		//for each level, check Level.hasSpot
		for (Level l : levels) {
			if (l.hasSpot(v)) {
				return true;
			}
		}
		return false;
	}
	// boolean park
	public boolean park(Vehicle v) {
		for (Level l : levels) {
			if(l.park(v)) {
				return true;
			}
		}
		return false;
	}
	// boolean leave: given a car leaving from the parking lot
	public boolean leave (Vehicle v) {
		for (Level l : levels) {
			if(l.leave(v)) {
				return true;
			}
		}
		return false;
	}
	// Sub Class lEVEL
	class Level{
		private final List<ParkingSpot> spots;
		// constructor
		Level(int numOfCompact, int numOfLarge) {
			spots = new ArrayList<ParkingSpot>(numOfCompact + numOfLarge);
			for (int i = 0; i < numOfCompact; i++) {
				ParkingSpot newSpot = new ParkingSpot(VehicleSize.Compact);
				spots.add(newSpot);
			}
			for (int i = 0; i < numOfLarge; i++) {
				ParkingSpot newSpot = new ParkingSpot(VehicleSize.Large);
				spots.add(newSpot);
			}
		}
		// method1: boolean hasSpot(Vehicle)
		boolean hasSpot(Vehicle v) {
			for (ParkingSpot s: spots) {
				if (s.fit(v)) {
					return true;
				}
			}
			return false;
		}
		// method2: boolean park(v)
		boolean park(Vehicle v) {
			for (ParkingSpot s: spots) {
				if (s.fit(v)) {
					s.park(v);
					return true;
				}
			}
			return false;
		}
		// method3: leave(v)
		// if the given vehicle is in the current level, unpark it and return true; 
		// otherwise return false
		boolean leave(Vehicle v) {
			for (ParkingSpot s : spots) {
				if(s.currentVehicle == v) {
					s.leave(v);
					return true;
				}
			}
			return false;
		}
		
	}
	
	// Sub Class Level
	class ParkingSpot{
		// boolean fit(Vehicle): check availability and size
		private final VehicleSize size;
		private Vehicle currentVehicle;
		// constructor
		ParkingSpot(VehicleSize size) {
			this.size = size;
		}
		// method 1: check if one given vehicle can fit in the specific spot
		boolean fit(Vehicle v) {
			if (currentVehicle == null) {
				return v.getSize().rank() <= size.rank();
			}
			return false;
		}
		// method 2: if one vehicle parked in this spot
		// update the currentVehicle field
		void park(Vehicle v) {
			currentVehicle = v;
		}
		// method 3: if one vehicle leave this spot
		// update the currentVihecle field to null
		void leave(Vehicle v) {
			currentVehicle = null;
		}
		// method 4: check which vehicle is currently parked in this spot
		Vehicle getVehicle() {
			return currentVehicle;
		}
	}
}
