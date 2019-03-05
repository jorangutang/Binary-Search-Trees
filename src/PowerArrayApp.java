/**
* @author Jesse Smart
*
*
* */


import java.io.*;
import java.util.*;


public class PowerArrayApp {
    public static void main(String[] args) {
        PowerArray power = new PowerArray();

        if(args.length != 0) {
            power.printDateTime(args[0]);
        }
        else {
            power.printAllDateTimes();
        }
    }
}


