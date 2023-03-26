package org.tutors;
import utils.*;

import java.io.IOException;

public class Person {
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
    private int id;

    @DomainConstraint(type = "String", mutable = true, optional = true, length = 30)
    private String name;

    @DomainConstraint(type = "MobilePhone", mutable = true, optional = true)
    private MobilePhone phone;

    public Person(@AttrRef("id") int id, @AttrRef("name") String name) throws IOException {
        this.id = id;
        this.name = name;

    }
    @DOpt(type = OptType.Observer) @AttrRef("id")
    public int getId() {
        return id;
    }

    @DOpt(type = OptType.Observer) @AttrRef("name")
    public String getName() {
        return name;
    }

    @DOpt(type = OptType.Observer) @AttrRef("phone")
    public MobilePhone getPhone() {
        return phone;
    }

    @DOpt(type = OptType.Mutator) @AttrRef("name")
    public void setName(String name) {
        this.name = name;
    }

    @DOpt(type = OptType.Mutator) @AttrRef("phone")
    public void setPhone(MobilePhone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id;
    }

    public boolean repOK() {
        return validateid(id) && validatename(name) && validatephone(phone);
    }

    public boolean validateid(int id) {
        return true;
    }

    public boolean validatename(String name) {
        return name != null && name.length() <= 30;
    }

    public boolean validatephone(MobilePhone phone) {
        return phone != null;
    }
}