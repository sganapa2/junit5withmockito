package org.junit.mockito;

import java.util.Arrays;

public class DatabaseService {

    public static void main(String[] args) {
        String str1 = "A";
        String str2 = "b";

        if (checkAnagram(str1, str2)) {
            System.out.println("Is Anagram");
        } else {
            System.out.println("Not");
        }
    }

    public String query(String queryString) {



        return "";
    }
        static boolean  checkAnagram(String str1, String str2){
            str1 = str1.replaceAll("\\s", "").toLowerCase();
            str2 = str2.replaceAll("\\s", "").toLowerCase();
            return  Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());

        }
        // DB call
        //return "Response data from DB - Query output";
    }

