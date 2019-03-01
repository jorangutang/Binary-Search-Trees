public class Readings {
    String Datime;
    String GloAP;
    String Voltage;

    public Readings(String Datime, String GloAP, String Voltage ){
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
}
