import java.io.IOException;

public class testPowerArray {
    public static void main(String[] args) throws IOException {
        PowerArray test = new PowerArray();
        test.printDateTime("16/12/2006/21:12:00");
        test.InstrumentArray();
        test.getInstrumentation();

        test.printDateTime("16/12/2006/19:44:00");
        test.InstrumentArray();
        test.getInstrumentation();

        test.printDateTime("17/12/2006/00:09:00");
        test.InstrumentArray();
        test.getInstrumentation();

        test.printDateTime("123");
        test.InstrumentArray();
        test.getInstrumentation();

        test.printDateTime("");
        test.InstrumentArray();
        test.getInstrumentation();

        test.InstrumentationUpdate();
    }
}

