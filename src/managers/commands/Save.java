package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Save extends Command implements CommandExecutor {
    CollectionManager collectionManager;

    public Save(CollectionManager collectionManager){
        super("save");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args){
        collectionManager.save();
    }
}