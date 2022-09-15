package com.example.someproject.repository;

import com.example.someproject.entity.PersonEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonEntityRepository extends CrudRepository<PersonEntity, Long> {
    @Override
    List<PersonEntity> findAll();

    @Query("UPDATE PersonEntity p SET p.password = ?1 WHERE p.id = ?2")
    @Modifying
    void updateById(String password, Long id);
}