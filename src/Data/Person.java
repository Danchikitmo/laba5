package Data;

import com.google.gson.annotations.SerializedName;
import interfaces.Validatable;

import java.util.Objects;

public class Person implements Validatable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String birthday; //Поле не может быть null
    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Поле не может быть null

    public Person(String name, String birthday, Double height){
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.passportID = generatePassportId();
    }

    public Person(){

    }

    public String generatePassportId(){
        return String.valueOf(Objects.hash(passportID));
    }

    @SerializedName("personName")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @SerializedName("birthday")
    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    @SerializedName("height")
    public Double getHeight(){
        return height;
    }

    public void setHeight(Double height){
        this.height = height;
    }

    @Override
    public boolean validated(){
        return height > 0;
    }

    @Override
    public String toString(){
        return "{" + name + ";" + birthday + ";" + height + ";" + passportID + "}";
    }
}