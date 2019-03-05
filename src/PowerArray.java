import java.io.*;
import java.io.BufferedReader;

/**
 * This class creates an Array of all the Readings from the file.csv
 * One can find items or print all.
 */
public class PowerArray {
    public Readings[] readingslist;
    private int counter = 0;
    public int instrumentation = 0; // for counting comparisons
    public int[] instrumentationStore = new int[10];
    int count = 0;


    /**
     * @Constructor
     * initializes new PowerArray object.
     */
    public PowerArray(){
    try {
        BufferedReader readin = new BufferedReader(new FileReader("cleaned_data.csv"));
        String line ;
        readingslist = new Readings[500];
        while ((line = readin.readLine()) != null){
            if (line.substring(0,1).equals("D")){
                continue;
            }
            String[] values = line.split(",");
            readingslist[counter] = new Readings(values[0], values[1], values[3]);
            counter++;
        }
    }

    catch (Exception e ) {
        e.printStackTrace();}
    }

    /**
     * Print specific entry
     * @param dateTime
     */
    public void printDateTime(String dateTime){
        instrumentation = 0;
        if (dateTime.equals("")){
            System.out.println("Empty Parameter");
            return;
        }
        for (Readings each : readingslist) {
             instrumentation++;
             if (each.getDatime().equals(dateTime)) {
                System.out.println(each.toString());
                break;
            }
        }
        if (instrumentation>499){
            System.out.println("item not found");
        }
    }

    /**
     * Prints all entries.
     */
    public void printAllDateTimes(){
        for (Readings one : readingslist) {
            System.out.println(one.toString());
        }
    }

    /**
     * Creates an array of all the search done on a PowerArray object.
     */
    public void InstrumentArray(){
        instrumentationStore[count] = instrumentation;
        count++;
    }

    /**
     * Writes the instrumentation to a file called Instrumentation.txt.
     * @throws IOException
     */
    public void InstrumentationUpdate() throws IOException {
        try (PrintWriter writer = new PrintWriter("Instrumentation.txt", "utf-8")) {
            int stop = 0;
            for (int temp : instrumentationStore) {
                if (temp > 499) {
                    writer.write("item not found\r\n");
                    stop++;
                } else {
                    writer.write(temp + "\r\n");
                    stop++;
                }
                if (stop == count) break;
            }
        }
    }

    /**
     * @return int Instrumentation
     */
    public int getInstrumentation() {
        return instrumentation;
    }
}
