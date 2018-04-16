package org.foobarspam.furnaceDIP.interfaces;

import org.foobarspam.furnaceDIP.types.RoomTemperature;

public interface Regulable {
	public void regulate(Thermometer t, Heater h, RoomTemperature temperature);
}
