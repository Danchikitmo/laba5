package managers;

import Adapter.ZonedDataTimeAdapter;
import Data.LabWork;
import Data.Works;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.Vector;

public class FileManagers {
    static String filePath = System.getenv("FILE_PATH") + "LabWork.json";

    public static Works readFile(String filePath){
        try (Reader reader = new FileReader(filePath)){
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

    public static void writeFile(Vector<LabWork> works){
        try (Writer writer = new FileWriter(filePath)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(works, writer);
            System.out.println("Данные успешно записаны в файл");
        } catch (IOException e){
            System.err.println("Что-то пошло не так при записи в файл");
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
