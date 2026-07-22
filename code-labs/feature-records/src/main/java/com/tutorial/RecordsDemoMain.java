package com.tutorial;

public class RecordsDemoMain {

    public static void featuresRecordDemo(){
        Person person = new Person("Ada Lovelace", 36);

        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        String renderedPerson = person.toString();
        System.out.println("Automatic toString(): " + renderedPerson);
        System.out.println("toString() includes the fields: "
                + renderedPerson.equals("Person[name=Ada Lovelace, age=36]"));
    }

    public static void main(String[] args) {
        featuresRecordDemo();
    }
}
