package W_5.visitor;

public class Main {
    public static void main(String[] args) {
        /* set up */
        Directory root = new Directory("root");
        File file1 = new File("file1.pdf", 10);
        File file2 = new File("file2file.txt", 120);
        Directory subDir = new Directory("subDir");
        File file3 = new File("file3test.txt", 15);
        File file4 = new File("file4ok.txt", 10);

        root.addChild(file1);
        root.addChild(file2);
        subDir.addChild(file3);
        subDir.addChild(file4);
        root.addChild(subDir);

        /* size calc */
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of files in root: " + sizeVisitor.getTotalSize() + " MB");

        sizeVisitor.reset();
        subDir.accept(sizeVisitor);
        System.out.println("Total size of files in subDir: " + sizeVisitor.getTotalSize() + " MB\n");

        /* pattern search */
        SearchVisitor searchVisitor = new SearchVisitor("t");
        root.accept(searchVisitor);
        searchVisitor.printAllMatches();

        System.out.println();
        searchVisitor.setPattern(".pdf");
        root.accept(searchVisitor);
        searchVisitor.printAllMatches();
    }
}
