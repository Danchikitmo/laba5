package managers;

import managers.commands.Command;

import java.util.LinkedHashMap;

public class CommandManagers {
    private final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();

    public void addCommand(Command command){
        this.commands.put(command.getName(), command);
    }

    public void execute(String name, String args){
        Command command = commands.get(name);
        if(command == null){
            System.out.println("Такой команды нет");
        } else {
            command.execute(args);
        }
    }
}
