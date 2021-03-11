import java.io.File;

public class Main {

    public static void main(String[] args) {

        GameProgress gameProgressJhon = new GameProgress(91, 7, 15, 150.27);
        GameProgress gameProgressMike = new GameProgress(55, 3, 23, 257.56);
        GameProgress gameProgressTony = new GameProgress(100, 9, 7, 97.23);


        System.out.println("Идёт сохранение...");
        GameProgress.saveGame("C://JAVA//Installation//Games//savegames//save1.dat", gameProgressJhon);
        GameProgress.saveGame("C://JAVA//Installation//Games//savegames//save2.dat", gameProgressMike);
        GameProgress.saveGame("C://JAVA//Installation//Games//savegames//save3.dat", gameProgressTony);
        System.out.println("Сохранение успешно");


        System.out.println("Идёт архивация сохраняемых файлов...");
        GameProgress.zipFiles("C://JAVA//Installation//Games//savegames//save1.zip",
                "C://JAVA//Installation//Games//savegames//save1.dat");

        GameProgress.zipFiles("C://JAVA//Installation//Games//savegames//save2.zip",
                "C://JAVA//Installation//Games//savegames//save2.dat");

        GameProgress.zipFiles("C://JAVA//Installation//Games//savegames//save3.zip",
                "C://JAVA//Installation//Games//savegames//save3.dat");

    }
}
