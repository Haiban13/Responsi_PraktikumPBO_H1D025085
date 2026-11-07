public class Cctv extends  Device implements Controll, DeviceKeamanan{
    private int arahderajat;
    private boolean securityActive;

    public Cctv(String deviceId, String name) {
        super(deviceId, name);
        this.arahderajat = 50;
        this.securityActive = false;
    }


    public Cctv(String deviceId, String name, int arahderajat, boolean active) {
        super(deviceId, name, true);
        this.arahderajat = arahderajat;
        this.securityActive = active;
    }


    @Override
    public void turnon(){
        setOn(true);
        System.out.println(">> Sistem cctv '" + getName() + "' dinyalakan.");
    }



    @Override
    public void turnoff(){
        setOn(false);
        System.out.println(">> Sistem cctv '" + getName() + "' dimatikan.");
    }



    @Override
    public boolean isPoweredOn(){
        return isOn();
    }

    @Override
    public void AktifkanKeamanan() {
        if (isOn()) {
            this.securityActive = true;
            System.out.println(">> Mode Keamanan Deteksi Gerakan CCTV DIAKTIFKAN!");
        } else {
            System.out.println(">> Nyalakan CCTV terlebih dahulu sebelum mengaktifkan mode keamanan.");
        }
    }

    @Override
    public void MatikanKeamanan() {
        this.securityActive = false;
        System.out.println(">> Mode Keamanan CCTV DINONAKTIFKAN.");
    }

    @Override
    public boolean StatusKeamanan() { return this.securityActive; }

    @Override
    public void display() {
        super.display(); // 5. Super Chaining Method
        System.out.println("Sudut Lensa  : " + this.arahderajat + "°");
        System.out.println("Mode Keamanan: " + (this.securityActive ? "AKTIF (Motion Alarm ON)" : "NON-AKTIF"));
    }

    // 8. Logika State Percabangan
    @Override
    public boolean command(String command) {
        if (!isOn() && !command.equalsIgnoreCase("ON")) {
            System.out.println("Gagal! CCTV sedang mati. Nyalakan CCTV terlebih dahulu.");
            return false;
        }

        if (command.equalsIgnoreCase("ON")) {
            turnon();
            return true;
        } else if (command.equalsIgnoreCase("OFF")) {
            turnoff();
            return true;
        } else if (command.equalsIgnoreCase("PAN_LEFT")) {
            if (this.arahderajat >= 30) {
                this.arahderajat -= 30;
                System.out.println(">> Sudut CCTV digeser ke kiri. Lensa saat ini: " + this.arahderajat + "°");
            } else {
                System.out.println(">> Sudut CCTV sudah pada batas kiri minimum.");
            }
            return true;
        } else if (command.equalsIgnoreCase("PAN_RIGHT")) {
            if (this.arahderajat <= 150) {
                this.arahderajat += 30;
                System.out.println(">> Sudut CCTV digeser ke kanan. Lensa saat ini: " + this.arahderajat + "°");
            } else {
                System.out.println(">> Sudut CCTV sudah pada batas kanan maksimum.");
            }
            return true;
        } else if (command.equalsIgnoreCase("SECURITY_TOGGLE")) {
            if (this.securityActive) {
                MatikanKeamanan();
            } else {
                AktifkanKeamanan();
            }
            return true;
        } else {
            System.out.println("Perintah CCTV tidak valid!");
            return false;
        }
    }
}
