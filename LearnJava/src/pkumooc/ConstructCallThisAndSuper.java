package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-04 19:22
 */
public class ConstructCallThisAndSuper
{
    public static void main(String[] args){
        Person p = new Graduate();
    }
}

class Person
{
    String name;
    int age;
    Person(){}
    Person( String name, int age ){
        this.name=name; this.age=age;
        System.out.println("In Person(String,int)");
    }
}

class Student extends Person
{
    String school;
    Student(){
        this( null, 0, null );
        System.out.println("In Student()");
    }
    Student( String name, int age, String school ){
        super( name, age );
        this.school = school;
        System.out.println("In Student(String,int,String)");
    }
}

class Graduate extends Student
{
    String teacher="";
    Graduate(){
        //super(); compiler will load this default method  automatically if we don't.
        System.out.println("In Graduate()");
    }
}