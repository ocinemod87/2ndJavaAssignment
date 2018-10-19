import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
     /*   AccessControl access = new AccessControl();
        access.enter("13");
        System.out.println("First User");
        access.enter("13");
        System.out.println("sECOND User");
        access.exit("43");
        access.canAccess("12", 1);
        access.grantAccess("12", 1);
        access.canAccess("12", 1);
        access.grantAccess("13", 1);
        access.canAccess("13",1);*/
        AccessControl access;
        Iterable<String> users;
        Random rnd;
        access = new AccessControl();
        rnd = new Random(3);
        for (int i = 0 ; i < 100 ; i++) {
            String randomUser = "User" + rnd.nextInt(10);
            access.enter(randomUser);
            randomUser = "User" + rnd.nextInt(10);
            access.exit(randomUser);
            randomUser = "User" + rnd.nextInt(10);
            access.grantAccess(randomUser, rnd.nextInt(4));
            randomUser = "User" + rnd.nextInt(10);
            access.revokeAccess(randomUser, rnd.nextInt(4));
            randomUser = "User" + rnd.nextInt(10);
            int area = rnd.nextInt(4);
            System.out.println("Calling canAccess with " + randomUser + " and area " + area + " returns " + access.canAccess(randomUser, area));
        }
        System.out.println();
    }
}
