import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        //  List<Integer> age = Arrays.asList(15, 55, 45, 36, 19, 18, 27);
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //список несовершеннолетних
        long minor = persons.stream().filter(person -> person.getAge() < 18).count();
        System.out.println("\nВ списке " + minor + " несовершеннолетний(х).");

        //список фамилий призывников(т.е. мужчин от 18 и до 27 лет)
        List<String> recruit = persons.stream().filter(person -> (person.getAge() >= 18 && person.getAge() <= 27))
                .filter(person -> person.getSex() == Sex.MAN).map(Person::getFamily)
                .collect(Collectors.toList());
        // System.out.println("\nСписок призвников: " + recruit);

        //список потенциально трудоспособных с высшим образованием (М:18-65 лет, Ж:18-60 лет)


    }
}
