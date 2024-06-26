package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Clear extends Command implements CommandExecutor {
    CollectionManager collectionManager;
    public Clear(CollectionManager collectionManager){
        super("clear");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args){
        collectionManager.clear();
    }
}
