package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person persona;

    @BeforeEach
    void SetUp() throws InvalidPropertiesFormatException {
        persona = new Person("Alba", 21, "Female");
    }

    @AfterEach
    void Close(){
        persona = null;
    }

    @Test
    void CreatePersonWithoutName(){
        assertThrows(InvalidPropertiesFormatException.class, () -> new Person(null,0,"Male"));
    }

    @Test
    void CreatePersonWithWrongAge(){
        assertThrows(InvalidPropertiesFormatException.class, () -> new Person("Alba",-5,"Female"));
    }


    @Test
    void CreatePersonWithWrongGender(){
        assertThrows(InvalidPropertiesFormatException.class, () -> new Person("Lucas",12,"Duck"));
    }

    @Test
    void CreatePersonWithoutGender(){
        assertThrows(InvalidPropertiesFormatException.class, () -> new Person(null,0,null));
    }



}