package com.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static java.util.Map.entry;
import java.util.Map;


public class CollectionFactoryMain {
    public static void main(String[] args) {
        demoFactoryLists();
        demoFactorySets();
        demoFactoryMaps();
        demoImmutabilityRules();
        demoCopyOf();
    }

    private static void demoFactoryLists() {
        // Empty list
        List<String> emptyList = List.of();

        // List with 1 or 2 elements
        List<String> yesNo = List.of("Yes", "No");

        // List with 3 or more elements
        List<String> frameworks = List.of("Spring", "Quarkus", "Micronaut");
        System.out.println("Empty list [instanceof: " + emptyList.getClass().getName() + "]: " + emptyList);
        System.out.println("List with 1 or 2 elements [instanceof: " + yesNo.getClass().getName() + "] : " + yesNo);
        System.out.println("List with elements [instanceof: " + frameworks.getClass().getName() + "] : " + frameworks);
    }

    private static void demoFactorySets() {
        // Empty set
        Set<String> emptySet = Set.of();
        // Set with elements
        Set<String> modeTransport = Set.of("Car", "Bike");
        Set<String> shapes = Set.of("Circle", "Square", "Rectangle");
        System.out.println("Empty set [instanceof: " + emptySet.getClass().getName() + "]: " + emptySet);
        System.out.println("Set with 1 or 2 elements [instanceof: " + modeTransport.getClass().getName() + "] : " + modeTransport);
        System.out.println("Set with elements [instanceof: " + shapes.getClass().getName() + "] : " + shapes);
    }

    private static void demoFactoryMaps() {
        // Empty map
        Map<String, String> emptyMap = Map.of();
        // Map with 1 element (java.util.ImmutableCollections$Map1)
        Map<String, String> availableDestinations = Map.of("Destination-1", "Delhi");

        // Map with 1 element (java.util.ImmutableCollections$MapN)
        Map<String, String> possibleDestinations = Map.of("Destination-1", "Delhi", "Destination-2", "Mumbai", "Destination-3", "Bangalore", "Destination-4", "Chennai");

        // Map with more than 1 elements (java.util.ImmutableCollections$MapN)
        Map<Integer, String> bankBranches = Map.ofEntries(
            entry(1, "London"),
            entry(2, "Bangalore"),
            entry(3, "New York"),
            entry(4, "Paris"),
            entry(5, "Tokyo"),
            entry(6, "Sydney"),
            entry(7, "Dubai"),
            entry(8, "Mumbai"),
            entry(9, "Chennai"),
            entry(10, "Berlin"),
            entry(11, "Austria")
        );

        System.out.println("Empty map [instanceof: " + emptyMap.getClass().getName() + "]: " + emptyMap);
        System.out.println("Map with 1 element [instanceof: " + availableDestinations.getClass().getName() + "] : " + availableDestinations);
        System.out.println("Map upto 10 elements [instanceof: " + possibleDestinations.getClass().getName() + "] : " + possibleDestinations);
        System.out.println("Map more than 10 elements [instanceof: " + bankBranches.getClass().getName() + "] : " + bankBranches);
    }

    private static void demoImmutabilityRules() {
        List<String> immutableList = List.of("A", "B");
        try {
            immutableList.add("C");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Immutable collection modification failed as expected: " + ex.getMessage());
        }
    }

    private static void demoCopyOf() {
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Apple");

        // Creates an unmodifiable snapshot copy
        List<String> unmodifiableCopy = List.copyOf(mutableList);
        System.out.println("Unmodifiable Copy [instanceof: " + unmodifiableCopy.getClass().getName() + "]: " + unmodifiableCopy);
    }


}
