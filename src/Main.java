import core.ConfigManager;
import ui.MyFrame;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        ConfigManager.loadGameSettingsResources("settings.json");
        SwingUtilities.invokeLater(MyFrame::new);


    }
}