public class Lenovo implements Laptop {
    
    private int volume;
    boolean is_power_on;

    public Lenovo(){
        this.volume = 50;
    }

    @Override
    public void powerOn() {
        is_power_on = true;
        System.out.println("Laptop is On");
        System.out.println("Lenovo ThinkPad");
    }

    @Override
    public void powerOff() {
        is_power_on = false;
        System.out.println("Shutdown is process ....");
    }

    @Override
    public void volumeUp() {
        if(is_power_on){
            if(this.volume==MAX_VOL){
                System.out.println("volume is full ");
            }
            else{
                this.volume += 10;
                System.out.println("volume is :" + this.getvolume());
            }
        }
    }

    @Override
    public void volumeDown(){
        if(is_power_on){
            if(this.volume==MIN_VOL){
                System.out.println("volume is 0% ");
            }
            else{
                this.volume -= 10;
                System.out.println("volume is :" + this.getvolume());
            }
        }
    }

    public int getvolume(){
        return this.volume;
    }
}   