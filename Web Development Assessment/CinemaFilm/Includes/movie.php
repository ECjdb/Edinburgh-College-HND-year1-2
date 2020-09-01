<?php # DISPLAY COMPLETE PRODUCTS PAGE.
# Open database connection.
require ( 'connect_db.php' ) ;
include ('../css/header.html') ;

# Retrieve items from 'shop' database table.
$q = "SELECT * FROM movies" ;
$r = mysqli_query( $link, $q ) ;
if ( mysqli_num_rows( $r ) > 0 )
{
  # Display body section.
   echo '<table>
			<tr>
			<th>Movie</th>
			<th>Screen</th>
			<th>Ticket Price</th>';
  while ( $row = mysqli_fetch_array( $r, MYSQLI_ASSOC ))
   echo '<tr><td>' . $row['title'] .'</td><td>'. $row['screen'] . '</td><td>&pound' . $row['price'] . '</td>' ;  {
  }
   echo '</tr></table>';
  
  # Close database connection.
  mysqli_close( $link ) ; 
}
# Or display message.
else { echo '<p>There are currently no movies showing.</p>' ; }


?>