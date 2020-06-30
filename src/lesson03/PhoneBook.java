
package lesson03;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    HashMap<String, HashSet<String>> phoneBook;
    HashSet<String> empty = new HashSet<>();

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new HashSet<>());
        }
        phoneBook.get(name).add(phoneNumber);
    }

    public HashSet<String> get(String name) {
        return phoneBook.getOrDefault(name, empty);
    }

    public void info() {
        phoneBook.forEach((k, v)-> System.out.println(k + ": " + phoneBook.get(k)));
    }

    public void request(String name) {
        System.out.println("Информация по запросу: " + name + ": " + phoneBook.get(name));
    }
}










