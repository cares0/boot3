<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="../temp/header_css.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-light" role="alert">
				<h4 style="text-transform: uppercase;">${board}Join</h4>
			</div>
		</div>


		<div class="row mt-4">
			<form action="add" method="post" enctype="multipart/form-data">
				<div class="row mb-3">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-10">
						<input type="text" name="id" class="form-control" id="id">
					</div>
				</div>

				<div class="row mb-3">
					<label for="pw" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="pw" class="form-control" id="pw">
					</div>
				</div>


				<div class="row mb-3">
					<label for="checkPw" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="checkPw" class="form-control" id="checkPw">
					</div>
				</div>

				<div class="row mb-3">
					<label for="name" class="col-sm-2 col-form-label">Name</label>
					<div class="col-sm-10">
						<input type="text" name="name" class="form-control" id="name">
					</div>
				</div>

				<div class="row mb-3">
					<label for="Email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="email" name="email" class="form-control" id="email">
					</div>
				</div>

				<div class="row mb-3">
					<label for="phone" class="col-sm-2 col-form-label">Phone</label>
					<div class="col-sm-10">
						<input type="text" name="phone" class="form-control" id="phone">
					</div>
				</div>				

				<div class="row mb-3">
					<label for="files" class="col-sm-2 col-form-label">File</label>
					<div class="col-sm-10">
						<input type="file" name="files" class="form-control" id="files">
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Join</button>
			</form>

		</div>

		<div class="my-5">
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="checkAll">
			  <label class="form-check-label" for="checkAll">
			    checkALL
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    check1
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="flexCheckChecked">
			  <label class="form-check-label" for="flexCheckChecked">
			    check2
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="flexCheckChecked">
			  <label class="form-check-label" for="flexCheckChecked">
			    check3
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input ch" type="checkbox" value="" id="flexCheckChecked">
			  <label class="form-check-label" for="flexCheckChecked">
			    check4
			  </label>
			</div>
		
		</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script>
		$('#checkAll').on('click', function(){
			$('.ch').prop('checked', $('#checkAll').prop('checked'));
			// all의 checked가 true면 그 값이 들어갈 것이고, false면 그 값이 들어갈 것이다.
		})
		
		$('.ch').on('click', function(){
			$('#checkAll').prop('checked', true);
			$('.ch').each(function(index, item){
				if($(item).prop('checked') == false) {
					$('#checkAll').prop('checked', false);
				}
			})
		})
	
	</script>
	
</body>
</html> 