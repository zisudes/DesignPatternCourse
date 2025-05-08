package W_5.builder;

public class Computer {
    String processor;
    Integer RAMSize;
    String hardDrive;
    String graphicsCard;
    String operatingSystem;

    public Computer() {}

    public void addProcessor(String processor) {
        this.processor = processor;
    }

    public void addRAMSize(int RAMSize) {
        this.RAMSize = RAMSize;
    }

    public void addHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void addGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void addOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString(){
        String string = "";
        if (this.processor != null) { string += "Processor: " + this.processor; }
        if (this.RAMSize != null) { string += "\nRAM Size: " + this.RAMSize + " GB"; }
        if (this.hardDrive != null) { string += "\nHard Drive: " + this.hardDrive; }
        if (this.graphicsCard != null) { string += "\nGraphics Card: " + this.graphicsCard; }
        if (this.operatingSystem != null) { string += "\nOS: " + this.operatingSystem; }

        return string;
    }
}
