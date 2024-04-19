package managers.commands;

import builder.LabWorkBuilder;
import exceptions.InvalidDataException;
import interfaces.CommandExecutor;
import managers.CollectionManager;

public class Add extends Command implements CommandExecutor {
    private final CollectionManager collectionManager;
     public Add(CollectionManager collectionManager){
         super("add");
         this.collectionManager = collectionManager;
     }

     @Override
    public void execute(String args){
         try {
             collectionManager.add(new LabWorkBuilder().create());
             System.out.println("Человек успешно добавлен");
         } catch (InvalidDataException e){
             System.err.println("Что-то пошло не так");
         }
     }
}
