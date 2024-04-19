package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Info extends Command implements CommandExecutor {
    private final CollectionManager colectionManager;
    public Info(CollectionManager colectionManager){
        super("info");
        this.colectionManager = colectionManager;
    }

    @Override
    public void execute(String args){
        colectionManager.getInfo();
    }
}
