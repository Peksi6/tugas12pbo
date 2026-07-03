public class LaptopUser {

    private Laptop laptop;

    public LaptopUser(Laptop laptop) {
        this.laptop = laptop;
    }

    public void turnOnLaptop() {
        laptop.powerOn();
    }

    public void turnOffLaptop() {
        laptop.powerOff();
    }

    public void makeLaptopLouder() {   // 🔥 HARUS INI
        laptop.volumeUp();
    }

    public void makeLaptopSilence() {  // 🔥 HARUS INI
        laptop.volumeDown();
    }
}