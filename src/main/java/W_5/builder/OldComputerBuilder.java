package W_5.builder;

public class OldComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public OldComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        this.computer.addProcessor("Old Computer Processor");
    }

    @Override
    public void buildRAM() {
        this.computer.addRAMSize(4);
    }

    @Override
    public void buildHardDrive() {
        this.computer.addHardDrive("32 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        this.computer.addGraphicsCard("Old Computer Graphics Card");
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.addOperatingSystem("Windows 7");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
