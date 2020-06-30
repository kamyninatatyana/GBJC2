package lesson03;

import java.util.*;

public class Main {

    static Map<String, String> phoneBookMap = new HashMap<>();

    public static void main(String[] args) {

        /* Задание 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
        вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько
        раз встречается каждое слово. */

        String[] wordsArr = {"яблоко", "ананас", "кокос", "банан", "апельсин", "мандарин", "яблоко", "нектарин",
                "персик", "ананас", "груша", "мандарин", "яблоко", "гранат", "мандарин", "яблоко", "мандарин",
                "кокос", "помело", "груша"};

        Set<String> set = new HashSet<String>(Arrays.asList(wordsArr));
        System.out.println("Задание 1. Список уникальных слов: \n" + set);
        System.out.println();

        Map<String, Integer> wordsCounter = new HashMap<>();

        for (int i = 0; i < wordsArr.length; i++) {
            Integer value = wordsCounter.getOrDefault(wordsArr[i], 0);
            wordsCounter.put(wordsArr[i], value + 1);

        }

        System.out.println("Задание 1: Считаем, сколько раз встречается каждое слово: \n" + wordsCounter);

        System.out.println();

        /*Задание 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
        телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,
        а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
        может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.*/


        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+7(921)911-11-11");
        phoneBook.add("Петров", "+7(921)911-11-12");
        phoneBook.add("Сидоров", "+7(921)911-11-13");
        phoneBook.add("Козлов", "+7(921)911-11-14");
        phoneBook.add("Васечкин", "+7(921)911-11-15");
        phoneBook.add("Пупкин", "+7(921)911-11-16");
        phoneBook.add("Михайлов", "+7(921)911-11-17");
        phoneBook.add("Иванов", "+7(921)911-11-18");
        phoneBook.add("Сидоров", "+7(921)911-11-19");
        phoneBook.add("Иванов", "+7(921)911-11-20");
        phoneBook.add("Пупкин", "+7(921)911-11-21");

        phoneBook.info();
        System.out.println();
        phoneBook.request("Иванов");


    }
}



