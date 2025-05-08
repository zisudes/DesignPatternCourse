package W_8;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;

import java.util.Arrays;

public class GenerateCodeCommand implements Command {
    @Override
    public void execute() {
        PixelGrid grid = PixelGrid.getInstance();

        int[][] printableArr = new int[grid.getSize()][grid.getSize()];

        grid.getGridPane().getChildren().forEach(child -> {
            Integer column = GridPane.getColumnIndex(child);
            Integer row = GridPane.getRowIndex(child);
            if (column != null && row != null && child instanceof PixelNode) {
                printableArr[row][column] = ((PixelNode) child).getValueAsInt();
            }
        });

        StringBuilder str = new StringBuilder();
        str.append("int[][] pixelArt = {");
        for (int[] index : printableArr) {
            for (int i = 0; i < index.length; i++) {
                if (i == 0){
                    str.append("\n    {" + index[i] + ", ");
                }
                else if (i == index.length - 1){
                    str.append(index[i] + "},");
                } else {
                    str.append(index[i] + ", ");
                }
            }
        }
        str.append("\n};");

        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        content.putString(str.toString());
        clipboard.setContent(content);

        System.out.println(str + "\n^^ COPIED TO CLIPBOARD ^^");

    }
}
