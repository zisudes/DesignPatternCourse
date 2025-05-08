package W_8;

public class MoveCursorDownCommand implements Command {
    @Override
    public void execute() {
        PixelGrid grid = PixelGrid.getInstance();
        grid.setCursorY(grid.getCursorY() + 1);
    }
}
