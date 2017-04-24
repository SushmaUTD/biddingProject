<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme Simply Me</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="resources\core\css\bootstrap.min.css" rel="stylesheet">
	<link href="resources\core\css\homepage.css" rel="stylesheet">
	<link href="resources\core\css\createNewBid.css" rel="stylesheet">
	<script src="homepage.js"> </script>
	<script src="createbid.js"></script>
 <link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
 <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="resources\core\js\bootstrap.min.js"></script>
  
  <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #f5f6f7;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  .bg-1 { 
      background-color: #1abc9c; /* Green */
      color: #ffffff;
  }
  .bg-2 { 
      background-color: #474e5d; /* Dark Blue */
      color: #ffffff;
  }
  .bg-3 { 
      background-color: #ffffff; /* White */
      color: #555555;
  }
  .bg-4 { 
      background-color: #2f2f2f; /* Black Gray */
      color: #fff;
  }
  .container-fluid {
      padding-top: 20px;
      
  }
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
      color: #1abc9c !important;
  }
  </style>
</head>
<body>
<header>
<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
<!-- Navbar -->
<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
	  <span style="font-size:30px;cursor:pointer;color:white" onclick="openNav()">&#9776;</span>
      
	  
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
	    <li><a><input type="search" name="search">
            <input type="button" name="go" value="Go"></a></li>	
		
        <li><a href="#">My Profile</a></li>
        <li><a href="#">Logout</a></li>
        
      </ul>
    </div>
  </div>
</nav>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <p>${user.getFirstName()} ${user.getLastName()} </p>
  <p><img src="resources\core\img\logos\phone.jpg">${user.getMobile()}</p>
  <p><img src="resources\core\img\logos\email1.jpg">${user.getEmail()} </p>
  <div class="footer">
  <p style="font-size: 15px">Last Login: ${user.getModifiedDate()}</p>
  <p style="font-size: 15px">Location: ${user.getLocation()}</p>
  </div>
</div>
</header>
<!-- First Container -->
<% if (session == null)
	{
	String address = "/login-error.jsp";
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
	dispatcher.forward(request,response);
	}
else
{
	String bid_userid=(String)session.getAttribute("USER"); 
	}%>
<div id="reg">

    <form id="createbid" action="http://192.168.0.24:8080/frontend/landingPage" method="POST">
	        
            <p>Product Name</p>
            <p><input type="text" name="productName" placeholder="ProductName" required autocomplete="off"></p>
            <p>Product Description</p>
			<textarea name="productDescription" rows="3" cols="40" placeholder="Describe your product here" required autocomplete="off"></textarea>
            <p>Price</p>
            <p><input type="number" pattern="[0-9]" name="price" placeholder="Enter amount in dollars" required autocomplete="off"></p>
            <p>Enter image url</p>
			<!--<input type='file' onchange="readURL(this);" />
               <img id="blah" src="#" alt="your image" />-->
            
			<input type="url" name="imageUrl" placeholder="URL"><br><br>
			<input type="hidden" name="bid_userid" value="$bid_userid">
            <input type="submit" value="Create"/>
          </form>  
            </div>
  



</body>
</html>
