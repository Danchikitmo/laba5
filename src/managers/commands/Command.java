package managers.commands;

import Data.LabWork;

import java.util.Vector;

public class Command implements LabWorkCommand{
    private final String name;
    public Command(String name){
        this.name = name;
    }

    @Override
    public void execute(String args){
        System.out.println("Команда " + name + " успешно выполнена");
    }

    @Override
    public void execute(Vector<LabWork> labWorks){
        System.out.println("123");
    }


    public String getName(){
        return name;
    }
}
