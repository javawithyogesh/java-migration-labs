---
layout: default
title: Local Variable Type Inference with var
nav_order: 2
---

# Local Variable Type Inference with `var`

Java 10 introduced local variable type inference with the `var` keyword. The compiler still assigns a specific, static type; `var` only removes the need to repeat a type that is clear from the initializer.

## Before (Explicit Types)

Before `var`, every local variable declaration repeated its type:

```java
String language = "Java";
int version = 25;
ArrayList<String> migrationTopics = new ArrayList<>();
migrationTopics.add("records");
migrationTopics.add("var");
migrationTopics.add("virtual threads");
```

The explicit type can be useful, but repeating a long generic type makes declarations noisy.

## After (Modern Java)

With `var`, the compiler infers the local variable type from the initializer:

```java
var language = "Java";
var version = 25;
var migrationTopics = new ArrayList<>(List.of("records", "var", "virtual threads"));
```

The variables remain statically typed. For example, `version` is still an `int`, and `migrationTopics` is still an `ArrayList<String>`; neither variable can later hold an unrelated type.

## Where `var` Works

`var` is limited to local variables with initializers. It can be used for local variables, loop variables, and resources in try-with-resources:

```java
for (var topic : migrationTopics) {
    System.out.println(topic);
}
```

It cannot be used for fields, method parameters, method return types, or uninitialized variables:

```java
// These declarations are invalid:
// private var topic;
// void migrate(var topic) { }
// var topic;
```

Use `var` when the initializer makes the type obvious. Keep an explicit type when inference would hide an important abstraction or make the code harder to understand.
