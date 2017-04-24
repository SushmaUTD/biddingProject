<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme Simply Me</title>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="css\bootstrap.min.css" rel="stylesheet">
<link href="homepage.css" rel="stylesheet">
<script src="homepage.js"> </script>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
 <link href="itemlist.css" rel="stylesheet">
  <script>
  function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
$(document).ready(function(){
    $("#sub").click(function(){
        $(".card").after( '<form id="form"><input type="text" placeholder="Enter Bid Value" id="txt" margin-left="400px"> <input type="submit" value="Enter"></form>');
    });
});
</script>
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
      padding-top: 70px;
      padding-bottom: 70px;
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
            <input type="submit" name="submit" value="Go"></a></li>	
		
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
    <% createBid item= new createBid();
	   int count=0;
	   for(int i=0;i<itemsList.size();i++){
            item = itemsList.get(i);
            count++;			%>
	<div class="container">
		<div class="card" style="height:225px" >
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6" >
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-${count}"><img src="${item.getImageUrl}" width="10px" height="155px" /></div>
						  
						</div>
					 </div>
					<div class="details col-md-6" style="color:black">
						<h3>${item.getProductName}</h3>
						
						<p class="product-description">${item.getProductDescription}</p>
						<h4 class="price">current price: <span>$ ${item.getPrice}</span></h4>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	   <%}%>
	</body>
	</html>