/**
* @author Jesse Smart
* @date 01/03/2019
 * This is the driver class for the PowerArray.
 * It can run in the terminal with the argument for a specific search or without on which returns all.
* */

public class PowerArrayApp {
    public static void main(String[] args) {
        PowerArray power = new PowerArray();
        if (args.length != 0){
            power.printDateTime(args[0]);
        }
        else{
            power.printAllDateTimes();
        }
    }
}


