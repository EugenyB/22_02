package main;

import entities.Employee;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    new Main().run4();
    }

//    private void run() {
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get("file.txt"))) {
//            reader.lines()
//                    .flatMapToInt(s->s.chars())
////                    .count() // кол-во символов
//                    .collect(Collectors.groupin
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void run4() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("file.txt"))){
//            String line;
//            while((line=reader.readLine())!=null) {
//                System.out.println(line);
//            }
//            reader.lines().forEach(System.out::println); // Вывести все строки
//            System.out.println(reader.lines().count()); // Кол-во строк
                // Длина самой большой строки
//            OptionalInt max = reader.lines().mapToInt(s -> s.length()).max();
//            if (max.isPresent()) {
//                System.out.println(max.getAsInt());
//            } else {
//                System.out.println("???");
//            }
            Optional<String> first = reader.lines()
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .findFirst();
//            Optional<String> first = reader.lines()
//                    .max(Comparator.comparingInt(String::length));
            if (first.isPresent()) {
                System.out.println(first.get() + " " + first.get().length());
            } else {
                System.out.println("???");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run3() {
        List<Employee> employees = new ArrayList<>(createEmployees());
        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getLocation));
        Map<Boolean, List<Employee>> mapBySex = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSex() == 'm'));
//        for (Employee employee : employees) {
//            String location = employee.getLocation();
//            if (map.containsKey(location)) {
//                map.get(location).add(employee);
//            } else {
//                map.put(location, new ArrayList<>(Arrays.asList(employee)));
//            }
//        }
        map.forEach((k,v)->System.out.println(k + " : " + v));
        mapBySex.forEach((k,v)->System.out.println((k?"m":"f") + ">>>" + v));
    }

    private void run2() {
        List<Employee> employees = new ArrayList<>(createEmployees());
        double sum = employees.stream()
                .filter(e->e.getSex()=='m')
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("sum = " + sum);
        List<Employee> men = employees.stream()
                .filter(employee -> employee.getSex() == 'm')
                .collect(Collectors.toList());
        print(men);
    }

    private void run1() {
        List<Employee> employees = new ArrayList<>(createEmployees());
        print(employees);
        System.out.println("----------------------");
//        List<String> list = employees.stream()
//                .map(x -> x.getName())
//                .collect(Collectors.toList());
//        print(list);
//        List<Integer> list1 = employees.stream()
//                .map(x -> x.getAge())
//                .collect(Collectors.toList());
//        print(list1);
        List<Employee> list = employees.stream()
                .filter(x -> "Nikolaev".equals(x.getLocation()))
//                .filter(x -> x.getSex()=='m')
                .sorted(Comparator.comparing((Employee e)->e.getAge()).thenComparing(Employee::getAge))
                .collect(Collectors.toList());
        print(list);
    }

    private void print(Collection<?> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    private List<Employee> createEmployees() {
        return List.of(
                    new Employee(1, "Іванов", 25, 1234, 'm', "Nikolaev"),
                    new Employee(2, "Петренко", 30, 2531, 'f', "New York"),
                    new Employee(3, "Ковальов", 24, 1521.6, 'm', "Kherson"),
                    new Employee(4, "Сидорова", 45, 3421.5, 'f', "Nikolaev"),
                    new Employee(11, "Сидорова", 40, 3421.5, 'f', "Nikolaev"),
                    new Employee(5, "Котовский", 27, 2300, 'm', "Kiev"),
                    new Employee(6, "Алексеева", 21, 1000, 'f', "Odessa"),
                    new Employee(7, "Александров", 19, 500.7, 'm', "Nikolaev"),
                    new Employee(8, "Гаврилюк", 38, 1732.1, 'm', "Odessa"),
                    new Employee(9, "Козлов", 51, 1256.5, 'm', "Kherson"),
                    new Employee(10, "Корова", 29, 1500, 'f', "Kiev")
            );
    }
}
