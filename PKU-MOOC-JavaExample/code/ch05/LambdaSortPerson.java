import java.util.*;
class Person
{
	public String name;
	public int age;
	public double score;

	public Person(String n, int a, double s) {
		name = n; age = a; score = s;
	}

	public String getName(){ return name;}

	public String toString() {
		return String.format("%s[%d](%f)", name,age,score);
	}

	public static int better(Person p1, Person p2) {
		return (int)(p2.score - p1.score);
	}


}
class LambdaSortPerson {

   public static void main(String... args) {
    Person[] people = new Person[] {
      new Person("Ted", 18, 91),
      new Person("Charlotte", 19, 88),
      new Person("Michael", 20, 99),
      new Person("Matthew", 21, 84)
    };

	Comparator<Person> compareAge =
		(p1, p2) -> p1.age-p2.age;
	Arrays.sort(people, compareAge);

	Arrays.sort(people, 
		(p1, p2) -> p1.age-p2.age);
	Arrays.sort(people, 
		(p1, p2) -> (int)(p1.score-p2.score));
	Arrays.sort(people, 
		(p1, p2) -> p1.name.compareTo(p2.name));
	Arrays.sort(people, 
		(p1, p2) -> -p1.name.compareToIgnoreCase(p2.name));


	Comparator<Person> cf =  Person::better; 
    Arrays.sort(people, cf);
    Arrays.sort(people, Person::better);
    
	Arrays.sort(people,  Comparator.comparing(
		Person::getName));
	
	for (Person p : people)
      System.out.println(p);

  } 
} 
