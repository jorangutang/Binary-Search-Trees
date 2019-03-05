import java.io.IOException;

public class testPowerBST {
    public static void main(String[] args) throws IOException {
        PowerBST test = new PowerBST();
        test.printDateTimeBST("16/12/2006/21:12:00");
        test.InstrumentBSTArray();

        test.printDateTimeBST("16/12/2006/19:44:00");
        test.InstrumentBSTArray();

        test.printDateTimeBST("17/12/2006/00:09:00");
        test.InstrumentBSTArray();

        test.printDateTimeBST("123");
        test.InstrumentBSTArray();

        test.printDateTimeBST("");
        test.InstrumentBSTArray();

        test.InstrumentationBSTUpdate();
    }
}

