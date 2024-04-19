package managers.commands;

import exceptions.EmptyCollectionException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Show extends Command implements CommandExecutor {
    CollectionManager colectionManager;

    public Show(CollectionManager colectionManager){
        super("show");
        this.colectionManager = colectionManager;
    }

    @Override
    public void execute(String args){
        try {
            colectionManager.show();
        } catch (EmptyCollectionException e){
            System.err.println("В коллекции ничего нет");
        }
    }
}
