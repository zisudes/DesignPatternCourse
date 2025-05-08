package W_8;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import static javafx.scene.layout.GridPane.getColumnIndex;
import static javafx.scene.layout.GridPane.getRowIndex;

public class PixelGrid {
    private static int SIZE_OF_GRID;
    private static int[][] grid;
    private static PixelGrid instance;

    private static int cursorX;
    private static int cursorY;

    private final GridPane pane;

    private PixelGrid() {
        SIZE_OF_GRID = 20;
        grid = new int[SIZE_OF_GRID][SIZE_OF_GRID];
        cursorX = 0;
        cursorY = 0;

        this.pane = new GridPane();

        for (int i = 0; i < SIZE_OF_GRID; i++) {
            for (int j = 0; j < SIZE_OF_GRID; j++) {
                this.pane.add(new PixelNode(false), i, j);
            }
        }

        moveHighlightTo(0, 0);
    }

    public GridPane getGridPane(){
        return this.pane;
    }

    public static PixelGrid getInstance(){
        if (instance == null){
            instance = new PixelGrid();
        }
        return instance;
    }

    public int[][] getGrid(){
        return grid;
    }

    public int getCursorX(){
        return cursorX;
    }

    public int getCursorY(){
        return cursorY;
    }

    public void setCursorX(int x){
        if (0 <= x & x < SIZE_OF_GRID){
            moveHighlightTo(x, cursorY);
            cursorX = x;
        } else if (x < 0) {
            cursorX = 0;
        } else {
            cursorX = SIZE_OF_GRID - 1;
        }
    }

    public void setCursorY(int y){
        if (0 <= y & y < SIZE_OF_GRID){
            moveHighlightTo(cursorX, y);
            cursorY = y;
        } else if (y < 0){
            cursorY = 0;
        } else {
            cursorY = SIZE_OF_GRID - 1;
        }
    }

    public int getPixel(int x, int y){
        return grid[x][y];
    }

    public int getSize(){
        return SIZE_OF_GRID;
    }

    public void togglePixel(int x, int y){
        for (Node node : this.pane.getChildren()) {
            if (node instanceof PixelNode
                    && getColumnIndex(node) == x
                    && getRowIndex(node) == y) {
                ((PixelNode) node).toggleFill();
            }
        }
    }

    public void moveHighlightTo(int x, int y){
        int prevX = getCursorX();
        int prevY = getCursorY();

        for (Node node : this.pane.getChildren()) {
            if (node instanceof PixelNode
                    && getColumnIndex(node) == x
                    && getRowIndex(node) == y) {
                ((PixelNode) node).addHighlight();
            } else if (node instanceof PixelNode
            && getColumnIndex(node) == prevX
            && getRowIndex(node) == prevY) {
                ((PixelNode) node).removeHighlight();
            }
        }
    }
}