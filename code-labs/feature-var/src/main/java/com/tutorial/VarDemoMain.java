package com.tutorial;

import java.util.ArrayList;
import java.util.List;

public class VarDemoMain {
    public static void main(String[] args) {
        var language = "Java";
        var version = 25;
        var migrationTopics = new ArrayList<>(List.of("records", "var", "virtual threads"));

        System.out.println("Language: " + language);
        System.out.println("Version: " + version);
        System.out.println("Migration topics: " + migrationTopics);
        System.out.println("Inferred list type: " + migrationTopics.getClass().getSimpleName());
    }
}
