package W_4;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private List<IMemento> next;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.next = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveAction();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveAction();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void addRedoMemento(IMemento memento){
        System.out.println("RedoMemento set");
        next.add(memento);
    }

    public IMemento getRedoMemento(){
        return next.remove(next.size() - 1);
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");

            addRedoMemento(model.createMemento());

            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            updateListView();

            gui.updateGui();
        }
    }

    public void redo(){
        if (!next.isEmpty()){
            System.out.println("RedoMemento found, setting state");

            IMemento currentState = model.createMemento();
            history.add(currentState);

            model.restoreState(getRedoMemento());
            updateListView();

            gui.updateGui();
        }
    }

    public void updateListView() {
        ListView<MementoButton> list = gui.getListView();
        list.getItems().clear();
        history.forEach(memento -> list.getItems().add(0, new MementoButton((Memento) memento, this)));
    }

    public void jumpToState(IMemento memento){
        System.out.println("jumping to state");

        model.restoreState(memento);
        int index = history.indexOf(memento);
        System.out.println("index " + index);
        if (index != -1) {
            next.addAll(history.subList(index, history.size()));
            history.subList(index, history.size()).clear();
        }
        updateListView();
        gui.updateGui();
    }

    private void saveAction() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        updateListView();
        next.clear();
    }
}