package ui.core;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ConfigManager {
//    // Soubor se vytvoří v kořenové složce projektu
//    private static final String FILE_PATH = "settings.json";
//    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    // ULOŽENÍ
//    public static void saveSettings(Settings settings) {
//        try (FileWriter writer = new FileWriter(FILE_PATH)) {
//            gson.toJson(settings, writer);
//            System.out.println("Nastavení uloženo do " + FILE_PATH);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // NAČTENÍ
//    public static Settings loadSettings() {
//        File file = new File(FILE_PATH);
//        if (!file.exists()) {
//            System.out.println("Soubor neexistuje, vracím výchozí nastavení.");
//            return new Settings(); // Pokud soubor není, vytvoříme nové (výchozí) nastavení
//        }
//
//        try (FileReader reader = new FileReader(FILE_PATH)) {
//            return gson.fromJson(reader, Settings.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new Settings();
//        }
//    }
}
