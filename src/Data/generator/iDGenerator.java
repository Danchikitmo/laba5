package Data.generator;

import java.util.ArrayList;

public class iDGenerator {
    private static ArrayList<Integer> idList = new ArrayList<>();
    private Integer id;

    public iDGenerator(){
        idList = new ArrayList<>();
    }

    public static Integer generateid(){
        Integer id = (int)Math.floor(Math.random() * 386800) + 244;
        while (idList.contains(id)){
            id = (int)Math.floor(Math.random() * 386800) + 244;
        }
        idList.add(id);
        return id;
    }


    public static void remove(Integer id){
        idList.remove(id);
    }

    public static void insert(Integer id){
        idList.add(id);
    }
}
