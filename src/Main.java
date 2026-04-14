import core.ConfigManager;
import core.Settings;
import ui.MyFrame;

import java.util.concurrent.atomic.AtomicReference;


public class Main {
    public static void main(String[] args) {
        ConfigManager.loadGameSettingsResources( "settings.json");
        System.out.println(ConfigManager.getSettings().getPlayer1().getPlayerName());
        new MyFrame();


    }
}