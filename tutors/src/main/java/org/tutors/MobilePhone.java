package org.tutors;
import utils.*;

public class MobilePhone {

    @DomainConstraint(type = "String", mutable = false, optional = false, length = 100)
    private String manName;

    @DomainConstraint(type = "String", mutable = false, optional = false, length = 50)
    private String model;

    @DomainConstraint(type = "Character", mutable = false, optional = false, min = 1)
    private Character color;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1970)
    private int year;

    @DomainConstraint(type = "Double", mutable = true, optional = true)
    private boolean guaranteed;

    public MobilePhone(@AttrRef("manName") String manName, @AttrRef("model") String model, @AttrRef("color") Character color, @AttrRef("year") int year, @AttrRef("guaranteed") boolean guaranteed) {
        this.manName = manName;
        this.model = model;
        this.color = color;
        this.year = year;
        this.guaranteed = guaranteed;
    }

    @DOpt(type = OptType.Observer) @AttrRef("manName")
    public String getManName() {
        return manName;
    }

    @DOpt(type = OptType.Observer) @AttrRef("model")
    public String getModel() {
        return model;
    }

    @DOpt(type = OptType.Observer) @AttrRef("color")
    public Character getColor() {
        return color;
    }

    @DOpt(type = OptType.Observer) @AttrRef("year")
    public int getYear() {
        return year;
    }

    @DOpt(type = OptType.Observer) @AttrRef("guaranteed")
    public boolean isGuaranteed() {
        return guaranteed;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "manName='" + manName + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                ", year=" + year +
                ", guaranteed=" + guaranteed +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MobilePhone mobilePhone = (MobilePhone) obj;
        return manName.equals(mobilePhone.manName) &&
                model.equals(mobilePhone.model) &&
                color.equals(mobilePhone.color) &&
                year == mobilePhone.year;
    }
    public boolean validate() {
        return manName != null && model != null && color != null && year >= 1970;
    }
}
