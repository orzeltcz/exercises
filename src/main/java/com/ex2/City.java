package com.ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

class DownsStreamCollectors {

    public static class City {
        private String name;
        private String state;
        private Integer population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Integer getPopulation() {
            return population;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }
    }

    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename)).map(l -> l.split(", ")).map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocalSet = locales.collect(groupingBy(Locale::getCountry, toSet()));
        System.out.println("countryset: " + countryToLocalSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String,Long> countryToLocaleCount = locales.collect(groupingBy(Locale::getCountry,counting()));
        System.out.println(countryToLocaleCount);

        Stream<City> cities = readCities("/home/orzel/Exercises/ex1/data/cities");
        Map<String, IntSummaryStatistics> stateToCityPopulation = cities.collect(groupingBy(City::getState,summarizingInt(City::getPopulation)));
        System.out.println(stateToCityPopulation);

       cities = readCities("/home/orzel/Exercises/ex1/data/cities");
       Map<String,Optional<String>> longestCityName = cities.collect(groupingBy(City::getState,mapping(
               City::getName,maxBy(Comparator.comparing(String::length)))));
       System.out.println("===============");
       System.out.println(longestCityName);




    }
}