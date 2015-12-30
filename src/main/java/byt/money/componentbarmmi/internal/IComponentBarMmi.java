package byt.money.componentbarmmi.internal;

import byt.money.common.bar.IWorkingPanel;
import java.io.IOException;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Lukasz
 */
public interface IComponentBarMmi {
    
    public Map<Button, IWorkingPanel> getFullPanels();
    
    public GridPane getScene() throws IOException;
    
}
