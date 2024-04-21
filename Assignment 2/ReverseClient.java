import ReverseModule.*;
import org.omg.CosNaming.*;
//import org.omg.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class ReverseClient {
    public static void main(String[] args) {
        Reverse Reverseimpl = null;
        try {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "Reverse";
            Reverseimpl = ReverseHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Enter String: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            String tempStr = Reverseimpl.reverse_string(str);

            System.out.println(tempStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
