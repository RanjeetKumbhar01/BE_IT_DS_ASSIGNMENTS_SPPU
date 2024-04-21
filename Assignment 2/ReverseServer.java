import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import ReverseModule.Reverse;

class ReverseServer {
    public static void main(String[] args) {

        try {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            Reverseimpl rvr = new Reverseimpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);
            System.out.println("Step 1");
            Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);
            System.out.println("Step 2");
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            System.out.println("Step 3");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            System.out.println("Step 4");
            String name = "Reverse";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, h_ref);
            System.out.println("Reverse Server Reading and Waiting...");
            orb.run();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
