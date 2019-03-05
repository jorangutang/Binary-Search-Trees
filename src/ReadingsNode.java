/**
 * This class is a binary search tree's node.
 * it Stores the Values from the Reading object that we want.
 */

public class ReadingsNode {
        String Datime;
        String GloAP;
        String Voltage;
        ReadingsNode leftChild;
        ReadingsNode rightChild;

    /**
     * @constructor Creates new Node.
     * @param Datime
     * @param GloAP
     * @param Voltage
     */
        public ReadingsNode(String Datime, String GloAP, String Voltage ){
            this.Datime = Datime;
            this.GloAP = GloAP;
            this.Voltage = Voltage;

        }

    /**
     *
     * @return
     */
    public String toString(){
            return "Date/Time: " + Datime + ", " + "Global_active_power: " + GloAP + ", " + "Voltage: " + Voltage;
        }

        public String getDatime() {
            return Datime;
        }

        public String getGloAP() {
            return GloAP;
        }

        public String getVoltage() {
            return Voltage;
        }

        public ReadingsNode getLeft() {
            return leftChild;
        }

        public ReadingsNode getRight() {
            return rightChild;
        }
}



