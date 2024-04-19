package managers.commands;

import interfaces.CommandExecutor;

public class Command implements CommandExecutor {
    private final String name;
    public Command(String name){
        this.name = name;
    }
    @Override
    public void execute(String args){
        System.out.println("Команда " + name + " успешно выполнена");
    }

    public String getName(){
        return name;
    }
}
