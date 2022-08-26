1.What are new features are introduced in Java8
-----------------------------------------------
Lambda Expression
functional interface
Static and Default methods
Stream API
Date/Time API Changes
Method references


2.What are the main advantages of using Java8
----------------------------------------------
More compact code
Less boiler plate code
Encouragement of functional programming
More readable and reusable code
Parallel operations

3.What are the Functional interfaces and its uses
-------------------------------------------------
Function interfaces are those interfaces which can have only one abstract method.
It is used to achieve functional programming in java by passing methods as arguments.
EXAMPLE: Comparable with compareTo() method and Runnable with run() method.

4.What is Lambda Expression in Java8
------------------------------------
It is anonymous function (no method name)
Lambda expression is achieved by using functional interface
It has set of parameters and a lambda(->) and function body
(parameter_list) -> {function_body}
(a,b) -> (a+b)

5.What is method reference in Java8
-----------------------------------
Method reference is used to refer method of functional interface.
It is nothing but compact way of lambda expression.
We can simply replace lambda expression with method reference.
Syntax: class::methodName

6.What is Optional? Why and how can you use it in Java8
--------------------------------------------------------
Optional class avoid NullPointerException in java
Optional class encapsulates optional value which is either present or not.

7.What are default methods in Java8
------------------------------------
The reason we have default methods in interfaces in Java8 is to allow the developers to add new methods to the interfaces
without affecting the classes that implements there interfaces.

8.What are static methods in Java8
----------------------------------
Static methods in interfaces are similar to the default methods except that we cannot override these methods in the classes
that implements these interfaces.
This feature helps us in avoiding undesired results in case of poor implementation in implementation classes.

9.What is an Stream API in Java8
--------------------------------
Stream API is used to process collections.
A Stream is a sequence of objects that supports various method which can be pipelined to produced the desire result.

Input ---->process input(Operation) -->end result

10.Difference between Collection and Stream in Java8
------------------------------------------------------
Collection:
Mainly used to store and manipulate the group of data.
We can add or remove elements from collections.
Collections are eagerly constructed. List,Map,Set

Stream:
Mainly used to perform operations on data.
We cannot add or remove elements form streams.
Streams are lazily constructed. Filter,map

11.Name some intermediate operations in streams?
------------------------------------------------
FILTER: This method is used to select elements as per the predicate passed as arguments.
MAP: This method is used to convert a list of objects to specific return type.

12.Name some terminal operation in streams?
-------------------------------------------
COLLECT:It is used to return the result of intermediate operations performed on the stream.
FOREACH: It is used to iterate through every element of stream.








 




