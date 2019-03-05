/**
 * @author Jesse Smart
 * @date 01/03/2019
 * This is the driver class for the PowerBST.
 * It can run in the terminal with the argument for a specific search or without on which returns all.
 */
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


    
