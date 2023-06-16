import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static final File DGAMES = new File("D://Gamees");
    public static void main(String[] args)  {
        StringBuilder sb = new StringBuilder();
        String text = "";

        File srcDirect = new File(DGAMES, "src");
        File resDirect = new File(DGAMES, "res");
        File savegamesDirect = new File(DGAMES, "savegames");
        File tempDirect = new File(DGAMES, "temp");

        if(srcDirect.mkdir()){
            //text += "\nПапка "+srcDirect.getAbsolutePath()+" успешно создана");
            text += "\nПапка "+srcDirect.getAbsolutePath()+" успешно создана";
            File srcTestDirect = new File(srcDirect, "test");
            if(srcTestDirect.mkdir()){
                text += "\nПапка "+srcTestDirect.getAbsolutePath()+" успешно создана";
                File srcMainDirect = new File(srcDirect, "main");
                if(srcMainDirect.mkdir()){
                    text += "\nПапка "+srcMainDirect.getAbsolutePath()+" успешно создана";
                    File fileMain = new File(srcMainDirect.getAbsolutePath() + "//Main.java");
                    File fileUtils = new File(srcMainDirect.getAbsolutePath() + "//Utils.java");
                    try {
                        fileMain.createNewFile();
                        text += "\nФайл "+fileMain.getAbsolutePath()+" успешно создан";
                        fileUtils.createNewFile();
                        text += "\nФайл "+fileUtils.getAbsolutePath()+" успешно создан";
                    } catch (IOException e) {
                        throw new RuntimeException("Ошибка создания файлов");
                    }

                }
                else{text += "\nОшибка создания папки "+srcMainDirect.getAbsolutePath();}
            }
            else {text += "\nОшибка создания папки "+srcTestDirect.getAbsolutePath();}
        }
        else {text += "\nОшибка создания папки "+srcDirect.getAbsolutePath();}


        if(resDirect.mkdir()){
            text += "\nПапка "+resDirect.getAbsolutePath() +" успешно создана";
            File resDrowablesDirect = new File(resDirect, "drawables");
            if(resDrowablesDirect.mkdir()){
                text += "\nПапка "+ resDrowablesDirect.getAbsolutePath() + " успешно создана";
                File resVectorsDirect = new File(resDirect, "vectors");
                if(resVectorsDirect.mkdir()){
                    text += "\nПапка "+ resVectorsDirect.getAbsolutePath() + " успешно создана";
                    File resIconsDirect = new File(resDirect, "icons");
                    if(resIconsDirect.mkdir()){
                        text += "\nПапка "+ resIconsDirect.getAbsolutePath() + " успешно создана";
                    }
                    else{ text += "\nОшибка создания папки "+resIconsDirect.getAbsolutePath();}
                }
                else{
                    text += "\nОшибка создания папки "+resVectorsDirect.getAbsolutePath();
                }
            }
            else {
                text += "\nОшибка создания папки " + resDrowablesDirect.getAbsolutePath();
            }
        }

        if(savegamesDirect.mkdir()){
            text += "\nПапка "+ savegamesDirect.getAbsolutePath() +" успешно создана";
        }
        else{
            text += "\nОшибка создания папки "+savegamesDirect.getAbsolutePath();
        }

        if(tempDirect.mkdir()){
            text += "\nПапка "+ tempDirect.getAbsolutePath()+ " спешно создана";
            File tempTempTxt = new File(tempDirect.getAbsolutePath(), "//temp.txt");
            try {
                tempTempTxt.createNewFile();
                text += "\nФайл "+ tempTempTxt.getAbsolutePath()+" успешно создан";
                FileOutputStream fos = new FileOutputStream(tempTempTxt.getAbsolutePath());

                byte[] bytes = text.getBytes();
                fos.write(bytes);
            } catch (IOException e) {
                throw new RuntimeException("Ошибка создания файлов");
            }
        }



    }
}