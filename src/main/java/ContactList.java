import java.util.*;

public class ContactList {
    private final Map<String, List<String>> contacts = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        contacts.computeIfAbsent(lastName, key -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return contacts.getOrDefault(lastName, Collections.emptyList());
    }
}
