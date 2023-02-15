package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void CreatePersonWithoutName(){
        assertThrows(InvalidPropertiesFormatException.class, () -> new Person(null,0,"Male"));
    }
}