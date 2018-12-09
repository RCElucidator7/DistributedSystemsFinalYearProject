CREATE DATABASE CARHIREDATA;
use CARHIREDATA;


CREATE TABLE IF NOT EXISTS Orders (
	OrderID int NOT NULL AUTO_INCREMENT,
	FirstName varchar(255) Not null,
	LastName varchar(255) not null,
	CustomerID int Not Null,
	StartDate varchar(255) not null,
	EndDate varchar(255) not null,
	CarReg varchar(255) Not Null,
	CarModel varchar(255) Not Null,
	PRIMARY KEY (OrderID)
);

<!--xjc -d "C:\Users\Ryan Conway\Desktop\tempFileStore\new" -p ie.gmit.sw.Model  "D:\College\Year 4\DisSys-workspace-jee\RMI\src\ie\gmit\sw\Model\Schema.xsd"-->

INSERT INTO Orders (OrderID, FirstName, LastName, CustomerID, StartDate, EndDate, CarReg, CarModel)
VALUES (1, "Barry", "Scott", 11, "23/05/18", "27/05/18", "02-G-123", "Tyota"), 
       (2, "Larry", "Lang", 21, "23/06/18", "26/06/18", "02-G-1234", "Ford"), 
	   (3, "Barry", "Scott", 31, "09/07/18", "16/07/18", "02-G-1235", "Volvo");
	   
SELECT * FROM Orders;