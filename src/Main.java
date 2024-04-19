import managers.CollectionManager;
import managers.CommandManagers;
public class Main {
    public static void main(String[] args) {
        System.out.println(System.getenv("FILE_PATH"));
        CommandManagers commandManager = new CommandManagers();
        CollectionManager collectionManager = new CollectionManager();
        Input input = new Input(commandManager, collectionManager);
        input.addCommands(commandManager);
        input.addData();
        input.listen();
    }
}