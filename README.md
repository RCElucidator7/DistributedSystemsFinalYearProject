# DistributedSystemsFinalYearProject
Distributed Systems Final Year Project

For our Distributed Systems Final Year Project we were required to use the JAX-RS/Jersey, Java  RMI and  JAXB 
frameworks to develop a simple Car Hire Booking  System. 

We had four main requirements for this project:

* (1) A Simple Web Client
* (2) RESTful Web Service
* (3) Data Modelling
* (4) RMI Database Server

## How It Works

The project contains 3 folders. One for the Tomcat Server, a java project for the RMI Database Server and a Maven/Jersey Project 
for the RESTful Web Service.

The Server folder is required to use tomcat, which will connect us to our database.

The RMI folder contains a java project with all of the database manipulation and holds all our methods that send queries to 
the database.

The RESTful Web Service is a Maven/Jersey project that calls all the CRUD requests and also works as the web client through 
JSP files.

## Running the project

To run the project, first clone down this repo.

  git clone https://github.com/RCElucidator7/DistributedSystemsFinalYearProject.git
  
Once the project has been clones, open up eclipse and use the cloned repo as the workspace.(NOTE: This project only work with Java Enterprise Edition, if you do not have this download from [here](https://www.eclipse.org/downloads/packages/)) Once you have that, you have to create the database. There are a number of ways to do this:

### Through phpMyAdmin:
  * Launch Wamp
  * Navigate to the WAMP application at the bottom right of the screen.
  * Left click, and click on phpMyAdmin
  * Browser will open up, sign in using the username root and leave the password blank
  * Navigate to the "Import" tab.
  * Click "Browse" and Locale the data.sql file found in the github repo
  * Click "Go" at the bottom of the page
  * This should create the database
  
### Manually:
  * Launch Wamp
  * Navigate to the WAMP application at the bottom right of the screen.
  * Left click and navigate to MySQL > MySql Console
  * A command prompt should launch, leave the password blank and click enter
  * Open up the data.sql file in Notepad/Notepadd++
  * Copy all the contents and paste them into the command prompt
  * This should create the database
  
Once the databse is set up, navigate to eclipse where the projects are opened.
Right click on the RMI Folder and select Run as > Java Application. If this runs sucessfully the console should display a ready message. If not I reccomend restarting eclipse and trying again.
Once your RMI project is running, Right click on the REST-Web-Service foldler and select Run as > Run on Server. If this was sucessful, a window should appear in eclipse with a web browser at localhost running the index.jsp file.

### Index page:
The index page should have two options:
  * Log in as Manager - this launches the menu specifically designed for Manager use.
  * Log in as customer - this launches the menu specifically designed for Customer use.


### Customer Menu:
The customer menu contains a link that reads in that customers information only (The customer must add their customer id to the end of the URL that opens)

### Manager Menu:
The manager menu contains 4 options for the user:
  * View Bookings Page - brings the user to a view bookings page which contains links to all the read (@GET) requests that can be sent.
    * View Bookings - This sends a @GET request to the RMI which returns all the users in the database.
    * View Specific Booking - This sends a @GET request with a specific orderID on the end of the URL which shows the info of that user, identified  by the orderID.
    * View as Customer - This sends a @GET request to the RMI which displays the info a customer would be able to see (Simulating the Customer Login)
  * Create Booking - brings the user to a form where the user can input their own order by filling in all the fields. The submit button then sends a @POST request to the server where it adds the user to the database then returns a list of all the current users in the database.
  * Delete Booking - brings the user to a form where they enter the orderID and submit. The submit button sends a request that removes that order from the database and returns the updated list of users in the database. (This was done using a @POST request as the HTML form submission only allows GET and POST requests. I realise this is incorrect but it was all I could do at the time)
  * Update Booking - brings the user to a form where they can fill in and update and specific values they may want to update. If the user wants to update only one or more values they can leave the inputs empty. The submit button sends a request to the RMI where it breaks apart the input data and formats it into an update query which updates the user with the inputed details.(Again, this was done using a @POST method as the HTML form submission only allows GET and POST requests).
  
