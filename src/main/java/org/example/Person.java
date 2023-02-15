package org.example;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Alba Ruiz Gutiérrez
 */
public class Person {

    private final String name;
    private final int age;
    private String gender; //Male, Female

    /**
     * Construct a person with a name, age and gender
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */
    public Person(String name, int age, String gender) throws InvalidPropertiesFormatException {
        if(name == null){
            throw new InvalidPropertiesFormatException("Name can not be null");
        }else{
            this.name = name;
        }

        if(age < 0 || age > 120){
            throw new InvalidPropertiesFormatException("Invalid parameter for age");
        }else{
            this.age = age;
        }


        if(gender != "Male" || gender != "Female"){
            throw new InvalidPropertiesFormatException("Gender can only be Male of Female");
        }else{
            this.gender = gender;
        }
    }

    public String name(){return name;}

    public int age(){return age;}

    public String gender(){
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons){

        double[] res = new double[2];

        double maleMeanAge = 0;
        double femaleMeanAge = 0;
        int countMale = 0;
        int countFemale = 0;

        for (Person p:persons ) {
            if(p.gender.equalsIgnoreCase("Male")){
                maleMeanAge += p.age;
                countMale++;
            }else if(p.gender.equalsIgnoreCase("Female")){
                femaleMeanAge += p.age;
                countFemale++;
            }
        }
        res[0] = (maleMeanAge/countMale);
        res[1] = (femaleMeanAge/countFemale);

        return res;
    }

}
