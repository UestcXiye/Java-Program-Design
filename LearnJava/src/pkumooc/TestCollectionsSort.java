package pkumooc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuwenchen
 * @create 2020-07-09 22:30
 */
public class TestCollectionsSort {
    public static void main(String[] args) {
        List<Person> school= new ArrayList<>();
        school.add(new Person("Li", 23));
        school.add(new Person("Wang", 28));
        school.add(new Person("Sun", 22));
        school.add(new Person("Tang", 21));
        school.add(new Person("Chen", 18));
        school.add(new Person("Liu", 23));
        System.out.println(school);
        System.out.println();
        Collections.sort(school,new PersonComparator());
        System.out.println(school);
        System.out.println();
        int index=Collections.binarySearch(school, new Person("Li", 23),new PersonComparator());
        if(index>=0) {
            System.out.println("Found: " + school.get(index));
        } else {
            System.out.println("Not Found!");
        }
    }
    static class Person
    {
        String name;
        int age;

        Person(String name,int age)
        {
            this.name=name;
            this.age=age;
        }
        @Override
        public String toString()
        {
            return name+":"+age;
        }
    }

    static class PersonComparator implements Comparator {
        @Override
        public int compare(Object obj1, Object obj2)
        {
            Person p1=(Person)obj1;
            Person p2=(Person)obj2;
            if(p1.age>p2.age) {
                return 1;
            } else if(p1.age<p2.age) {
                return -1;
            }
            return p1.name.compareTo(p2.name);
        }
    }
}