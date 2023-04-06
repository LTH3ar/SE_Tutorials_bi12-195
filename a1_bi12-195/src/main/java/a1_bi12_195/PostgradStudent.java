package a1_bi12_195;
import utils.*;
import java.io.IOException;

public class PostgradStudent extends Student {

    @DomainConstraint(type = "Float", mutable = true, optional = false, min = 0.0, max = 4.0)
    private float gpa;

    @DOpt(type = OptType.Constructor)
    public PostgradStudent(@AttrRef("id") int id,
    						@AttrRef("name")  String name,
    						@AttrRef("phoneNumber")  String phoneNumber,
    						@AttrRef("address") String address,
    						@AttrRef("gpa")float gpa) throws IOException {
        super(id, name, phoneNumber, address);
        this.gpa = gpa;
    }

    @DOpt(type = OptType.Observer) @AttrRef("gpa")
    public float getGpa() {
        return gpa;
    }

    @DOpt(type = OptType.Mutator) @AttrRef("gpa")
    public void setGpa(float gpa) throws IOException {
        if (validateGpa(gpa)) {
            this.gpa = gpa;
        }
    }

    @DOpt(type = OptType.Helper)
    public boolean repOK() throws IOException {
        return super.repOK() && validateGpa(gpa);
    }

    //validation
    @DOpt(type = OptType.Helper)
    public static boolean validateGpa(float gpa) throws IOException {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IOException("Invalid GPA: " + gpa);
        }
        return true;
    }

}
