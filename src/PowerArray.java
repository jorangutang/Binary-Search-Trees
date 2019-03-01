import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;


public class PowerArray {
    public Readings[] readingslist;
    private int counter = 0;


    public PowerArray() {
    try {BufferedReader readin = new BufferedReader(new FileReader("src/cleaned_data.csv"));{
        String line ;
        readingslist = new Readings[550];
    while ((line = readin.readLine()) != null){
        if (line.substring(0,1).equals("D")){
            continue;}
        String[] values = line.split(",");
        readingslist[counter] = new Readings(values[0], values[1], values[3]);
        counter++;
    }}}

    catch (FileNotFoundException e) {
        e.printStackTrace();}
    catch (IOException e) {
        e.printStackTrace();}
    }
    public void printDateTime(String dateTime){
         for (Readings each : readingslist) {
            if (each.getDatime().equals(dateTime)) {
                System.out.println(each.toString());
                break;
            }
        }
        }
    public void printAllDateTimes(){
        for (Readings one : readingslist) {
            System.out.println(one.toString());
        }
    }
}
