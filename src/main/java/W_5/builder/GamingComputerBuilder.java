package W_5.builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public GamingComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        this.computer.addProcessor("Gaming Computer Processor");
    }

    @Override
    public void buildRAM() {
        this.computer.addRAMSize(32);
    }

    @Override
    public void buildHardDrive() {
        this.computer.addHardDrive("2 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        this.computer.addGraphicsCard("Gaming Computer Graphics Card");
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.addOperatingSystem("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
