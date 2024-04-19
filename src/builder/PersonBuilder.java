package builder;

import Data.Person;


public class PersonBuilder extends Builder{

    public PersonBuilder(){

    }
    public Person create(){
        return new Person(
                new PersonNameBuilder().create(),
                stringBuilder("Введите дату рождения"),
                doubleBuilder("вес")
        );
    }
}
