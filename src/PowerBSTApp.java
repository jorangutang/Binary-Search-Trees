import java.io.*;
import java.util.*;

public class PowerBSTApp{
    public static void main(String[] args){
        PowerBST powerbst = new PowerBST();

        if(args.length != 0)
        {
            if (powerbst.find(args[0]) == null){
                System.out.println(args[0] + "  could not be found.");
            }
            else{
                System.out.println(powerbst.find(args[0]));
                System.out.println("Number of comparison operations performed: " + powerbst.getInstrumentationBST());
            }
        }
        else{
            powerbst.printAllDateTimes();
        }
    }
}


    
