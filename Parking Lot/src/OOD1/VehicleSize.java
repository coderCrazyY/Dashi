package OOD1;

public enum VehicleSize {
	Compact (1), 
	Large (2);
	private final int rank;
	VehicleSize(int rank) {
		this.rank = rank;
	}

	int rank() {
		return rank;
	}
	
}
