package practice;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class practiceArray {
    public void stringArray() {
        String[] statesName = {" new york ", " new jersey ", " california ", " texas"};
        Arrays.sort(statesName, Collections.reverseOrder());
        System.out.println(Arrays.toString(statesName));
    }

    public void listArray() {
        List<String> lists = new ArrayList<>();

        lists.add("one");
        lists.add("two");
        lists.add("three");

        //      System.out.println(lists);
        //     for (String list : lists) ;
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("value of list is: " + lists.get(i));
        }
        lists.remove("two");
        lists.add("four");

        System.out.println(lists);
    }
    List<String> list;
   String[] array;

    public void practiceConvertArrayToList() {
        array = new String[]{"java", "Python", "php", "C++"};
        System.out.println("printing the Array:" + Arrays.toString(array));

        //converting Array to list
        list = new ArrayList<>();
        for(String language : array) {
            list.add(language);
        }
        System.out.println("printing list: " + list);

        list.add("Ruby");
        list.add("Visual basic");
        System.out.println("printing list after new languages: " + list);

    }
    public void practiceConvertListToArray() {
        array = list.toArray(new String[list.size()]);

        System.out.println("printing of array: " + Arrays.toString(array));

    }

}



