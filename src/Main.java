import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayList listFilesSrcMain = new ArrayList<>();
        listFilesSrcMain.add("D://Gamees/src/main/Main.java");
        listFilesSrcMain.add("D://Gamees/src/main/Utils.java");


        ArrayList listFilesTemp = new ArrayList<>();
        listFilesTemp.add("D://Gamees/temp/temp.txt");

        HashMap map = new HashMap<>();
        map.put("main", listFilesSrcMain);
        map.put("temp", listFilesTemp);

        ArrayList list = new ArrayList<>();
        list.add("D://Gamees/src");
        list.add("D://Gamees/src/main");
        list.add("D://Gamees/src/test");
        list.add("D://Gamees/res");
        list.add("D://Gamees/res/drawables");
        list.add("D://Gamees/res/vectors");
        list.add("D://Gamees/res/icons");
        list.add("D://Gamees/savegames");
        list.add("D://Gamees/temp");

        createDirectory(list, map);

        try (FileWriter writer = new FileWriter((String) listFilesTemp.get(0), false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createDirectory(ArrayList<String> list, HashMap m) {
        for (String s : list) {
            File file = new File(s);
            if (file.mkdir()) {
                sb.append("\n Директория " + file.getAbsolutePath() + " успешно создана");
                if (m.containsKey(file.getName())) {
                    ArrayList<String> listFiles = (ArrayList<String>) m.get(file.getName());
                    for (String v : listFiles) {
                        File createFile = new File(v);
                        try {
                            createFile.createNewFile();
                            sb.append("\n Файл " + createFile.getAbsolutePath() + " успешно создан!");
                        } catch (IOException e) {
                            throw new RuntimeException("Ошибка создания файлов");
                        }
                    }
                }
            } else sb.append("\n Ошибка создания Директории " + file.getAbsolutePath());
        }
    }
}