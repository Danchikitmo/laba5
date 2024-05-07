package managers.commands;

import exceptions.EmptyCollectionException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Reoder extends  Command implements CommandExecutor {
    CollectionManager collectionManager;

    public Reoder(CollectionManager collectionManager) {
        super("reoder");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args){
        try {
            collectionManager.reoder();
        } catch (EmptyCollectionException e){
            System.err.println("Коллекция пуста, перемешать не получиться");
        }
    }
}
