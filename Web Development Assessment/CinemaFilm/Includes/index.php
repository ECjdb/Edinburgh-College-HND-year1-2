<?php # DISPLAY COMPLETE LOGGED IN PAGE.

# Set page title and display header section.
$page_title = 'Home' ;
include ( 'headerout.php' ) ;
 
require ('connect_db.php');

# Retrieve items from 'products' database table.
$q = "SELECT * FROM movies" ;
$r = mysqli_query( $link, $q ) ;
if ( mysqli_num_rows( $r ) > 0 )
{
 # Display body section.
  echo '<div class="container">
		<h1 class="display-4 text-muted">Now Showing </h1>
			<div class="card-body">
				<div class="row">
				
		
				
			';
  while ( $row = mysqli_fetch_array( $r, MYSQLI_ASSOC ))
  {
    echo '<div class="col-md-3 col-sm-12">
			<div class="card w-100 text-white bg-dark mb-4"><img class="card-img-top" src='. $row['mov_img'].'>
				<div class="card-body">
					<h6 class="card-title text-center"> <a href="added.php?id='.$row['movie_id'].'"><button type="button" class="btn btn-link">' . $row['title'] .'</button></a>
					<h6 class="card-title text-center">Showtimes: ' . $row['showing1'] . ' / ' . $row['showing2'] . '</h2>
				</div>
			</div>
		 </div>';
  }
  echo '</div></div>';
  
  # Close database connection.
  mysqli_close( $link ) ; 
}
# Or display message.
else { echo '<p>There are currently no movies showing at this cinema.</p>' ; }


?>
</body>
</html>