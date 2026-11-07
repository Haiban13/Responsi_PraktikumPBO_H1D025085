import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 9. Polimorfisme Interface (Pemanggilan method melalui variabel referensi bertipe interface)
        System.out.println("=== PEMBUKTIAN POLIMORFISME INTERFACE ===");
        Controll  lampInterface = new Lampu("DEV-001", "Lampu Ruang Tamu");
        lampInterface.turnon(); // Memanggil method interface Controllable

        DeviceKeamanan cctvInterface = new Cctv("DEV-003", "CCTV Garasi");
        cctvInterface.AktifkanKeamanan(); // Memanggil method interface SecurityDevice
        System.out.println("=========================================\n");

        // Objek Konkret Perangkat Smart House
        Lampu lamp = new Lampu("DEV-001", "Lampu Utama", 80, "Warm White");
        Gate gate = new Gate("DEV-002", "Pagar Utama");
        Cctv cctv = new Cctv("DEV-003", "CCTV Depan", 90,true);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==================================");
            System.out.println("    SMART HOUSE IOT CONTROL     ");
            System.out.println("==================================");
            System.out.println("1. Lampu Smart     [" + (lamp.isOn() ? "ON" : "OFF") + "]");
            System.out.println("2. Pagar Smart     [" + (gate.isOn() ? "ON" : "OFF") + "]");
            System.out.println("3. CCTV Smart      [" + (cctv.isOn() ? "ON" : "OFF") + "]");
            System.out.println("4. Ringkasan Status Semua Perangkat");
            System.out.println("0. Keluar");
            System.out.print("Pilih Perangkat (0-4): ");

            String choiceStr = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (Exception e) {
                System.out.println("Pilihan harus berupa angka!");
                continue;
            }

            switch (choice) {
                case 1:
                    menuLamp(lamp, scanner);
                    break;
                case 2:
                    menuGate(gate, scanner);
                    break;
                case 3:
                    menuCCTV(cctv, scanner);
                    break;
                case 4:
                    System.out.println("\n--- STATUS RINCI SELURUH PERANGKAT ---");
                    lamp.display();
                    System.out.println("--------------------------------------");
                    gate.display();
                    System.out.println("--------------------------------------");
                    cctv.display();
                    break;
                case 0:
                    running = false;
                    System.out.println("Sistem Smart House dimatikan. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        }
        scanner.close();
    }

    private static void menuLamp(Lampu lamp, Scanner scanner) {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- OPTION LAMPU SMART ---");
            System.out.println("1. Toggle Power (ON/OFF)");
            System.out.println("2. Tambah Kecerahan (BRIGHTER)");
            System.out.println("3. Kurangi Kecerahan (DIMMER)");
            System.out.println("4. Cek Detail Lampu");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih opsi lampu: ");

            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    if (lamp.isOn()) lamp.command("OFF");
                    else lamp.command("ON");
                    break;
                case "2":
                    lamp.command("BRIGHTER");
                    break;
                case "3":
                    lamp.command("DIMMER");
                    break;
                case "4":
                    lamp.display();
                    break;
                case "0":
                    loop = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    private static void menuGate(Gate gate, Scanner scanner) {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- OPTION PAGAR SMART ---");
            System.out.println("1. Toggle Power System (ON/OFF)");
            System.out.println("2. Buka Kunci (UNLOCK)");
            System.out.println("3. Kunci Pagar (LOCK)");
            System.out.println("4. Buka Pagar (OPEN)");
            System.out.println("5. Tutup Pagar (CLOSE)");
            System.out.println("6. Cek Detail Pagar");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih opsi pagar: ");

            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    if (gate.isOn()) gate.command("OFF");
                    else gate.command("ON");
                    break;
                case "2":
                    gate.command("UNLOCK");
                    break;
                case "3":
                    gate.command("LOCK");
                    break;
                case "4":
                    gate.command("OPEN");
                    break;
                case "5":
                    gate.command("CLOSE");
                    break;
                case "6":
                    gate.display();
                    break;
                case "0":
                    loop = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    private static void menuCCTV(Cctv cctv, Scanner scanner) {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- OPTION CCTV SMART ---");
            System.out.println("1. Toggle rekaman (ON/OFF)");
            System.out.println("2. Geser lensa kiri (PAN_LEFT)");
            System.out.println("3. Geser lensa kanan (PAN_RIGHT)");
            System.out.println("4. Toggle mode keamanan (SECURITY_TOGGLE)");
            System.out.println("5. Cek Detail CCTV");
            System.out.println("0. Kembali ke menu utama");
            System.out.print("Pilih opsi CCTV: ");

            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    if (cctv.isOn()) cctv.command("OFF");
                    else cctv.command("ON");
                    break;
                case "2":
                    cctv.command("PAN_LEFT");
                    break;
                case "3":
                    cctv.command("PAN_RIGHT");
                    break;
                case "4":
                    cctv.command("SECURITY_TOGGLE");
                    break;
                case "5":
                    cctv.display();
                    break;
                case "0":
                    loop = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}