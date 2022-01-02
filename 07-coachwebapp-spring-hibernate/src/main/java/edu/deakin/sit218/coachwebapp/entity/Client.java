package edu.deakin.sit218.coachwebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "client") // Just to be explicit
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;

//	@NotNull(message = "is required")
//	@Size(min = 1, message="is required") 
	@Pattern(regexp = "^[A-Z][a-z]*", message = "A name should start with a "
			+ "capital letter and be followed by lower case letters")
	@Column(name = "name")
	protected String name;

	@Min(value = 18, message = "You must be 18 years old or older")
	@Max(value = 120, message = "Vampires are not allowed")
	@Column(name = "age")
	protected int age;

	@Column(name = "workouts")
	protected int workouts = 0;

	public Client(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Client() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWorkouts() {
		return workouts;
	}

	public void setWorkouts(int workouts) {
		this.workouts = workouts;
	}
	
	@Override
	public String toString() {
		return "client = [name: "+getName()+", age: "+getAge()+
				", workouts: "+ getWorkouts()+"]";
	}

	public void addWorkout() {
		workouts++;
	}
}
