package byt.money.componentbarmmi.internal;

import byt.money.common.bar.IWorkingPanel;
import byt.money.common.service.IStartStop;
import byt.money.componentbarmmi.internal.controller.ComponentBarMmiController;
import byt.money.historymmi.HistoryMmi;
import byt.money.modelmmi.ModelMmi;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ComponentBarMmi implements IStartStop, IComponentBarMmi {

    private static final Logger LOGGER = Logger.getLogger(ComponentBarMmi.class.getName());

    private FXMLLoader fxmlLoader;
    private GridPane root;
    private ComponentBarMmiController controller;
    private List<IWorkingPanel> panels;

    public ComponentBarMmi() {
        fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ComponentBarMmi.fxml"));
        panels = new LinkedList<>();
        start();
    }

    @Override
    public void start() {
        try {
            panels = new LinkedList<>();
            panels.add(new ModelMmi());
            panels.add(new HistoryMmi());
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            controller = fxmlLoader.getController();
            controller.setParent(root);
            controller.setPanels(panels);
            controller.start();
        } catch (IOException ex) {
            LOGGER.log(Level.INFO, "Exception during activate componentbar-mmi ", ex);
        }
    }

    public GridPane getScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ComponentBarMmi.fxml"));
        GridPane root = fxmlLoader.load();
        ComponentBarMmiController controller = fxmlLoader.getController();
        controller.setParent(root);
        controller.setPanels(panels);
        controller.start();
        return root;
    }

    @Override
    public void stop() {
    }

    @Override
    public Map<Button, IWorkingPanel> getFullPanels() {
        return controller.getFullPanels();
    }

}
