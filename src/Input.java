import Data.Works;
import managers.CollectionManager;
import managers.CommandManagers;
import managers.FileManagers;
import managers.commands.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    private final CommandManagers commandManager;
    private final CollectionManager collectionManager;
    Scanner scanner = new Scanner(System.in);


    public Input(CommandManagers commandManager, CollectionManager colectionManager) {
        this.commandManager = commandManager;
        this.collectionManager = colectionManager;
    }

    public void listen() throws NoSuchElementException {
        while (true) {
            try {
                String CommandToSplit = (scanner.nextLine().trim() + " ").toLowerCase();
                String[] command = CommandToSplit.split(" ", 2);
                commandManager.execute(command[0], command[1]);
            } catch (NoSuchElementException e) {
                System.err.println("давайте не будем так делать");

            }
        }
    }

    public void addCommands(CommandManagers commandManager) {
        System.out.println("Введите команду 'help' для того, чтобы вывести все доступные команды.");
        commandManager.addCommand(new Help(this.collectionManager));
        commandManager.addCommand(new Show(this.collectionManager));
        commandManager.addCommand(new Info(this.collectionManager));
        commandManager.addCommand(new Add(this.collectionManager));
        commandManager.addCommand(new UpdateID(this.collectionManager));
        commandManager.addCommand(new RemoveByID(this.collectionManager));
        commandManager.addCommand(new Clear(this.collectionManager));
        commandManager.addCommand(new Save(this.collectionManager));
        commandManager.addCommand(new ExecuteScript(this.collectionManager, this.commandManager));
        commandManager.addCommand(new Exit());
        commandManager.addCommand(new RemoveFirst(this.collectionManager));
        commandManager.addCommand(new Reoder(this.collectionManager));
        commandManager.addCommand(new LessMinimalPoint(this.collectionManager));
        commandManager.addCommand(new BetterDifficulty(this.collectionManager));
        commandManager.addCommand(new PrintAuthor(this.collectionManager));
    }
    public void addData(){
        String filePath = System.getenv("FILE_PATH");
        Works works = FileManagers.readFile(filePath);
        if (works != null) {
            collectionManager.addToCollection(works.getLabWorks());
        }
    }
}