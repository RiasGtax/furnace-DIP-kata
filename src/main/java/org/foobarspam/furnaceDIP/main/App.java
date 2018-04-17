package org.foobarspam.furnaceDIP.main;

import org.foobarspam.furnaceDIP.hardware.GasHeater;
import org.foobarspam.furnaceDIP.hardware.Regulator;
import org.foobarspam.furnaceDIP.hardware.RemoteCommandSensor;
import org.foobarspam.furnaceDIP.interfaces.Heater;
import org.foobarspam.furnaceDIP.interfaces.Regulable;
import org.foobarspam.furnaceDIP.interfaces.Thermometer;
import org.foobarspam.furnaceDIP.otherstuff.Jedi;
import org.foobarspam.furnaceDIP.types.RoomTemperature;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final double minTemp = 15.0;
		final double maxTemp = 21.0;

		RoomTemperature temperature = new RoomTemperature(15);
		Heater heater = new GasHeater();
		Thermometer thermometer = new RemoteCommandSensor();

		Regulable regulator = new Regulator(minTemp, maxTemp);

		System.out.println("Arrancando...");
		regulator.regulate(thermometer, heater, temperature);

		Jedi yoda = new Jedi();
		System.out.println("\nArrancando a Yoda: ");
		regulator.regulate(thermometer, yoda, temperature);
		yoda.speak();
	}
}
