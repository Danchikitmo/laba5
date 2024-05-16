package managers.commands;

import Data.LabWork;
import managers.CollectionManager;

import java.util.Comparator;
import java.util.Vector;

public class PrintAuthor extends Command implements LabWorkCommand {
    CollectionManager collectionManager;
    public PrintAuthor(CollectionManager collectionManager) {
        super("print_field_descending_author");
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String args){
        Vector<LabWork> labWorks = collectionManager.getLabWorks();
        labWorks.sort(Comparator.comparing(labWork -> labWork.getAuthor().getPassportID(), Comparator.reverseOrder()));
        for(LabWork labWork : labWorks){
            System.out.println(labWork);
        }
    }
}
