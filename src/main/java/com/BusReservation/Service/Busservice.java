package com.busreservation.service;

import java.util.List;
import com.busreservation.entity.Busentity;

public interface Busservice {
	Busentity createBus(Busentity bus);

	Busentity updateBus(Busentity bus);

    List < Busentity > getAllBus();

    Busentity getBusById(long BusId);

    void deleteBus(long id);
}
