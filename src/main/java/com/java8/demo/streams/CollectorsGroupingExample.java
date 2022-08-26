package com.java8.demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CollectorsGroupingExample {

	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		employeeList.add(new Employee(288, "Charu Sexana", 29, "Male", "Development", 2019, 57000.0));

		System.out.println("*** Increment Salary ***");
		List<Employee> incrementSalary=employeeList.stream().map(e -> {
			if(e.getAge() > 25) {
				e.setSalary(e.getSalary() * 1.10);
			}
			return e;
		}).collect(Collectors.toList());
		
		System.out.println("Increment Salary " + incrementSalary);
		

		// Print employee names group by gender exp and salary MultiLevelGrouping
		Map<String, Map<String, Map<String, List<String>>>> groupByGenderExpSalary = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,
						Collectors.groupingBy(CollectorsGroupingExample::groupByExp,
								Collectors.groupingBy(CollectorsGroupingExample::groupSalary,
										Collectors.mapping(Employee::getName, Collectors.toList())))));
		System.out.println(GSON.toJson(groupByGenderExpSalary));

	}

	private static String groupByExp(Employee k) {
		if (k.getYearOfJoining() > 2014) {
			return "Product Development";
		} else if (k.getYearOfJoining() >= 2018) {
			return "Infrastructure";
		} else {
			return "Software Engineer";
		}
	}

	private static String groupSalary(Employee k) {
		if (k.getSalary() >= 70000) {
			return "High Salary";
		} else if (k.getSalary() >= 50000) {
			return "Medium Salary";
		} else {
			return "Low Salary";
		}
	}
}