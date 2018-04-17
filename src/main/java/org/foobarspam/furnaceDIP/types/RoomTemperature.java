package org.foobarspam.furnaceDIP.types;

public class RoomTemperature {

	private static double temperature = 0;
	private static RoomTemperature instance;

	private RoomTemperature() {
	}

	public static RoomTemperature getInstance() {
		if (instance == null) {
			instance = new RoomTemperature();
		}
		return instance;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double input) {
		temperature = input;
	}

	public static void incrementTemperature(double increment) {
		temperature += increment;
	}

}
