package Data;

import com.google.gson.annotations.SerializedName;
import interfaces.Validatable;

public class Coordinates implements Validatable{
    private long x; //Поле не может быть null
    private long y; //Максимальное значение поля: 915

    public Coordinates(long x, long y){
        this.x = x;
        this.y = y;
    }

    @SerializedName("")
    public  long getX(){
        return x;
    }

    public void setX(long x){
        this.x = x;
    }

    @SerializedName("")
    public long getY(){
        return y;
    }

    public void setY(long y){
        this.y = y;
    }

    @Override
    public boolean validated(){
        return y > 915;
    }

    @Override
    public String toString(){
        return "{" + x + ";" + y + "}";
    }

}
