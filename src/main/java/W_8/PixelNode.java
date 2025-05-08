package W_8;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class PixelNode extends HBox {
    boolean filled;
    boolean highlighted;

    public PixelNode(boolean filled) {
        this.filled = filled;
        this.highlighted = false;
        this.setMinWidth(12);
        this.setMaxWidth(12);
        this.setMinHeight(12);
        this.setMaxHeight(12);
        setFillGraphic();
    }

    private void setFillGraphic(){
        if (this.filled){
            this.setStyle("-fx-background-color: rgba(44,119,148,0.47);");
        } else {
            this.setStyle("-fx-background-color: rgba(210,227,234,0.47);");
        }
    }

    public void toggleFill(){
        this.filled = !this.filled;
        setFillGraphic();
    }

    public int getValueAsInt(){
        return this.filled ? 1 : 0;
    }

    public void removeHighlight(){
        this.highlighted = false;
        this.getChildren().clear();
    }

    public void addHighlight(){
        this.highlighted = true;
        Text highlight = new Text("+");
        this.setAlignment(Pos.CENTER);

        this.getChildren().add(highlight);
    }
}
