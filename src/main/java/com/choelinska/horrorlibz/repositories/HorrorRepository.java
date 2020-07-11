package com.choelinska.horrorlibz.repositories;

import com.choelinska.horrorlibz.model.entities.HorrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorrorRepository extends JpaRepository<HorrorEntity, Long> {

	@Override <S extends HorrorEntity> S save(S s);

	@Override void deleteById(Long aLong);
}
