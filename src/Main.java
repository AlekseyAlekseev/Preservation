import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {

        GameProgress gameProgressJhon = new GameProgress(91, 7, 15, 150.27);
        GameProgress gameProgressMike = new GameProgress(55, 3, 23, 257.56);
        GameProgress gameProgressTony = new GameProgress(100, 9, 7, 97.23);

        GameProgress.saveGame("C://JAVA//Installation//Games//savegames//save1.dat", gameProgressJhon);
        GameProgress.saveGame("C://JAVA//Installation//Games//savegames//save2.dat", gameProgressMike);
        GameProgress.saveGame("C://JAVA//Installation//Games//savegames//save3.dat", gameProgressTony);

        GameProgress.zipFiles("C://JAVA//Installation//Games//savegames//save1.zip",
                "C://JAVA//Installation//Games//savegames//save1.dat");

        GameProgress.zipFiles("C://JAVA//Installation//Games//savegames//save2.zip",
                "C://JAVA//Installation//Games//savegames//save2.dat");

        GameProgress.zipFiles("C://JAVA//Installation//Games//savegames//save3.zip",
                "C://JAVA//Installation//Games//savegames//save3.dat");


    }




}
