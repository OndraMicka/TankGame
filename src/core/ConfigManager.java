package core;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConfigManager {
    private static Settings settings;
    public static void loadGameSettingsResources(String resourcePath) {
        Gson gson = new Gson();
        try (InputStream is = Settings.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new RuntimeException("Soubor nebyl nalezen v resources: " + resourcePath);
            }
            try (Reader rd = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                settings = gson.fromJson(rd, Settings.class);
            }
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }
    public static void saveGameSettingsResources(String resourcePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("res/"+resourcePath))) {
            gson.toJson(settings,bw);
        }catch (IOException e){
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }
    public static void resetToDefaultSettings(String defaultSettingsPath, String settingsPath) {
        loadGameSettingsResources(defaultSettingsPath);
        saveGameSettingsResources(settingsPath);
    }

    public static Settings getSettings() {
        return settings;
    }

}
