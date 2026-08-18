# Employee Record Management System

A Java-based Employee Record Management System developed as a **Data Structures project** using a **Singly Linked List**.

The system allows users to manage employee records through a simple `JOptionPane` interface.

## Features

* Insert employee records in ascending order by Employee ID.
* Validate Employee ID from **150 to 250** when adding a record.
* Prevent duplicate Employee IDs.
* Display all employee records.
* Search for an employee by ID.
* Update employee information.
* Delete employee records.
* Automatically adjust salary when work hours exceed 32.
* Exit the system through the main menu.

## Employee Information

Each employee record contains:

* Employee ID
* Name
* Phone Number
* Address
* First Day of Work
* Work Hours
* Salary

## Data Structure

The project uses a **Singly Linked List**, where each employee is stored in a `Node` containing the employee information and a reference to the next node.

```text
[Employee] → [Employee] → [Employee] → null
```

Employee records are inserted according to their Employee ID.

## Salary Update

When an employee's work hours are greater than 32, the salary is automatically adjusted using the implemented rule:

```text
Extra Hours = Work Hours - 32
Salary Increase = Current Salary × 0.02 × Extra Hours
```

## Main Operations

| Operation | Description                  |
| --------- | ---------------------------- |
| Insert    | Add a new employee record    |
| Delete    | Remove an employee by ID     |
| Update    | Modify employee information  |
| Show      | Display all employee records |
| Search    | Find an employee by ID       |
| Exit      | Close the application        |

## Technologies

* Java
* Java Swing (`JOptionPane`)
* Singly Linked List

## How to Run

1. Open the Java project in a compatible Java IDE.
2. Open `Project_Data_Structures.java`.
3. Run the `main()` method.
4. Use the displayed menu to manage employee records.

## Author

**Mayasim Mohammed Badhurays**
Artificial Intelligence Graduate — University of Jeddah
