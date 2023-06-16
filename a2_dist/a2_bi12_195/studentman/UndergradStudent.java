package a2_bi12_195.studentman;
import utils.*;

/**
 * @overview
 * subclass of Student that represents an undergraduate student
 *
 * @object
 * A typical UndergradStudent is <pre>s=< i,n,p,a ></pre>, where
 * <pre>id(i), name(n), phoneNumber(p), address(a)</pre>
 *
 * @abstract_properties
 * MinID=100000 /\ MaxID=100000000 /\
 *
 * @author BI12-195 Le Tuan Huy
 */
public class UndergradStudent extends Student {
    //constants constraints
    public static final int MIN_ID = 100000;
    public static final int MAX_ID = 100000000;

    //constructor
    /**
     * @effects <pre>
     *     if id, name, phoneNumber, address are valid
     *         initialize this as UndergradStudent:<i, n, p, a>
     *     else
     *         throws NotPossibleException</pre>
     */
    @DOpt(type = OptType.Constructor)
    public UndergradStudent(@AttrRef("id") int id,
                            @AttrRef("name") String name,
                            @AttrRef("phoneNumber") String phoneNumber,
                            @AttrRef("address") String address) throws NotPossibleException
    {
        super(id, name, phoneNumber, address);
        if (!validateId(id)) {
            throw new NotPossibleException("UndergradStudent.init(): invalid id: " + id);
        }
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

    //repOK
    /**
     * @effects <pre>
     *     if this satisfies rep invariant
     *         return true
     *     else
     *         return false</pre>
     */
    @Override
    @DOpt(type = OptType.Helper)
    public boolean repOK() {
        return super.repOK() && validateId(getId());
    }

    //toString
    /**
     * @effects <pre>
     *     return a string representation of this</pre>
     */
    @Override
    @DOpt(type = OptType.Default)
    public String toString() {
        return String.format("UndergradStudent:<%d, %s, %s, %s>", getId(), getName(), getPhoneNumber(), getAddress());
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
                "<head><title>UndergradStudent:" + getId() + "-" + getName() + "</title></head>\n" +
                "<body>\n" +
                getId() + " " + getName() + " " + getPhoneNumber() + " " + getAddress() + "\n" +
                "</body></html>";
    }

}
