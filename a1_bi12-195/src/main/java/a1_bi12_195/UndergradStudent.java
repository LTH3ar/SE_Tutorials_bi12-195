package a1_bi12_195;
import java.io.IOException;
import utils.*;

public class UndergradStudent extends Student {

    @DOpt(type = OptType.Constructor)
    public UndergradStudent(@AttrRef("id") int id,
                            @AttrRef("name") String name,
                            @AttrRef("phoneNumber") String phoneNumber,
                            @AttrRef("address") String address)
            throws IOException {
        super(id, name, phoneNumber, address);
    }

}
