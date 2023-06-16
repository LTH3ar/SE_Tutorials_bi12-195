package a2_bi12_195.studentman;
import utils.*;

/**
 * @overview
 * Subclass of Student that represents a postgraduate student.
 *
 * @attributes
 * gpa float
 *
 * @object
 * A typical PostgradStudent is <pre>s=< i,n,p,a,g ></pre>, where
 * <pre>id(i), name(n), phoneNumber(p), address(a), gpa(g)</pre>
 *
 * @abstract_properties
 * MinID=100000001 /\ MaxID=1000000000 /\
 * mutable(gpa)=true /\ optional(gpa)=false /\ min(gpa)=0.0 /\ max(gpa)=4.0
 *
 * @author BI12-195 Le Tuan Huy
 */
public class PostgradStudent extends Student {

    //constants constraints
    public static final int MIN_ID = 100000001;
    public static final int MAX_ID = 1000000000;
    public static final float MIN_GPA = 0.0F;
    public static final float MAX_GPA = 4.0F;

    //attributes
    @DomainConstraint(type = "float", mutable = true, optional = false, min = 0.0, max = 4.0)
    private float gpa;

    //constructor
    /**
     * @effects <pre>
     *     if id, name, phoneNumber, address, gpa are valid
     *         initialize this as PostgradStudent:<i, n, p, a, g>
     *     else
     *         throws NotPossibleException</pre>
     */
    @DOpt(type = OptType.Constructor)
    public PostgradStudent(@AttrRef("id") int id,
                           @AttrRef("name") String name,
                           @AttrRef("phoneNumber") String phoneNumber,
                           @AttrRef("address") String address,
                           @AttrRef("gpa") float gpa) throws NotPossibleException
    {
        super(id, name, phoneNumber, address);
        if (!validateId(id)) {
            throw new NotPossibleException("PostgradStudent.init(): invalid id: " + id);
        }
        if (!validateGpa(gpa)) {
            throw new NotPossibleException("PostgradStudent.init(): invalid gpa: " + gpa);
        }
        this.gpa = gpa;
    }

    //validate id
    /**
     * @effects <pre>
     *     if id is valid
     *         return true
     *     else
     *         return false</pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("id")
    private boolean validateId(int id) {
        return id >= MIN_ID && id <= MAX_ID;
    }

    //setters

    //set gpa
    /**
     * @effects <pre>
     *     if gpa is valid
     *         set this.gpa = gpa
     *         return true
     *     else
     *         return false</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("gpa")
    public boolean setGpa(float gpa) {
        if (validateGpa(gpa)) {
            this.gpa = gpa;
            return true;
        }
        else {
            return false;
        }
    }

    //getters

    //get gpa
    /**
     * @effects return this.gpa
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("gpa")
    public float getGpa() {
        return gpa;
    }

    //Validate
    //validate gpa
    /**
     * @effects <pre>
     *     if gpa is valid
     *         return true
     *     else
     *         return false</pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("gpa")
    private boolean validateGpa(float gpa) {
        return gpa >= MIN_GPA && gpa <= MAX_GPA;
    }

    //repOK
    /**
     * @effects return true if this satisfies the abstract properties
     *          else return false
     */
    @Override
    @DOpt(type = OptType.Helper)
    public boolean repOK() {
        return super.repOK() && validateId(getId()) && validateGpa(getGpa());
    }

    //toString
    /**
     * @effects return a string representation of the object
     */
    @Override
    @DOpt(type = OptType.Default)
    public String toString() {
        return String.format("PostgradStudent:<%d, %s, %s, %s, %.1f>", getId(), getName(), getPhoneNumber(), getAddress(), getGpa());
    }

    //toHtmlDoc
    /**
     * @effects <pre>
     *     return html document of this</pre>
     */
    @Override
    @DOpt(type = OptType.Default)
    public String toHtmlDoc() {
        return "<html>\n" +
                "<head><title>PostgradStudent:" + getId() + "-" + getName() + "</title></head>\n" +
                "<body>\n" +
                getId() + " " + getName() + " " + getPhoneNumber() + " " + getAddress() + " " + getGpa() + "\n" +
                "</body></html>";
    }
}
