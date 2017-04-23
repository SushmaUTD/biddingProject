<!DOCTYPE html>
<head>
	<title>homepage</title>
	<link href="resources\core\css\bootstrap.min.css" rel="stylesheet">
	<link href="resources\core\css\homepage.css" rel="stylesheet">
	<script src="resources\core\js\homepage.js"> </script>
<style>
 
</style>
</head>
<body>
<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid" style="margin: 0 auto;">
    <!-- <div class="text-center" style="margin:0 auto;">
      <h2 style="color:white;">University of Texas at Dallas, College of Music</h2>
    </div>-->
    <ul class="nav navbar-nav">
	  <li><span style="font-size:30px;cursor:pointer;color:white" onclick="openNav()">&#9776;</span></li>
      <li class="active"><a href="index.html">Home</a></li>
      <li><input type="search" name="search">
      <input type="submit" name="submit" value="Go"></li>
      
    </ul>
    <input style="float:right;" type="button" onclick="alert('logout')" 

value="Logout">&nbsp;&nbsp;
    <input style="float:right;" type="button" onclick="alert('my profile')" value="My 

Profile">
   
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

<div id="div-left" class="div-left">
<h2><img id="img" src="add.jpg" href=""> Create new bid</h2>
<h2><img id="img" src="auction.jpg" href=""> My Bids</h2>
<h2><img style="width:20%; height:20%" id="img" src="unnamed.jpg" href=""> Posted items</h2>

</div>
<div id="div-right">
<h2><img id="img" src="bid.jpg" href=""> Bid items</h2>
<h2><img id="img" src="purchased.jpg" href=""> Purchased items</h2>
</div>

<script>
$(document).ready(function(){
$("div.div-left").mouseenter(function(){
$("div.div-left").animate({
left:'20px',
height:'+=20px',
width:'+=20px'
});
});
$("div.div-left").mouseleave(function(){
$("div.div-left").animate({
height:'-=20px',
width:'-=20px'
});

});
});

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

 