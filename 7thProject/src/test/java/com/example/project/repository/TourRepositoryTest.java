package com.example.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TourRepositoryTest {
    @Autowired
    private TourRepository underTest;

    @Test
    void itShouldFindByName() {
    //given

        //when

        //then
    }
}