package W_5.visitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}