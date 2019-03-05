public class ReadingsNode {
        String Datime;
        String GloAP;
        String Voltage;
        ReadingsNode leftChild;
        ReadingsNode rightChild;


        public ReadingsNode(String Datime, String GloAP, String Voltage ){
            this.Datime = Datime;
            this.GloAP = GloAP;
            this.Voltage = Voltage;

        }
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



