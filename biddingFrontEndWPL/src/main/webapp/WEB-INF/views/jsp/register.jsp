<!DOCTYPE html>
<html lang="en">
<head>
  <title>register</title>
  <link href="resources\core\css\register.css" rel="stylesheet">
</head>
<body>
<h1>Create your Account here!!</h1>
<div id="reg">
    <form id="register" action="http://192.168.0.24:8080/frontend/landingPage" method="POST">
            <p>Name</p>
            <p><input type="text" name="firstName" placeholder="Firstname" size="14" required autocomplete="off">&nbsp;&nbsp;
            <input type="text" name="lastName" placeholder="Lastname" size="14" required autocomplete="off"></p>
            <p>Choose your username</p>
            <p><input type="text" pattern="[A-Za-z0-9]{2,}"name="userName" placeholder="Enter Username" required autocomplete="off"></p>
            <p>Create password</p>
            <p><input type="password" pattern="{6,}" name="password" placeholder="Password" required autocomplete="off"></p>
            <p>Confirm password</p>
            <p><input type="password"  name="con_password" placeholder="Password" required autocomplete="off"></p>
            <p>Birthday</p>
            <p><input type="date" name="dob" placeholder="date of birth" required autocomplete="off"></p>
            <p>Gender</p>
            <p><select>
  				<option value="male">Male</option>
  				<option value="female">Female</option>
  				<option value="other">Other</option>
			  </select></p>
			<p>Mobile number</p>
			<p><input type="tel" name="mobile" placeholder="mobile number" required autocomplete="off"></p>
            <p>Email address</p>
            <p><input type="email" name="email" placeholder="email" required autocomplete="off"></p>
            <p>Contact Address</p>
            <p><input type="text" name="streetName" placeholder="streetName" size="14" required autocomplete="off">&nbsp;&nbsp;
            <input type="text" name="city" placeholder="city" required size="14" autocomplete="off"></p>
            <p><input type="text" name="state" placeholder="state" size="14" required autocomplete="off">&nbsp;&nbsp;
            <input type="text" name="country" placeholder="country" size="14" required autocomplete="off"></p>
            <p><input type="text" name="zipcode" placeholder="zipcode" size="14" required autocomplete="off"></p>
            <input type="submit" value="Sign Up"/>
          </form>  
            </div>
	</body>
</html>