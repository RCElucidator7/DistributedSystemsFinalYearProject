<html>
<body>
    <h2>Create an Order</h2>
    <form action="webapi/myresource/create" method="post">
    <p>First Name :</p>
    	<input type="text" name="firstName"/>
    <p>Last Name :</p>
    	<input type="text" name="lastName"/>
    <p>Customer No. :</p>
    	<input type="number" name="customerId"/>
    <p>Date of rent :</p>
    	<input type="date" name="startDate" />
    <p>Date of return :</p>
    	<input type="date" name="endDate" />
    <p>Car Registration Number :</p>
    	<input type="text" name="carReg"/>
    <p>Car Model Type : </p>
    	<input type="text" name="carModel"/>
   	 	<input type="submit" value="Submit"/>
    </form>
    <p><a href="index.jsp">Back to home menu</a></p>
</body>
</html>
