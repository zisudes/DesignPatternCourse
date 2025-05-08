package W_5.visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize(); // Add the size of the file
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void reset(){
        totalSize = 0;
    }
}
