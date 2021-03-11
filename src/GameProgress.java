import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void saveGame(String savePath, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(savePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String zipPath, String filePath) {
        File fileSave = new File(filePath);
        try (ZipOutputStream zout = new ZipOutputStream(new
                FileOutputStream(zipPath));
             FileInputStream fis = new FileInputStream(filePath)) {
//            try (Stream<Path> paths = Files.walk(Paths.get(filePath))) {
//                paths
//                        .filter(Files::isRegularFile)
//                        .forEach(System.out::println);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
            ZipEntry entry = new ZipEntry("packed_save.dat");
            zout.putNextEntry(entry);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }
        if (fileSave.delete()) {
            System.out.println("Файл " + fileSave.getName() + " удален");
        } else {
            System.out.println("Файл " + fileSave.getName() + " не найден");
        }
    }
}



