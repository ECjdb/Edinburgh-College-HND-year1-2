
<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<?php				
			if ( $_SERVER[ 'REQUEST_METHOD' ] == 'POST' )
			{
				//get current loction
				if ( empty( $_POST[ 'Q3' ] ) )
				{ $errors[] = 'Where would you like to study' ; }
				else
				{ 
					if($_POST[ 'Q3' ] == "FutureEdCollege")
					{
						$currentED = "Edinburgh College"; 
					}
					if($_POST[ 'Q3' ] == "FutureNapier")
					{
						$currentED = "Naiper"; 
					}
					if($_POST[ 'Q3' ] == "FutureEdUni")
					{
						$currentED = "Edinburgh University"; 
					}
				}	
			//Currently Studying 
			if ( empty( $_POST[ 'Q1' ] ) )
			{ $errors[] = 'Select a Course Type' ; }
			else
			{ 
				$current =  $_POST[ 'Q1' ] ; 
			}
			
				//Current Year				
			if ( empty( $_POST[ 'Q2' ] ) )
			{ $errors[] = 'Select current year' ; }
			else
			{ 
				if($_POST[ 'Q2' ] == "Y1")
					{
						$next = "Year 2";
						$currentyear = "Year 1";
					}
				if($_POST[ 'Q2' ] == "Y2")
					{
						$next = "Year 3";
						$currentyear = "Year 2";
					}
				if($_POST[ 'Q2' ] == "Y3")
					{
						$next = "Year 4";
						$currentyear = "Year 3";
					}
			}
			//Expected Grade 
			if ( empty( $_POST[ 'Q4' ] ) )
			{ 
				$errors[] = 'Select expected grade' ; 
			}
			else
			{ 
			$grade =  $_POST[ 'Q4' ] ; 
			}
		}
		else 
			{
				header('Location: home.php');
			}
		?>
	</head>
	<body>
		<div class="container">
		<h1>Courses</h1>
		<h5>
		<?php echo "You are Studying: ".$current;?>
		<br>
		<?php echo "You are currently in: ".$currentyear;?>
		<br>
		<?php echo "You expect to get an: ".$grade;?>
		<br>
		Below are some courses<h5>
		<br>
		<?php if($grade == "A")
			
			{
				echo '
						<div class="card">
			  <div class="card-header">
				<?php'. $currentED.'
			  </div>
			  <div class="card-body">
				<h5 class="card-title">Course Example</h5>
				<p class="card-text"> You would like to study: '.$current.'</p>
			  </div>
			</div>
			
					<div class="card">
			  <div class="card-header">
				<?php '. $currentED.'
			  </div>
			  <div class="card-body">
				<h5 class="card-title">Course Example</h5>
				<p class="card-text">You would like to study: '.    $current.' Second Choice</p>
			  </div>
			</div>';
			}
			if($grade == "B")
			
			{
				echo '
						<div class="card">
			  <div class="card-header">
				<?php'. $currentED.'
			  </div>
			  <div class="card-body">
				<h5 class="card-title">Course Example</h5>
				<p class="card-text"> You would like to study: '.$current.'</p>
			  </div>
			</div>';
			}
			?>
				
				
			
	
		</div>		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>
    