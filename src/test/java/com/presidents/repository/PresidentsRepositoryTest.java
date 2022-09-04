package com.presidents.repository;

import com.presidents.model.entity.President;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PresidentsRepositoryTest {

    @Autowired
    PresidentsRepository presidentsRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void shouldFindAllPresidents_when_searchForAll(){
        testEntityManager.persist(President.builder()
                .name("Prezydentttt").surname("Prezydenckiiiii").party("zzzzz").build());

        //when
       var presidents= presidentsRepository.findAll();
       //then
        Assertions.assertEquals(1,presidents.size());
    }

    @Test
    void shouldFindPresidentsByName_when_nameIsProvidedCorrectly() {
        testEntityManager.persist(President.builder()
                .name("Prezydentttt").surname("Prezydenckiiiii").party("zzzzz").build());

        //when
        var presidents= presidentsRepository.findPresidentsByName("Prezydentttt");
        //then
        Assertions.assertEquals(1,presidents.size());
    }
}
