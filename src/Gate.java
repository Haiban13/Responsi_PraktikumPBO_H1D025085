public class Gate extends Device implements  Controll {

    private boolean islock;
    private boolean isopen;

    public Gate(String deviceId, String name) {
        super(deviceId, name);
        this.islock = true;
        this.isopen = false;
    }


    public Gate(String deviceId, String name, boolean isopen, boolean islock) {
        super(deviceId, name, true);
        this.islock = islock;
        this.isopen = isopen;
    }


    public boolean isopen() { return this.isopen; }
    public boolean islock() { return this.islock; }

    @Override
    public void turnon() {
        setOn(true);
        System.out.println(">> Sistem Pagar '" + getName() + "' diaktifkan.");
    }

    @Override
    public void turnoff() {
        setOn(false);
        System.out.println(">> Sistem Pagar '" + getName() + "' dimatikan.");
    }

    @Override
    public boolean isPoweredOn() {
        return isOn();
    }

    @Override
    public void display() {
        super.display(); // 5. Super Chaining Method
        System.out.println("Status Pagar : " + (this.isopen ? "TERBUKA" : "TERTUTUP"));
        System.out.println("Status Kunci : " + (this.islock ? "TERKUNCI" : "TERBUKA (UNLOCKED)"));
    }

    // 8. Logika State Percabangan
    @Override
    public boolean command(String command) {
        if (!isOn() && !command.equalsIgnoreCase("ON")) {
            System.out.println("Gagal! Sistem pagar sedang mati. Nyalakan sistem terlebih dahulu.");
            return false;
        }

        if (command.equalsIgnoreCase("ON")) {
            turnon();
            return true;
        } else if (command.equalsIgnoreCase("OFF")) {
            turnoff();
            return true;
        } else if (command.equalsIgnoreCase("UNLOCK")) {
            if (this.islock) {
                this.islock = false;
                System.out.println(">> Kunci pagar berhasil DIBUKA.");
            } else {
                System.out.println(">> Pagar memang sudah tidak terkunci.");
            }
            return true;
        } else if (command.equalsIgnoreCase("LOCK")) {
            if (!this.islock) {
                this.islock = true;
                this.isopen = false;  
                System.out.println(">> Pagar berhasil DIKUNCI dan DITUTUP.");
            } else {
                System.out.println(">> Pagar sudah terkunci.");
            }
            return true;
        } else if (command.equalsIgnoreCase("OPEN")) {
            if (this.islock) {
                System.out.println(">> Gagal! Pagar masih TERKUNCI. Buka kunci (UNLOCK) terlebih dahulu.");
                return false;
            } else {
                this.isopen = true;
                System.out.println(">> Pagar berhasil DIBUKA.");
                return true;
            }
        } else if (command.equalsIgnoreCase("CLOSE")) {
            this.isopen = false;
            System.out.println(">> Pagar berhasil DITUTUP.");
            return true;
        } else {
            System.out.println("Perintah pagar tidak valid!");
            return false;
        }
    }
}
