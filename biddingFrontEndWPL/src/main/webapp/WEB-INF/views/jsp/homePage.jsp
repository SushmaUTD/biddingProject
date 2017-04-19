<!DOCTYPE html>
<head>
	<title>homepage</title>
	<link href="resources/core/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/core/css/homepage.css" rel="stylesheet">
	<script src="homepage.js"> </script>
	
</head>
<body>
<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid" style="margin: 0 auto;">
    <div class="navbar-header" style="margin:0 auto;">
      <h2 style="color:white;">University of Texas at Dallas, College of Music</h2>
    </div>
    <ul class="nav navbar-nav">
	  <li><span style="font-size:30px;cursor:pointer;color:white" onclick="openNav()">&#9776;</span></li>
      <li class="active"><a href="index.html">Home</a></li>
      <li><a href="#a">Facilities</a></li>
      <li><a href="#b">Workshops</a></li>
      <li><a href="#c">Childhood Programs</a></li>
	  <li><a href="#e">Faculty&#38;Staff</a></li>
	  <li><a href="#d">Contact Us</a></li>
    </ul>
  </div>
</nav>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <p>${user.getFirstName()}+""
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>



<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
</script>
     
</body>
</html> 

 