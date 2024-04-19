package system;

import java.io.*;
import java.util.Vector;

public  class ReaderJSON {
    public static void read() {

        String fileName = System.getenv("FILE_PATH");

        Vector<String> dataFile= new Vector<>();


        try {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();

//            JsonObject jsonObject = JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();

//            String name = jsonObject.get("name").getAsString();
//            int x = jsonObject.get("x").getAsInt();
//            int y = jsonObject.get("y").getAsInt();
//            int minimalPoint = jsonObject.get("minimalPoint").getAsInt();
//            String discription = jsonObject.get("discription").getAsString();
//            long averagePoint = jsonObject.get("averagePoint").getAsInt();
//            Difficulty difficulty = Difficulty.valueOf(jsonObject.get("difficulty").getAsString());
//            String personName = jsonObject.get("personName").getAsString();
//
//            String birthday = jsonObject.get("birthday").getAsString();
//            LocalDate localDate = LocalDate.parse(birthday, DateTimeFormatter.ISO_LOCAL_DATE);
//            ZoneId zoneId = ZoneId.of("UTC");
//            ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
//
//            Double height  = jsonObject.get("height").getAsDouble();
//            String passportID = jsonObject.get("passportID").getAsString();
//
//            dataFile.add(name);
//            dataFile.add("Пустое поле");
//            dataFile.add(String.valueOf(x));
//            dataFile.add("Пустое поле");
//            dataFile.add(String.valueOf(y));
//            dataFile.add("Пустое поле");
//            dataFile.add(String.valueOf(minimalPoint));
//            dataFile.add("Пустое поле");
//            dataFile.add(discription);
//            dataFile.add("Пустое поле");
//            dataFile.add(String.valueOf(averagePoint));
//            dataFile.add("Пустое поле");
//            dataFile.add(difficulty.toString());
//            dataFile.add("Пустое поле");
//            dataFile.add(personName);
//            dataFile.add("Пустое поле");
//            dataFile.add(zonedDateTime.toString());
//            dataFile.add("Пустое поле");
//            dataFile.add(String.valueOf(height));
//            dataFile.add("Пустое поле");
//            dataFile.add(passportID);
//            dataFile.add("Пустое поле");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}