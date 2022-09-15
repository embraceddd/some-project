package com.example.someproject.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.sql.Timestamp;
import java.util.Date;

@Builder
@Value
@FieldNameConstants
public class PersonDto {
    Long id;
    String firstname;
    String lastname;
    String patronymic;
    Date birthdate;
    Timestamp createdAt;
}
