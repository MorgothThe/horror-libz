package com.choelinska.horrorlibz.services;

import com.choelinska.horrorlibz.model.dto.HorrorTo;
import com.choelinska.horrorlibz.model.entities.HorrorEntity;

public interface HorrorService {

	void addHorror(HorrorTo horrorTo);

	void removeHorror(long id);

}
