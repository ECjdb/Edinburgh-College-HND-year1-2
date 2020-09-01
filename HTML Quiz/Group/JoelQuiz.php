<!doctype html>
<html lang="en">
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />
	</head>
	<body>
		<br>
		<div class="container"> 
		   <br />
		   <h3 align="center">Quiz</h3>
		   <br />
			<form id="quiz" action="Courses.php" method="post">
				<p>Question 1 What is your current course?
				  <br>
				</p>
				<select name="Q1" form="quiz">
					<option value="Computing">Computing</option>
					<option value="Art">Art</option>
					<option value="History">History</option>
				</select>
				<hr>
				<p>Question 2: What year are you in? e.g. year 2 etc.
					<br>
				</p>  
				<select name="Q2" form="quiz">
					<option value="Y1">Year 1</option>
					<option value="Y2">Year 2</option>
					<option value="Y3">Year 3</option>

				</select>
				<hr>
				 <p>Question 3: Which College/University would you like to attend?
					<br>
				</p>
				<select name="Q3"form="quiz">
					<option value="FutureEdCollege">Edinburgh College</option>
					<option value="FutureNapier">Napier</option>
					<option value="FutureEdUni">Edinburgh University</option>
				</select>
				<hr>
				 <p>Question 4: What is your expected result?
				<br>
				</p>
				<select name="Q4"form="quiz">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
				</select>
				<hr>
				<br>
				<input class="btn btn-primary btn-block" 
					type="submit"
					value="Submit">
				</input>
				<hr>			
			</form>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>



