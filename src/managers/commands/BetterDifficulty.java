package managers.commands;

import interfaces.CommandExecutor;
import managers.CollectionManager;

import java.util.NoSuchElementException;

public class BetterDifficulty extends Command implements CommandExecutor {
    CollectionManager collectionManager;

    public BetterDifficulty(CollectionManager collectionManager) {
        super("filter_greater_than_difficulty");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args){
        try {
            Integer difficulty = Integer.parseInt(args.trim());
            collectionManager.getWorksDifficulty(difficulty);

        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
