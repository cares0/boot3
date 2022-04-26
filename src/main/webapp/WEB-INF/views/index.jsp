<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<!-- header -->
<c:import url="./temp/header.jsp"></c:import>

<div class="container mt-4">	
  		<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
		  <div class="carousel-indicators">
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
		    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
		  </div>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="https://fncent.com/files/2022/02/23/875ea9925cc4988746519d241fd2b78a180649.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="https://fncent.com/files/2022/02/23/95c2c0687206848f8f867241a1115b1a180649.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="https://fncent.com/files/2022/02/23/c1ef220da543b3d053290efcb3dd2581180649.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
  	</div>

<div class="container">
	<input type="text" id="v1">
	<input type="checkbox" class="num" name="num" value="a">
	<input type="checkbox" class="num" name="num" value="b">
	<input type="checkbox" class="num" name="num" value="c">
	<input type="checkbox" class="num" name="num" value="d">

	<button id="btn1">get</button>
	<button id="btn3">Ajax</button>
	
	
</div>


<div id="result">


</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">
/* 	$("#btn").on("click", function(){
		alert("jquery");
	});
	
	$('#btn2').click(function(){
		alert('2');
	});

	$('#btn3').click(function(){
		$('#result').append(
			'<input type="checkbox">RESULT'
		)
	}) */
	
	$('#btn1').on("click", function(){
		let v = $("#v1").val();
		
		$.get("./getTest?value="+v, function(data){
			console.log(data.trim());
		})
	})
	
	$('#btn3').on("click", function(){
		let v = $("#v1").val();
		let nums = [];
		
		$(".num").each(function(idx, item){
			if($(item).prop("checked") == true) {
				console.log($(item).val());
				nums.push($(item).val());
			}
		});
		
		$.ajax({
			type : "POST",
			url : "./arrayTest",
			traditional : true, // 배열을 전송할 경우
			data : {
				value : v,
				numbers : nums
			},
			success : function(result){
				console.log(result.trim());
			}
		})
	})

	
</script>
</body>
</html>