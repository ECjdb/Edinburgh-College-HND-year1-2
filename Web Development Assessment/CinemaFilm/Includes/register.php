<?php
$page_title = 'Register ' ;
include('../css/header.html');
# Check form submitted.
if ( $_SERVER[ 'REQUEST_METHOD' ] == 'POST' )
{
  # Connect to the database.
  require ('connect_db.php'); 
  
  # Initialize an error array.
  $errors = array();

  # Check for a first name.
  if ( empty( $_POST[ 'first_name' ] ) )
  { $errors[] = 'Enter your first name.' ; }
  else
  { $fn = mysqli_real_escape_string( $link, trim( $_POST[ 'first_name' ] ) ) ; }

  # Check for a last name.
  if (empty( $_POST[ 'last_name' ] ) )
  { $errors[] = 'Enter your last name.' ; }
  else
  { $ln = mysqli_real_escape_string( $link, trim( $_POST[ 'last_name' ] ) ) ; }

  # Check for an email address:
  if ( empty( $_POST[ 'email' ] ) )
  { $errors[] = 'Enter your email address.'; }
  else
  { $e = mysqli_real_escape_string( $link, trim( $_POST[ 'email' ] ) ) ; }

  # Check for a password and matching input passwords.
  if ( !empty($_POST[ 'pass1' ] ) )
  {
    if ( $_POST[ 'pass1' ] != $_POST[ 'pass2' ] )
    { $errors[] = 'Passwords do not match.' ; }
    else
    { $p = mysqli_real_escape_string( $link, trim( $_POST[ 'pass1' ] ) ) ; }
  }
  else { $errors[] = 'Enter your password.' ; }
  
  # Check if email address already registered.
  if ( empty( $errors ) )
  {
    $q = "SELECT user_id FROM users WHERE email='$e'" ;
    $r = @mysqli_query ( $link, $q ) ;
    if ( mysqli_num_rows( $r ) != 0 ) $errors[] = 'Email address already registered. <a href="login.php">Login</a>' ;
  }
  
  # On success register user inserting into 'users' database table.
  if ( empty( $errors ) ) 
  {
    $q = "INSERT INTO users (first_name, last_name, email, pass, reg_date) VALUES ('$fn', '$ln', '$e', SHA1('$p'), NOW() )";
    $r = @mysqli_query ( $link, $q ) ;
    if ($r)
    { echo '<div class="container"><h1>Registered!</h1><p>You are now registered.</p><p><a href="login.php">Login</a></p>'; }
  
    # Close database connection.
    mysqli_close($link); 

     
    exit();
  }
  # Or report errors.
  else 
  {
    echo '<div class="container"><h1>Error!</h1><p id="err_msg">The following error(s) occurred:<br>' ;
    foreach ( $errors as $msg )
    { echo " - $msg<br>" ; }
    echo 'Please try again.</p></div>';
    # Close database connection.
    mysqli_close( $link );
  }  
}
?>

<form action="register.php" method="post">
	<div class="container">
	<h1>Create Account</h1>
    
	<input type="text" 
		   class="form-control" 
		   placeholder="First name"
		   name="first_name" 
		   required size="20" 
		   value="<?php if (isset($_POST['first_name'])) echo $_POST['first_name']; ?>"> 
	<hr>

	<input type="text" 
		   class="form-control" 
		   placeholder="Last name"
		   name="last_name" 
		   required size="20" 
		   value="<?php if (isset($_POST['last_name'])) echo $_POST['last_name']; ?>">
	<hr>				
	
	<input type="text" 
		   class="form-control" 
		   placeholder="Email" 
		   name="email" 
		   required 
		   size="20" 
		   value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>">
	<hr>				
	
	<input type="password" 
	       class="form-control" 
		   placeholder="Create Password" 
		   name="pass1" 
		   required size="20" 
		   value="<?php if (isset($_POST['pass1'])) echo $_POST['pass1']; ?>" >
	<hr>				
	
	<input type="password" 
	       class="form-control" 
		   placeholder="Confirm Password" 
		   name="pass2" 
		   required size="20" 
		   value="<?php if (isset($_POST['pass2'])) echo $_POST['pass2']; ?>">
	<hr>				
	<input class="btn btn-primary btn-block" type="submit" value="Create Account">
	<hr>			
</form>
	</div>
	
	
</body>
</html>
