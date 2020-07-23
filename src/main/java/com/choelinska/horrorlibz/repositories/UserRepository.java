package com.choelinska.horrorlibz.repositories;

import com.choelinska.horrorlibz.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Override
    <S extends UserEntity> S save(S entity);

    @Override
    List<UserEntity> findAll();
}
