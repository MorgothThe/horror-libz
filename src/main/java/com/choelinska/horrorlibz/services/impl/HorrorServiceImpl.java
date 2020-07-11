package com.choelinska.horrorlibz.services.impl;

import com.choelinska.horrorlibz.model.dto.HorrorTo;
import com.choelinska.horrorlibz.model.entities.HorrorEntity;
import com.choelinska.horrorlibz.repositories.HorrorRepository;
import com.choelinska.horrorlibz.services.HorrorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HorrorServiceImpl implements HorrorService {

	private HorrorRepository horrorRepository;
	private ModelMapper mapper;

	public HorrorServiceImpl(HorrorRepository horrorRepository, ModelMapper mapper){
		this.horrorRepository = horrorRepository;
		this.mapper = mapper;
	}

	@Override public void addHorror(HorrorTo horrorTo) {
		horrorRepository.save(this.convertToEntity(horrorTo));
	}

	@Override public void removeHorror(long id) {
		horrorRepository.deleteById(id);
	}

	private HorrorEntity convertToEntity(HorrorTo horrorTo){
		return this.mapper.map(horrorTo, HorrorEntity.class);
	}
}
