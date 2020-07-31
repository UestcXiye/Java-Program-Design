package pkumooc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuwenchen
 * @create 2020-07-09 22:57
 */
public class TestCollectionsSortByLambda {
    public static void main(String[] args) {
        List<Person> school= new ArrayList<>();
        school.add(new Person("Li", 23));
        school.add(new Person("Wang", 28));
        school.add(new Person("Sun", 22));
        school.add(new Person("Tang", 21));
        school.add(new Person("Chen", 18));
        school.add(new Person("Liu", 27));
        System.out.println(school);
        System.out.println();
        Collections.sort(school,(p1,p2)->p1.age-p2.age);
        System.out.println(school);
        System.out.println();
        int index=Collections.binarySearch(school, new Person("Li", 23),(p1,p2)->p1.age-p2.age);
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
}