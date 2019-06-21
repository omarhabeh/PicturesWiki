<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Wikipicture</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
        <style>
    .card{

        margin-bottom:5%;

    }

    body ,.my-4{ 
  background: url(images/14.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
    
}
    
    </style>
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">Wikipicture</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="login.jsp">log out</span></a>
                </li>
            </ul>
        </div>
    </nav>


    <div class="content" style="margin-top:5%; display:block; overflow:hidden; height: 100%;">
        <div class="row">
        <div class="col-2"></div>

        <div class="col-8">
        <div class="jumbotron">
        <h1 class="display-4"> ${fname}'s Dashboard</h1>
        
        
        
        
        <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Add item
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <form method="POST" action="store" enctype="multipart/form-data">
        <input type="hidden" value="${id}" name="id">
        <input type="file" accept="image/*,video/*" name="pic" id="pic" >
        <input type="hidden" value="${fname}" name="fname">
        <input type="text" name="description" placeholder="description" style="display:block ;margin-top:5px!important; border: 1px black solid">
        <input type="submit" class="btn btn-primary btn-sm" style="display:block ;margin-top:5px!important;"> 
        <script>
		document.getElementById('pic').onchange = function () {
	 	document.getElementById('pic').innerHTML=this.value;};
	 	</script>
        </form>
  </div>
</div>
        
        
        <hr class="my-4">
        <div class="row">
 <c:forEach items="${prod}" var="usersa">
   <div class="col-md-auto">
                <div class="card" style="width: 16rem;text-align:center;margin-top:20px; " class="col-auto mb-3">
             	<%
             	
             	%>
             	<img src="data:image/png;base64,${usersa.previewUrl}" alt="images Here" height="200px"/>

                    <div class="card-body">
                        <p class="card-text">${usersa.description}</p>
                        <a class="btn btn-danger fa fa-close" href="delete?id=${usersa.id}&picId=${usersa.picId}&fname=${fname}" role="button" style="background-color: RED;"></a>
            		</div>
            		
</div>
            
            </div>	
            </c:forEach>
            </div>
        </div>
        

        </div>
        </div>
        <div class="col-2"></div>
    </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>