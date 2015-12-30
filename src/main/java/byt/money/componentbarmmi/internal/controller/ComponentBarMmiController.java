package byt.money.componentbarmmi.internal.controller;

import byt.money.common.bar.IWorkingPanel;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ComponentBarMmiController implements Initializable {

    private Parent root;
    private List<IWorkingPanel> panels;
    private Map<Button, IWorkingPanel> fullPanels;

    public void setParent(Parent root) {
        this.root = root;
    }

    public void setPanels(List<IWorkingPanel> panels) {
        this.panels = panels;
    }

    public void start() {
        fullPanels = new HashMap<>();
        for (int i = 0; i < panels.size(); i++) {
            IWorkingPanel panel = panels.get(i);
            Button button = panel.getButton();
            button.setPrefSize(75, 75);
            button.setMinSize(75, 75);
            button.setMaxSize(75, 75);
            GridPane.setRowIndex(button, i);
            ((GridPane) root).getChildren().add(button);
            fullPanels.put(button, panel);
        }
    }

    public Map<Button, IWorkingPanel> getFullPanels() {
        return fullPanels;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
