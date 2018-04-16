package org.foobarspam.furnaceDIP.hardware;

import org.foobarspam.furnaceDIP.interfaces.Heater;
import org.foobarspam.furnaceDIP.interfaces.Regulable;
import org.foobarspam.furnaceDIP.interfaces.Thermometer;
import org.foobarspam.furnaceDIP.types.RegulatorDisplayCodes;
import org.foobarspam.furnaceDIP.types.RoomTemperature;

public class Regulator implements Regulable {

	private double minTemp;
	private double maxTemp;

	public Regulator(double minTemp, double maxTemp) {
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public void regulate(Thermometer t, Heater h, RoomTemperature temperature) {
		RegulatorDisplayCodes code;
		while (t.read(temperature) < maxTemp) {
			code = RegulatorDisplayCodes.HEATING;
			h.engage(temperature);
			message(code, temperature);
		}
		while (t.read(temperature) > minTemp) {
			code = RegulatorDisplayCodes.WAITING;
			h.disengage(temperature);
			message(code, temperature);
		}
	}

	private void message(RegulatorDisplayCodes code, RoomTemperature temperature) {
		switch (code) {
		case HEATING:
			System.out.println("Calentando => temperatura " + temperature.getTemperature());
			break;
		case WAITING:
			System.out.println("Apagado => temperatura " + temperature.getTemperature());
			break;
		default:
			System.out.println("Algo raro sucede...");
			break;
		}
	}

	public double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

}
