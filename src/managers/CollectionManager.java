package managers;

//import Data.Comparator.LabWorkComparator;
import Data.LabWork;
import builder.LabWorkBuilder;
import exceptions.EmptyCollectionException;
import exceptions.InvalidDataException;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class CollectionManager {
    private final LocalDate localDate;

    public CollectionManager(){
        localDate = LocalDate.parse(LocalDate.now().toString());
    }

    private final Vector<LabWork> MyCollection = new Vector<>();

    public boolean idIdentifier(LabWork labWork){
        for(LabWork value: MyCollection){
            if(labWork.getId() == value.getId()){
                return false;
            }
        }
        return true;
    }

    public void help(){
        System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                insert_at index {element} : добавить новый элемент в заданную позицию
                remove_first : удалить первый элемент из коллекции
                reorder : отсортировать коллекцию в порядке, обратном нынешнему
                count_less_than_minimal_point minimalPoint : вывести количество элементов, значение поля minimalPoint которых меньше заданного
                filter_greater_than_difficulty difficulty : вывести элементы, значение поля difficulty которых больше заданного
                print_field_descending_author : вывести значения поля author всех элементов в порядке убывания""");
    }

    public LabWork getPersonById(Integer id){
        for(LabWork labWork: MyCollection){
            if(id == labWork.getId()){
                return labWork;
            }
        }
        return null;
    }

    public void add(LabWork labWork) throws InvalidDataException{
        if(!(labWork.validated())) {
            System.out.println("125");
            throw new InvalidDataException();
        }
        if(idIdentifier(labWork)){
            System.out.println("123");
            System.out.println(labWork.generateID());
            labWork.setId(labWork.generateID());
        }
        MyCollection.add(labWork);
    }

    public void updateID(Integer id) throws InvalidDataException, NoSuchElementException{
        LabWork oldPerson = getPersonById(id);
        if(oldPerson == null){
            throw new NoSuchElementException("Такого человека нет в коллекции");
        }
        MyCollection.remove(oldPerson);
        LabWorkBuilder LabWork = new LabWorkBuilder();
        LabWork newLabWork = LabWork.create();
        newLabWork.setId(id);
        MyCollection.add(newLabWork);
    }

    public void show() throws EmptyCollectionException{
        Collections.sort(MyCollection);
        if(!MyCollection.isEmpty()){
            System.out.println("Содержимое коллекции:");
            for(LabWork i: MyCollection){
                System.out.println(i);
            }
        } else {
            throw new EmptyCollectionException();
        }
    }

    public void getInfo(){
        System.out.println("Сохраняемый тип данных: " + LabWork.class + ", количество работ: " + MyCollection.size() + ", дата инициализации: " + localDate);
    }

    public void reoder() throws EmptyCollectionException{
        if(MyCollection.isEmpty()) throw new EmptyCollectionException();
        Collections.shuffle(MyCollection);
        System.out.println("Коллекция перемешалась");
    }

    public void showData(Function<LabWork, Integer> mapper, boolean reversed) throws EmptyCollectionException{
        List<Integer> data = new ArrayList<>(MyCollection.size());
        for(LabWork labWork: MyCollection){
            data.add(mapper.apply(labWork));
        }
        if(!reversed){
            Collections.sort(data);
        } else {
            data.sort(Collections.reverseOrder());
        }
        System.out.println(data);
    }

    public void clear() {
        if(MyCollection.isEmpty()){
            System.out.println("Коллекция и так пуста");
        } else {
            MyCollection.clear();
            System.out.println("Коллекция очищена");
        }
    }

    public void save(){
        try {
            if(MyCollection.isEmpty()){
                System.out.println("Ваша коллекция пуста, если вы сохраните, то ваша прошлая коллекция исчезнет. Точно ли вы этого хотите?");
                System.out.println("y/n");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if (answer.equals("y")){
                    FileManagers.clearFile();
                    System.out.println("Сохранение перезаписано");
                } else if (answer.equals("n")) {
                    String filePath = System.getenv("FILE_PATH");
                    MyCollection.addAll(FileManagers.readFile(filePath).getLabWorks());
                    System.out.println("Сохранение восстановлено");
                    return;
                } else {
                    System.out.println("Нет такого варианта ответа");
                }
            } else {
                FileManagers.writeFile(MyCollection);
            }
        } catch (NullPointerException e){
            System.out.println("Что-то пошло не так, попробуйте снова");
        }
    }

    public boolean checkId(Vector<LabWork> labWorks){
        HashSet<Integer> idCollection = new HashSet<>();
        if(labWorks.size() != 1){
            for (LabWork labWork: labWorks){
                if(!idCollection.contains(labWork.getId())){
                    System.out.println("pidr");
                    idCollection.add(labWork.getId());
                } else {
                    System.out.println("lox");
                    return false;
                }
            }
        }
        return true;
    }

    public void addToCollection(Vector<LabWork> labWorks){
        if(checkId(labWorks)){
            System.out.println(labWorks);
            MyCollection.addAll(labWorks);
        } else {
            System.out.println(labWorks);
            System.err.println("Что-то не так с файлом, данные не подгрузились");
        }
    }

    public void addIfMax(Integer id){
        Collections.sort(MyCollection);
        if(MyCollection.get(MyCollection.size() - 1).getId() < id){
            LabWorkBuilder newLabWork = new LabWorkBuilder();
            LabWork labWork = newLabWork.create();
            labWork.setId(id);
            MyCollection.add(labWork);
        } else {
            System.err.println("Элемент меньше максимального");
        }
    }

    public static Scanner reader;
    public void executeScript(String filePath, CommandManagers commandManager) {
        try (Scanner scriptScanner = new Scanner(new File(filePath))) {
            reader = scriptScanner;
            while (scriptScanner.hasNextLine()) {
                String commandToSplit = (scriptScanner.nextLine().trim() + " ").toLowerCase();
                String[] commandParts = commandToSplit.split(" ", 2);
                String commandName = commandParts[0];
                String args = (commandParts.length > 1) ? commandParts[1] : "";
                commandManager.execute(commandName, args);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл скрипта не найден: " + filePath);
        } catch (NoSuchElementException e) {
            System.err.println("Ошибка чтения файла скрипта: " + filePath);
        } catch (IllegalStateException e){
            System.out.println("Чиним программу, можете продолжать дальше");
        }
    }


}
