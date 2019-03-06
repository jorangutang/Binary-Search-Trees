import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is creates a Binary Tree from the file.csv , in order to search for the desired items or print in order.
 */
public class PowerBST {

    public ReadingsNode[] readingsNodelist;
    private int counter = 0;
    private ReadingsNode root;
    //public int instrumentation = 0; // for counting comparisons
    public int[] instrumentationBSTStore = new int[10];
    int count = 0;
    int frequency = 0;

    /**
     * @constructor 
     * initializes a PowerBST object and creates the binary tree.
     */
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

    /**
     * Adds the parameter to binary tree, if no tree exists, this will be the root Node.
     * @param temp of type ReadingsNode 
     */
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

    /**
     * This method will print all Readings in order of Date and time.
     * @param tempRoot Uses this Node as a reference to PrintAll in order.
     */
    public void inOrder( ReadingsNode tempRoot ){
        if (tempRoot != null){
            inOrder(tempRoot.getLeft ());
            System.out.println(tempRoot);
            inOrder(tempRoot.getRight ());
        }
    }

    /**
     * This method allows us to search for a desired Reading in the tree.
     * @param instring is the item we wish to find
     * @returns ReadingsNode we were looking for.
     */
    public ReadingsNode find(String instring){
        frequency = 0;
        if (root == null){
            return null;
        }
        else{
            return find (instring, root);
        }
    }

    /**
     * 
     * @param instring is the item we are looking for.
     * @param Reference 
     * @return
     */
    public ReadingsNode find(String instring, ReadingsNode Reference){
        if (instring.equals("")) return null;
        if (instring.compareTo(Reference.Datime) == 0){
            frequency++;
            return Reference;
        }
        else if (instring.compareTo(Reference.Datime) < 0){
            frequency++;
            return (Reference.getLeft() == null) ? null : find (instring, Reference.leftChild);
        }
        else{
            frequency++;
            return (Reference.getRight() == null) ? null : find (instring, Reference.rightChild);
        }
    }

    /**
     * Prints the found item.
     * @param input
     */
    public void printDateTimeBST(String input){
        System.out.println(find(input));
    }

    /**
     * Prints all items from the inOrder() method.
     */
    public void printAllDateTimesBST(){
        inOrder(root);
    }

    /**
     * This Array stores the instrumentation values before they are sent to an out file.
     */
    public void InstrumentBSTArray(){
        instrumentationBSTStore[count] = frequency;
        count++;
    }

    /**
     * Writes all instrumentations to InstrumentationBST.txt.
     * @throws IOException
     */
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

    /**
     * @return the instrumentation.
     */
    public int getInstrumentationBST(){
        return frequency;
    }
}	


