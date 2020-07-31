import java.io.*;
class Person implements Serializable
{
    String name;
    int age;
    Person(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public String toString() {
        return name + "(" + age + ")";
    }
}
public class SerializeDemo {
    public static void main (String[] args)
    throws IOException
    {
        Person [] ps = {
            new Person("Li",18),
            new Person("Wang",19)
        };
		String fileName = "s.temp";
        //Serialize
		ObjectOutputStream output = new ObjectOutputStream(
            new FileOutputStream(fileName) );
        for(Person p : ps) output.writeObject(p);
        output.close();
        //deserialize
        ObjectInputStream input = new ObjectInputStream(
            new FileInputStream(fileName) );
        Person p = null;
        try {
            while( (p=(Person)input.readObject()) != null ) {
                System.out.println(p);
            }
        } catch(ClassNotFoundException ex) {}
        catch(EOFException eofex) {}
        input.close();
    }
}

