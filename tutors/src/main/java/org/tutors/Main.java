package org.tutors;
import utils.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        //test case
        MobilePhone phone = new MobilePhone("Samsung", "Galaxy S10", 'B', 2019, true);
        //person
        Person person = new Person(1, "John");
        //set phone
        person.setPhone(phone);

        //print person
        System.out.println(person);

    }
}