package W_5.visitor;

import java.util.ArrayList;

public class SearchVisitor implements FileSystemVisitor {
    private final ArrayList<FileSystemElement> matching = new ArrayList<>();
    private String pattern;

    public SearchVisitor(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        matching.clear();
        this.pattern = pattern;
    }

    @Override
    public void visit(File file) {
        if (file.getName().toLowerCase().contains(pattern.toLowerCase())){
            matching.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        if (directory.getName().toLowerCase().contains(pattern.toLowerCase())){
            matching.add(directory);
        }
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public void printAllMatches(){
        System.out.println("results that contain \"" + getPattern() + "\" in the name");
        for (FileSystemElement i : matching) {
            if (i instanceof File) {
                System.out.println(((File) i).getName());
            } else if (i instanceof Directory) {
                System.out.println(((Directory) i).getName() + "/");
            }
        }
    }
}
