package edu.bit.datastructures.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Map<String, String> friendToPhone = new HashMap<>();
        for (int tItr = 0; tItr < t; tItr++) {
            String name = scanner.next();
            String phone = scanner.next();
            friendToPhone.put(name, phone);
        }

        while (scanner.hasNext()) {
            String q = scanner.next();
            if (friendToPhone.containsKey(q)) {
                System.out.println(q + "=" + friendToPhone.get(q));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
