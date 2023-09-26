
/* 
Problem Statement: Implement a Phone Book
Write a Java program to implement a phone book using an ArrayList and a LinkedList. The phone book should allow users to add, delete, and search for contacts by name or phone number.

To solve this problem, you can create a Contact class that stores the name and phone number of each contact. You can then use an ArrayList to store the contacts and a LinkedList to store the indices of the contacts sorted by name.
---------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return name;
    }
}

class PhoneBook {
    List<Contact> contacts;
    LinkedList<Integer> sortedIndices;

    public PhoneBook() {
        contacts = new ArrayList<>();
        sortedIndices = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        sortedIndices.add(findInsertionIndex(contact.getName()), contacts.size() - 1);
    }

    public void deleteContact(Contact contact) {
        int index = contacts.indexOf(contact);
        if (index != -1) {
            contacts.remove(contact);
            sortedIndices.remove(index);
        }
        System.out.println(contacts);
        System.out.println(sortedIndices);
    }

    public void searchByName(String name) {
        Iterator itr = contacts.iterator();
        int bool = 0;
        while (itr.hasNext()) {
            Contact c = (Contact) itr.next();
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Found   " + c.getPhoneNumber());
                bool = 1;
                break;

            }
        }

        if (bool == 0) {
            System.out.println("Contact does not exist");

        }

    }

    public Contact searchByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    private int findInsertionIndex(String name) {
        int index = 0;
        for (Integer sortedIndex : sortedIndices) {
            if (name.compareToIgnoreCase(contacts.get(sortedIndex).getName()) > 0) {
                index++;
            } else {
                break;
            }
        }
        return index;
    }
}

class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Adding contacts
        Contact contact1 = new Contact("Tapu", "1234567890");
        Contact contact2 = new Contact("Sonu", "9876543210");
        Contact contact3 = new Contact("Goli", "5678901234");
        phoneBook.addContact(contact1);
        phoneBook.addContact(contact2);
        phoneBook.addContact(contact3);

        // Searching contacts
        // System.out.println(phoneBook.searchByName("Sonu").getPhoneNumber());
        System.out.println(phoneBook.searchByPhoneNumber("5678901234").getName());

        // Deleting a contact
        phoneBook.deleteContact(contact2);

        // Searching contacts after deletion
        phoneBook.searchByName("Sonu");
        // System.out.println(phoneBook.searchByPhoneNumber("5678901234")); // Should
        // print Goli
    }
}
