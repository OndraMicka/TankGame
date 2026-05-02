import settings.ConfigManager;
import ui.MyFrame;

public class Main {
    public static void main(String[] args) {
        ConfigManager.loadGameSettingsResources( "settings.json");
        new MyFrame();

    }
}