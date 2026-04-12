package ui.core;


public class SettingsSave {

    /*
    public void save(String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(this);
        } catch (IOException e) {
            System.err.println("Chyba při ukládání: " + e.getMessage());
        }
    }

    public static Game load(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            Game loadedGame = (Game) in.readObject();
            loadedGame.itemParser = new ItemParser(loadedGame);
            return loadedGame;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
     */
}
