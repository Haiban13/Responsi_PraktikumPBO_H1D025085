public abstract class Device {
    private final String deviceId;
    private String name;
    private boolean On;

    public Device(String deviceId, String name){
        this.deviceId=deviceId;
        this.name=name;
        this.On=false;

    }

    public Device(String deviceId, String name, boolean on){
        this.deviceId=deviceId;
        this.name=name;
        this.On=on;
    }

    public String getDeviceId(){return this.deviceId; }


    public String getName(){return this.name;}

    public boolean isOn(){return this.On;}


    public void setName(String name){
        this.name=name;
    }


    public void setOn(boolean on){
        this.On=on;
    }

    public void display(){
        System.out.println("Device ID: "+this.deviceId);
        System.out.println("Nama Device: "+this.name);
        System.out.println("Status Aktif: "+this.On);

    }

    public abstract boolean command(String command);


}
