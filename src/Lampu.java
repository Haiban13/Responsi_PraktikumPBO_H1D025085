public class Lampu extends Device implements Controll {
    private int brightness;
    private String color;

    public Lampu(String deviceId, String name) {
        super(deviceId, name);
        this.brightness = 50;
        this.color = "Warm White";
    }


    public Lampu(String deviceId, String name, int brightness, String color) {
        super(deviceId, name, true);
        this.brightness = brightness;
        this.color = color;
    }

    public int getBrightness(){return this.brightness; }


    public String getColor(){return this.color;}

    public void setBrightness(int brightness){
        this.brightness=brightness;
    }

    public void setColor(String color){
        this.color=color;
    }

    @Override
    public void turnon(){
            setOn(true);
        System.out.println(">> Sistem Lampu '" + getName() + "' nyalakan.");
    }



    @Override
    public void turnoff(){
        setOn(false);
        System.out.println(">> Sistem Lampu '" + getName() + "' dimatikan.");
    }



    @Override
    public boolean isPoweredOn(){
        return isOn();
    }



    @Override
    public void display(){
        super.display();
        System.out.println("brightness: "+this.brightness);
        System.out.println("color: "+this.color);
    }


    @Override
    public boolean command(String command) {
        if (!isOn() && !command.equalsIgnoreCase("ON")) {
            System.out.println("Gagal! " + getName() + " sedang mati. Nyalakan terlebih dahulu.");
            return false;
        }

        if (command.equalsIgnoreCase("ON")) {
            turnon();
            return true;
        } else if (command.equalsIgnoreCase("OFF")) {
            turnoff();
            return true;
        } else if (command.equalsIgnoreCase("BRIGHTER")) {
            if (this.brightness <= 80) {
                this.brightness += 20;
                System.out.println(">> Kecerahan dinaikkan menjadi: " + this.brightness + "%");
            } else {
                this.brightness = 100;
                System.out.println(">> Kecerahan sudah maksimal (100%).");
            }
            return true;
        } else if (command.equalsIgnoreCase("DIMMER")) {
            if (this.brightness >= 20) {
                this.brightness -= 20;
                System.out.println(">> Kecerahan diturunkan menjadi: " + this.brightness + "%");
            } else {
                this.brightness = 0;
                System.out.println(">> Kecerahan minimal (0%).");
            }
            return true;
        } else {
            System.out.println("Perintah lampu tidak dikenal!");
            return false;
        }
    }

}
