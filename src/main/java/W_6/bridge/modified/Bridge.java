package W_6.bridge.modified;

abstract class Vehicle {
    protected Workshop workShop0;
    protected Workshop workShop1;
    protected Workshop workShop2;

    protected Vehicle(Workshop workShop0, Workshop workShop1, Workshop workShop2)
    {
        this.workShop0 = workShop0;
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }

    abstract public void manufacture();
}

class Car extends Vehicle {
    public Car(Workshop workShop0, Workshop workShop1, Workshop workShop2)
    {
        super(workShop0, workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        workShop0.work();
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
    }
}

class Bike extends Vehicle {
    public Bike(Workshop workShop0, Workshop workShop1, Workshop workShop2)
    {
        super(workShop0, workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        workShop0.work();
        System.out.print("Bike ");
        workShop1.work();
        workShop2.work();
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(Workshop workShop0, Workshop workShop1, Workshop workShop2)
    {
        super(workShop0, workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        workShop0.work();
        System.out.print("Motorcycle ");
        workShop1.work();
        workShop2.work();
    }
}

interface Workshop
{
    void work();
}

class Prepare implements Workshop {
    @Override
    public void work()
    {
        System.out.println("Preparing to produce...");
    }
}

class Produce implements Workshop {
    @Override
    public void work()
    {
        System.out.print("Produced");
    }
}

class Assemble implements Workshop {
    @Override
    public void work()
    {
        System.out.print(" And");
        System.out.println(" Assembled.\n");
    }
}

class BridgePattern {
    public static void main(String[] args)
    {
        Prepare prepareWorkshop = new Prepare();
        Produce produceWorkshop = new Produce();
        Assemble assembleWorkshop = new Assemble();

        Vehicle vehicle1 = new Car(prepareWorkshop, produceWorkshop, assembleWorkshop);
        vehicle1.manufacture();

        Vehicle vehicle2 = new Bike(prepareWorkshop, produceWorkshop, assembleWorkshop);
        vehicle2.manufacture();

        Vehicle vehicle3 = new Motorcycle(prepareWorkshop, produceWorkshop, assembleWorkshop);
        vehicle3.manufacture();
    }
}

