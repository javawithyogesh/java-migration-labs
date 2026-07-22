---
layout: default
title: Java Records
nav_order: 1
---

# Java Records

Records provide a concise way to model immutable data carriers. The compiler generates the constructor, accessors, `equals()`, `hashCode()`, and `toString()` methods from the record components.

## Before (Java 8)

Before records, a small data carrier required a class with explicit fields, a constructor, getters, setters, and value-based methods:

```java
import java.util.Objects;

public final class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Person)) {
			return false;
		}
		Person person = (Person) other;
		return age == person.age && Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
```

This approach is verbose and exposes mutable state through its setters. Every new field also requires updates to several methods.

## After (Modern Java)

The same data carrier can be expressed as a record:

```java
public record RecordsDemo(String name, int age) {
}
```

The generated accessors use the component names, so callers write `person.name()` and `person.age()` instead of JavaBean-style getters. Records also provide value-based `equals()`, `hashCode()`, and a readable `toString()` implementation automatically.

## Immutability

Record components are final, and a record does not provide setters. Once a record is constructed, its component references cannot be reassigned. This gives records shallow immutability: a referenced mutable object, such as a list, can still be changed unless the constructor makes a defensive copy.
