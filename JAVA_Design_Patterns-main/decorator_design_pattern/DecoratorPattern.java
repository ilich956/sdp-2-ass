package decorator_design_pattern;

//interface Dress
interface Dress {
    public void assemble();
}

//implementation of Dress for BasicDress
class BasicDress implements Dress {
    //overriding method from interface
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}

//implementation of Dress for DressDecorator
class DressDecorator implements Dress {
    //constructor
    protected Dress dress;

    public DressDecorator(Dress c) {
        this.dress = c;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

//child class CasualDress of super-class DressDecorator
class CasualDress extends DressDecorator {
    public CasualDress(Dress c) {
        super(c);
    }


    //void method to add feature
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress Features");
    }
}

//child class SportyDress of super-class DressDecorator
class SportyDress extends DressDecorator {
    public SportyDress(Dress c) {
        super(c);
    }

    //void method to add feature
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

//child class FancyDress of super-class DressDecorator
class FancyDress extends DressDecorator {
    public FancyDress(Dress c) {
        super(c);
    }

    //void method to add feature
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {

        //creation of combination of dress using decorators
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }
}