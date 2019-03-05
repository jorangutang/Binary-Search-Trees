import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PowerBST {

    public ReadingsNode[] readingsNodelist;
    private int counter = 0;
    private ReadingsNode root;
    //public int instrumentation = 0; // for counting comparisons
    public int[] instrumentationBSTStore = new int[10];
    int count = 0;
    int frequency = 0;


    public PowerBST() {
        try {
            BufferedReader readin = new BufferedReader(new FileReader("cleaned_data.csv"));
            String line ;
            readingsNodelist = new ReadingsNode[500];
            while ((line = readin.readLine()) != null){
                if (line.substring(0,1).equals("D")){
                    continue;
                }
                String[] values = line.split(",");
                readingsNodelist[counter] = new ReadingsNode(values[0], values[1], values[3]);
                counter++;
            }
        }

        catch (Exception e ) {
            e.printStackTrace();}
            for (ReadingsNode attach : readingsNodelist){
                addNode(attach);
            }
    }
    public void addNode(ReadingsNode temp){
        ReadingsNode newNode = new ReadingsNode(temp.Datime, temp.GloAP, temp.Voltage);

        if(root == null)
        {
            root = newNode;
        }
        else
        {
            ReadingsNode tempRoot = root;
            ReadingsNode parent;
            while(true)
            {
                parent = tempRoot;
                if((tempRoot.Datime).compareTo(temp.Datime) > 0)
                {
                    tempRoot = tempRoot.leftChild;
                    if(tempRoot == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    tempRoot = tempRoot.rightChild;
                    if(tempRoot == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
   // public void inOrder() { inOrder(root); }
    public void inOrder( ReadingsNode tempRoot )
    {
        if (tempRoot != null)
        {
            inOrder(tempRoot.getLeft ());
            System.out.println(tempRoot);
            inOrder(tempRoot.getRight ());
        }
    }


    public ReadingsNode find(String instring){
        frequency = 0;
        if (root == null){
            return null;
        }
        else{
            return find (instring, root);
        }
    }

    public ReadingsNode find(String instring, ReadingsNode focus){
        if (instring.equals("")) return null;
        if (instring.compareTo(focus.Datime) == 0){
            frequency++;
            return focus;
        }
        else if (instring.compareTo(focus.Datime) < 0){
            frequency++;
            return (focus.getLeft() == null) ? null : find (instring, focus.leftChild);
        }
        else{
            frequency++;
            return (focus.getRight() == null) ? null : find (instring, focus.rightChild);
        }
    }

    public void printDateTimeBST(String input){
        System.out.println(find(input));
    }

    public void printAllDateTimes(){
        inOrder(root);
    }

    public void InstrumentBSTArray(){
        instrumentationBSTStore[count] = frequency;
        count++;
    }

    public void InstrumentationBSTUpdate() throws IOException {
        try (PrintWriter writer = new PrintWriter("InstrumentationBST.txt", "utf-8")) {
            int stop = 0;
            for (int temp : instrumentationBSTStore) {
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

    public int getInstrumentationBST()
    {
        return frequency;
    }
}	


