package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3, p4;
    List<Person> persons;

    @BeforeEach
    void SetUp() throws InvalidPropertiesFormatException {
        p1 = new Person("Alba", 21, "Female");
        p2 = new Person("Maria", 100, "Female");
        p3 = new Person("Pepe", 3, "Male");
        p4 = new Person("Jose", 15, "Male");
        persons = new ArrayList<Person>();

    }

    @AfterEach
    void Close(){
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;

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

    @Test
    void averageAgePerGenderEmptyList(){
        double expectedValue = 0;
        double obtainedValueMale = p1.averageAgePerGender(persons)[0];
        double obtainedValueFemale = p1.averageAgePerGender(persons)[1];
        assertEquals(expectedValue, obtainedValueMale);
        assertEquals(expectedValue, obtainedValueFemale);
    }

    @Test
    void averageAgePerGenderTest(){
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        double expectedValueMale = 9;
        double expectedValueFemale = 60.5;
        double[] res = Person.averageAgePerGender(persons);
        double obtainedValueMale = res[0];
        double obtainedValueFemale = res[1];
        assertEquals(expectedValueMale, obtainedValueMale);
        assertEquals(expectedValueFemale, obtainedValueFemale);
    }

}