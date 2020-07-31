import java.util.*;
class streamList {
   public static void main(String... args) {
	Collection<Person> people = Arrays.asList(
      new Person("Ted", 18, 88),
      new Person("Charlotte", 18, 88),
      new Person("Michael", 18, 99),
      new Person("Matthew", 19, 84),
      new Person("Matthew", 21, 84)
   );

	Object result = 
	people.parallelStream()
		.filter( p -> p.age<20 )
		.sorted( (p1,p2)->p1.age-p2.age)
		.sorted( Person::better)
		.sorted( Comparator.comparing( Person::getName ) )
		.limit(5)
		.mapToDouble( p -> p.score )
		.average();
    System.out.println(result);
  } 
} 

class Person
{
	public String name;
	public int age;
	public double score;

	public Person(String n, int a, double s) {
		name = n; age = a; score = s;
	}
	public String getName(){ return name;}
	@Override
	public String toString() {
		return String.format("%s[%d](%f)", name,age,score);
	}
	public static int better(Person p1, Person p2) {
		return (int)(p2.score - p1.score);
	}
}
