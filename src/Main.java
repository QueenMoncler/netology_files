
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws IOException {

        GameProgress game1 = new GameProgress(90, 2, 1, 123.2);
        GameProgress game2 = new GameProgress(15, 1, 4, 892.0);
        GameProgress game3 = new GameProgress(50, 4, 3, 458.8);


        savegame("D://gamees/savegames/save.dat1", game1);
        savegame("D://gamees/savegames/save.dat2", game2);
        savegame("D://gamees/savegames/save.dat3", game3);



        String[] files = {
                "D://gamees/savegames/save.dat1",
                "D://gamees/savegames/save.dat2",
                "D://gamees/savegames/save.dat3"
        };
        zipFiles("D://gamees/savegames/test.zip", files);

        for(String s:files) {
            File file = new File(s);
            System.out.println(file.delete());
        }
    }

    public static void savegame(String path, GameProgress saveGameProgress) {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(saveGameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String path, String[] files)  {


        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))){
            for (int i = 0; i < files.length; i++) {
                FileInputStream fis = new FileInputStream(files[i]);
                ZipEntry entry = new ZipEntry("saveGamesProgress" + (i+1) + ".txt");
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }



    }

}