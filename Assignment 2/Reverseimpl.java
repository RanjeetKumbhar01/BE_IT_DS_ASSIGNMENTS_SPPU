import ReverseModule.ReversePOA;
import java.lang.String;

class Reverseimpl extends ReversePOA {
    Reverseimpl() {
        super();
        System.out.println("Reverse Object Created");
    }

    public String reverse_string(String name) {
        StringBuffer str = new StringBuffer(name);
        str.reverse();
        return (("Server send: " + str));
    }
}
