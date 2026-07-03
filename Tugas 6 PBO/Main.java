import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Laptop laptop;

        System.out.println("Pilih Laptop:");
        System.out.println("1. Toshiba");
        System.out.println("2. MacBook");
        System.out.print("Masukkan pilihan: ");
        int pilih = input.nextInt();
        input.nextLine();

        // 🔥 INI YANG PENTING
        if (pilih == 1) {
            laptop = new Toshiba();
        } else if (pilih == 2) {
            laptop = new MacBook();
        } else {
            System.out.println("Pilihan tidak valid, default Toshiba");
            laptop = new Toshiba();
        }

        LaptopUser user = new LaptopUser(laptop);

        String command;

        do {
            System.out.println("\nInput (ON / OFF / UP / DOWN / EXIT): ");
            command = input.nextLine();

            switch (command.toUpperCase()) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                case "OFF":
                    user.turnOffLaptop();
                    break;
                case "UP":
                    user.makeLaptopLouder();
                    break;
                case "DOWN":
                    user.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Command tidak valid");
            }

        } while (!command.equalsIgnoreCase("EXIT"));

        input.close();
    }
}