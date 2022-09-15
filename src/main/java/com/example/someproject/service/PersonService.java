package com.example.someproject.service;

import com.example.someproject.entity.PersonEntity;
import com.example.someproject.model.PersonDto;
import com.example.someproject.repository.PersonEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonEntityRepository personEntityRepository;

    @Transactional
    public List<PersonDto> getAllPersons() {
        List<PersonEntity> allPersons = personEntityRepository.findAll();
        return allPersons.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PersonEntity createPerson(PersonEntity personEntity) {
        personEntityRepository.save(personEntity);
        return personEntity;
    }

    @Transactional
    public String deletePerson(Long id) {
        try {
            personEntityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "not existing person";
        }
        return id.toString();
    }

    @Transactional
    public String updatePerson(PersonEntity personEntity) {
        try {
            personEntityRepository.updateById(personEntity.getPassword(), personEntity.getId());
        } catch (EmptyResultDataAccessException e) {
            return "not existing person";
        }
        return personEntity.getPassword();
    }

    private PersonDto entityToDto(PersonEntity personEntity) {
        return PersonDto.builder()
                .id(personEntity.getId())
                .birthdate(personEntity.getBirthdate())
                .createdAt(personEntity.getCreatedAt())
                .firstname(personEntity.getFirstname())
                .lastname(personEntity.getLastname())
                .patronymic(personEntity.getPatronymic())
                .build();
    }
}
