package a1_bi12_195;
import java.io.IOException;
import utils.*;

public class Student {
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 1000000000)
    private int id;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
    private String name;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
    private String phoneNumber;

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
    private String address;

    public Student(@AttrRef("id") int id,
                   @AttrRef("name") String name,
                   @AttrRef("phoneNumber") String phoneNumber,
                   @AttrRef("address") String address) throws IOException
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @DOpt(type = OptType.Observer) @AttrRef("id")
    public int getId() {
        return id;
    }

    @DOpt(type = OptType.Observer) @AttrRef("name")
    public String getName() {
        return name;
    }

    @DOpt(type = OptType.Observer) @AttrRef("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @DOpt(type = OptType.Observer) @AttrRef("address")
    public String getAddress() {
        return address;
    }

    @DOpt(type = OptType.Mutator) @AttrRef("name")
    public void setName(String name) {
        this.name = name;
    }

    @DOpt(type = OptType.Mutator) @AttrRef("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @DOpt(type = OptType.Mutator) @AttrRef("address")
    public void setAddress(String address) {
        this.address = address;
    }


    //validation
    public static boolean validateId(int id) throws IOException {
        if (id < 1 || id > 1000000000) {
            throw new IOException("Invalid ID: " + id);
        }
        return true;
    }

    public static boolean validateName(String name) throws IOException {
        if (name == null || name.length() > 50) {
            throw new IOException("Invalid name: " + name);
        }
        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) throws IOException {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IOException("Invalid phone number: " + phoneNumber);
        }
        return true;
    }

    public static boolean validateAddress(String address) throws IOException {
        if (address == null || address.length() > 100) {
            throw new IOException("Invalid address: " + address);
        }
        return true;
    }

    public boolean repOK() throws IOException {
        try {
            validateId(id);
            validateName(name);
            validatePhoneNumber(phoneNumber);
            validateAddress(address);
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
