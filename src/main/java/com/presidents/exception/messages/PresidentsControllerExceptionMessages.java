package com.presidents.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PresidentsControllerExceptionMessages {

    ENTITY_FOR_PROVIDED_ID_NOT_EXIST("Encja dla danego id nie istnieje"),
    ENTITY_FOR_PROVIDED_PARAMETER_NOT_EXIST("Encja dla podanego parametru nie istnieje");


    private final String message;

//    NO_PRESIDENT_FOUND_BY_PROVIDED_NAME("Nie znaleziono prezydenta o podanym imieniu");



}
