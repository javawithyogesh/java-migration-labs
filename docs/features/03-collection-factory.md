---
layout: default
title: Java Collection Factory Methods
nav_order: 2
---

# Java Collection Factory Methods

**Java 9** introduced collection factory methods such as `List.of()`, `Set.of()`, `Map.of()`, and `Map.ofEntries()` to make it easier to create small, fixed collections in a concise and readable way. These methods return __unmodifiable collections__ that are especially useful for constants, configuration values, and other data that should not change at runtime. **Java 10** later added `List.copyOf()` for creating an unmodifiable copy from an existing list.

## Before (manual construction)

Without factory methods, creating a small collection often required more boilerplate:

```java
List<String> frameworks = new ArrayList<>();
frameworks.add("Spring");
frameworks.add("Quarkus");
frameworks.add("Micronaut");
```

The same pattern also appears when creating sets and maps manually.

## After (factory methods)

The lab example demonstrates several convenient alternatives.

### Lists

```java
List<String> emptyList = List.of();
List<String> yesNo = List.of("Yes", "No");
List<String> frameworks = List.of("Spring", "Quarkus", "Micronaut");
```

### Sets

```java
Set<String> emptySet = Set.of();
Set<String> transports = Set.of("Car", "Bike");
Set<String> shapes = Set.of("Circle", "Square", "Rectangle");
```

### Maps

```java
Map<String, String> emptyMap = Map.of();
Map<String, String> destinations = Map.of("Destination-1", "Delhi");

Map<String, String> routes = Map.of(
    "Destination-1", "Delhi",
    "Destination-2", "Mumbai",
    "Destination-3", "Bangalore",
    "Destination-4", "Chennai"
);
```

For larger fixed maps, `Map.ofEntries()` is a clearer option:

```java
Map<Integer, String> branches = Map.ofEntries(
    entry(1, "London"),
    entry(2, "Bangalore"),
    entry(3, "New York"),
    entry(4, "Paris"),
    entry(5, "Tokyo")
);
```

## Important rules

These factory methods follow a few important rules:

- The returned collections are unmodifiable. Calling `add()`, `remove()`, or `clear()` throws `UnsupportedOperationException`.
- `null` values are not allowed as elements, keys, or values. Passing `null` causes a `NullPointerException`.
- Duplicate elements in `Set.of()` or duplicate keys in `Map.of()` cause an `IllegalArgumentException`.
- The collections are only shallowly immutable. The elements themselves can still be mutable objects.
- The concrete runtime classes are implementation details, so code should not depend on their exact type.

The sample code also demonstrates this behavior by trying to add an element to an immutable list and showing that the operation fails.

## Creating an unmodifiable copy from an existing collection

Java 10 added `List.copyOf()`, which creates an unmodifiable snapshot of an existing list:

```java
List<String> mutableList = new ArrayList<>();
mutableList.add("Apple");

List<String> unmodifiableCopy = List.copyOf(mutableList);
```

This is useful when you want to preserve a fixed view of data without allowing later modifications to the copy.

## Summary

Collection factory methods help make code shorter and more expressive for fixed data. They improve readability while also enforcing immutability and safer initialization patterns.

