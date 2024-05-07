package managers;

import Adapter.ZonedDataTimeAdapter;
import Data.Works;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.ZonedDateTime;

public class FileManagers {
    static String filePath = System.getenv("FILE_PATH");

    public static Works readFile(String filePath){
        String filePath1 = System.getenv("FILE_PATH") + "LabWork.json";
        try (Reader reader = new FileReader(filePath1)){
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(ZonedDateTime.class, new ZonedDataTimeAdapter());
            Gson gson = gsonBuilder.create();
            return gson.fromJson(reader, Works.class);
        } catch (FileNotFoundException e){
            System.err.println("Файл не найден");
        } catch (IOException e){
            System.err.println("Что-то пошло не так при чтении из файла");
        }
        return null;
    }

    public static void writeFile(String works){
        try (Writer writer = new FileWriter(filePath + "LabWork.json")){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(works, writer);
            System.out.println("Данные успешно записаны в файл");
        } catch (IOException e){
            System.err.println("Что-то пошло не так при записи в файл" + e.getMessage());
        }
    }

    public static void clearFile(){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e){
            System.err.println("При очистке файла произошла ошибка");
        }
    }
}
