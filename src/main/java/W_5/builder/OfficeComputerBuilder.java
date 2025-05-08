package W_5.builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public OfficeComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        this.computer.addProcessor("Office Computer Processor");
    }

    @Override
    public void buildRAM() {
        this.computer.addRAMSize(16);
    }

    @Override
    public void buildHardDrive() {
        this.computer.addHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        this.computer.addGraphicsCard("Office Computer Graphics Card");
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.addOperatingSystem("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
