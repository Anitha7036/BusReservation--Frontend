package com.busreservation.service;
import java.util.List;

import com.busreservation.entity.registerentity;



public interface registerservice {
	registerentity createUser(registerentity user);

	registerentity updateUser(registerentity user);

    List < registerentity > getAllUser();

    registerentity getUserById(long userId);

    void deleteUser(long id);
    

}
