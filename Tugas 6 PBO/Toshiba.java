public class Toshiba implements Laptop {

    private int volume = 50;
    private boolean isPowerOn;

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Toshiba menyala");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Toshiba mati");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            volume++;
            System.out.println("Volume Toshiba: " + volume);
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            volume--;
            System.out.println("Volume Toshiba: " + volume);
        }
    }
}