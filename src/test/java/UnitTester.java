import Dummy.TestDummy;
import org.junit.Test;

import java.util.Scanner;

import static Dummy.TestDummy.timeConversion;

public class UnitTester {
    @Test
    public void methodTester(){

        // Main Operation to fetch data
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);
    }
}
