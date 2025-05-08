package W_8;

public class TogglePixelCommand implements Command {
    @Override
    public void execute() {
        PixelGrid grid = PixelGrid.getInstance();
        grid.togglePixel(grid.getCursorX(), grid.getCursorY());
    }
}
