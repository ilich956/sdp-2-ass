package bridge_design_pattern;

abstract class TV   //creating TV abstract class
{
    Remote remote;

    TV(Remote r) {
        this.remote = r;
    }

    abstract void on();

    abstract void off();
}

class Sony extends TV  //child class Sony of parent class TV
{
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

class Philips extends TV //creating child class Philips of super-class TV
{
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on()  //void method on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off()  //void method off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

interface Remote  //creating interface Remote
{
    public void on();  //two methods without body

    public void off();
}

class OldRemote implements Remote   //implementation of class Remote for OldRemote
{
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }  //overriding of method on()

    @Override
    public void off() {
        System.out.println("OFF with old Remote");
    }   //overriding of method off()

}

class NewRemote implements Remote   //implementation of class Remote for NewRemote
{
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }  //overriding method on()

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }  //overriding method off()
}

public class BridgePattern     //interface which acts as a bridge which makes the functionality of concrete classes
        // independent from interface implementer classes.
{
    public static void main(String[] args) {

        // Creating and using Sony TV with an old remote
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Creating and using Sony TV with an new remote
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Creating and using Philips with an old remote
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Creating and using Philips with an new remote
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}