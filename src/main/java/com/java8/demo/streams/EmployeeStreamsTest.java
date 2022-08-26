package com.java8.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EmployeeStreamsTest {
	
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
		
		/*Question 1.1:Print all the employee names whose salary is greater than 10000*/
		List<String> employeeFilteredList = employeeList.stream().filter(e -> e.getSalary()>10000).map(Employee::getName).collect(Collectors.toList());
		employeeFilteredList.forEach((name)->System.out.println("Employee names whose salary is greater than 10000 - " + name));
		
		/* Question 1.2:How many male and female employees are there in the organization */		
		Map<String, Long> noofMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("No of Male and Female Employees are : " + noofMaleAndFemaleEmployees);

		/* Question 1.3:Print the name of all departments in the organization */
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
		/*Question 1.4:What is the average age of male and female employees*/		
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("Avarage Age Of Male and Female employees : " + avgAgeOfMaleAndFemaleEmployees);
		
		/* Question 1.5:Get the details of highest paid employee in the organization */
		Optional<Employee> getHighestPaidEmployer = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		Employee highPaidEmployee = getHighestPaidEmployer.get();
		System.out.println("Details of Highest Paid Employee");
		System.out.println("Name : " + highPaidEmployee.getName());
		System.out.println("Salary : " + highPaidEmployee.getSalary());
		System.out.println("Department : " + highPaidEmployee.getDepartment());

		/*Question 1.6:Get the names of all employees who have joined after 2015*/		
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		
		/*Question 1.7:Count the number of employees in each department*/			
		Map<String,Long> employeeCountByDept=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		Set<Entry<String,Long>> entrySet=employeeCountByDept.entrySet();
		for(Entry<String,Long> entry : entrySet) {
			System.out.println("Count the number of employees in each department " + entry.getKey() + " : " + entry.getValue());
		}
		
		/*Question 1.8:What is the average salary of each department*/		
		Map<String,Double>avgSalaryOfDepts=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		Set<Entry<String,Double>> avgEntrySet=avgSalaryOfDepts.entrySet();
		for(Entry<String,Double> entry: avgEntrySet) {
			System.out.println("Average salary of each department " + entry.getKey() + " : " + entry.getValue());
			
		}
		
		/*Question 1.9:Get the details of youngest male employee in the product development department*/
		System.out.println("***********************************************");
		Optional<Employee> youngestMaleEmployeeInProductDevelopment=
				employeeList.stream().filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development").min(Comparator.comparingInt(Employee::getAge));
		Employee youngMaleProductDevelopment=youngestMaleEmployeeInProductDevelopment.get();		
		System.out.println("Details Of Youngest Male Employee In Product Development");
		System.out.println("Name : " + youngMaleProductDevelopment.getName());
		System.out.println("Salary : " + youngMaleProductDevelopment.getSalary());
		System.out.println("Department : " + youngMaleProductDevelopment.getDepartment());
		System.out.println("Age : " + youngMaleProductDevelopment.getAge());		
		System.out.println("***********************************************");
		
		/*Question 1.10: Who has the most working experience in the organization*/		
		Optional<Employee> seniorMostEmployee=employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		Employee seniorEmployee=seniorMostEmployee.get();
		System.out.println("Details Of Senior Most Employee");
		System.out.println("Name : " + seniorEmployee.getName());
		System.out.println("Salary : " + seniorEmployee.getSalary());
		System.out.println("Department : " + seniorEmployee.getDepartment());
		
		/*Question 1.11:How many male and female employees are there in the sales and marketing team*/		
		Map<String,Long> countMaleAndFemaleInSalesMarketing=employeeList.stream().filter(e -> e.getDepartment()=="Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("Count Of Male & Female In Sales Marketing : " + countMaleAndFemaleInSalesMarketing);
		
		/*Question 1.12:What is the average salary of male and female employees*/		
		Map<String,Double> avgSalaryOfMaleAndFemale=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average Salary Of Male And Female Employees : " + avgSalaryOfMaleAndFemale);
		
		/*Question 1.13:List down the names of all employees in each department*/		
		Map<String, List<Employee>> employeeListByDepts = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> empListEntrySet = employeeListByDepts.entrySet();
		for (Entry<String, List<Employee>> entry : empListEntrySet) {
			System.out.println("--------------------------------------");
			System.out.println("Employee In : " + entry.getKey() + " : ");
			System.out.println("--------------------------------------");
			List<Employee> list = entry.getValue();
			for (Employee emp : list) {
				System.out.println(emp.getName());
			}
		}
		
		/*Question 1.14:What is the average salary and total salary of the whole organization*/		
		DoubleSummaryStatistics employeeStatistics=employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Avarage Salary : " + employeeStatistics.getAverage());
		System.out.println("Total Salary : " + employeeStatistics.getSum());
		
		/*Question 1.15:Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.*/		
		Map<Boolean,List<Employee>>partitionEmployeeByAge=employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge()>25));
		Set<Entry<Boolean,List<Employee>>> partitionEntrySet=partitionEmployeeByAge.entrySet();
		for(Entry<Boolean,List<Employee>> ageEntrySet:partitionEntrySet) {
			System.out.println("----------------------------------------");
			if(ageEntrySet.getKey()) {
				System.out.println("Employees older than 25 years");
			}else {
				System.out.println("Employees younger than or equals to 25 years");
			}
			System.out.println("----------------------------------------");
			List<Employee> partitionempList=ageEntrySet.getValue();
			for(Employee emp:partitionempList) {
				System.out.println(emp.getName());
			}	
		}
		
		/*Question 1.16:Who is the oldest employee in the organization? What is his age and which department he belongs to*/		
		Optional<Employee> oldestEmployee=employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		Employee oldEmployee=oldestEmployee.get();
		System.out.println("Details Of Oldest Employee");
		System.out.println("Name : " + oldEmployee.getName());
		System.out.println("Age : " + oldEmployee.getAge());
		System.out.println("Salary :" + oldEmployee.getSalary());
		System.out.println("Department : " + oldEmployee.getDepartment());
		
		 /*Question 1.17:Given the list of employees, count number of employees with age 25*/
		long count=employeeList.stream().filter(e->e.getAge()>25).count();
		System.out.println("Number of employees with age 25 are : " + count);
		 
		/*Question 1.18:Given the list of employees, find the employee with name “Charu Sexana”*/
		Optional<Employee>employeeWithName=employeeList.stream().filter(e->e.getName().equalsIgnoreCase("Charu Sexana")).findAny();
		if(employeeWithName.isPresent()) {
			System.out.println(employeeWithName.get());
		}
		
		/*Question 1.19:Given a list of employee, find maximum age of employee*/
		OptionalInt max=employeeList.stream().mapToInt(Employee::getAge).max();
		if(max.isPresent()) {
			System.out.println("Maxium age of employee : " + max.getAsInt());
		}
		
		/*Question 1.20:Given a list of employees, sort all the employee on the basis of age*/
		employeeList.sort((e1,e2)->e1.getAge()-e2.getAge());
		employeeList.forEach(System.out::println);
		
		/*Question 1.21:Join the all employee names with “, or |” using java 8*/
		List<String> employeeNames=employeeList.stream().map(Employee::getName).collect(Collectors.toList());
		String employeeNameStr=String.join("|", employeeNames);
		System.out.println("Employee are " + employeeNameStr);
		
		/*Question 1.22:Given the list of numbers, remove the duplicate elements from the list.*/
		Integer[] intarray=new Integer[] {1,2,3,4,3,2,4,2};
		List<Integer> listWithDuplicates=Arrays.asList(intarray);
		//Set<Integer> setWithoutDups=listWithDuplicates.stream().collect(Collectors.toSet());
		                                /*--OR--*/
		List<Integer> setWithoutDups=listWithDuplicates.stream().distinct().collect(Collectors.toList());
		setWithoutDups.forEach((i)->System.out.println("List of numbers : " + i));
		
		/*Question 1.23:Can you print employee details through lambda expressions*/
		/*employeeList.forEach(employee->{
			System.out.println("Name " + employee.getName());
			System.out.println("Salary " + employee.getSalary());
		});*/
		
		/*Question 1.24:Can you show all employees from the list having age greater than 30 with java 8*/
		employeeList.stream().filter(emp->emp.getAge()>30).forEach(emp->{System.out.println(emp);});
		
		/*Question 1.25:Count no of all employees form the list having age greater than 30 with java 8*/
		long empCount=employeeList.stream().filter(emp->emp.getAge()>30).count();
		System.out.println("Employees count : " + empCount);
		
		/*Question 1.26:Group all employees from the list with similar names and greater than 30 in java 8*/
		Map<Object, List<Employee>> empList=employeeList.stream().filter(emp->emp.getAge()>30).collect(Collectors.groupingBy(emp->emp.getName()));
		System.out.println(empList);
		
		employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
		.limit(3).map(Employee::getName).forEach(System.out::println);
		
		/*Question:1.27:Count employees in each departments*/
		Map<String,Long>deptCount=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println("Dept Count: " + deptCount);
		
		employeeList.stream().filter(employee->employee.getSalary()==57000).forEach(employee->System.out.println(employee.getName()));
		
		//Question:1.28:Using Collectors's method to sum the salaries.  		
		double totalSalaries=employeeList.stream().collect(Collectors.summingDouble(employee->employee.getSalary()));
		System.out.println("Total employees salaries : " + totalSalaries);
		
		// Question:1.29:Print employees names filter by Gender.
		employeeList.stream().filter(employee -> employee.getGender().equalsIgnoreCase("male"))
				.forEach(x -> System.out.println("employee males list ->" + x.getName()));
		
		// Question:1.30:Print employees filter by Gender female/male and salary Greater 0k
		employeeList.stream().filter(employee -> employee.getGender().equalsIgnoreCase("male"))
				.filter(employee -> employee.getSalary() < 10000).forEach(x -> System.out.println("employee males list ->" + x.getName()));
		
		
		//Question:1.31:Print count of female and male employees
		Long gendorCount=employeeList.stream().filter(x -> x.getGender().equalsIgnoreCase("female"))
				.collect(Collectors.counting());
		System.out.println("Employee gendor count " + gendorCount);
		
		
		// Question:1.32:Print employee names group by genders
		Map<String, List<String>> groupByMaleAndFemaleEmployeeNames = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(GSON.toJson(groupByMaleAndFemaleEmployeeNames));

		// Question:1.33:Print employees total salary group by Genders
		Map<String, Double> totalSalaryGroupedByGender = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.summingDouble(Employee::getSalary)));
		System.out.println(GSON.toJson(totalSalaryGroupedByGender));
		
		// Question:1.34:Print employees count group by gender
		Map<String, Long> countEmployeesGroupByGender = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(GSON.toJson(countEmployeesGroupByGender));

	}

}
