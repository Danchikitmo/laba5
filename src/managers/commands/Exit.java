package managers.commands;

public class Exit extends Command{
    public Exit(){
        super("exit");
    }

    @Override
    public void execute(String args){
        System.out.println("Завершение программы");
        System.exit(1);
    }
}
