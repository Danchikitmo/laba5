package managers.commands;

import managers.CollectionManager;
import managers.CommandManagers;

import java.util.NoSuchElementException;

public class ExecuteScript extends Command {
    private final CollectionManager colectionManager;
    private final CommandManagers commandManagers;
    public  static  boolean isFromFile = false;

    public ExecuteScript(CollectionManager colectionManager, CommandManagers commandManagers){
        super("execute_script");
        this.colectionManager = colectionManager;
        this.commandManagers = commandManagers;
    }

    @Override
    public void execute(String args){
        isFromFile = true;
        if(args.trim().isEmpty()){
            throw new NoSuchElementException("Идентификатор не указан");
        }
        String filePath = System.getenv("FILE_PATH") + args.trim();
        colectionManager.executeScript(filePath, commandManagers);
    }
}