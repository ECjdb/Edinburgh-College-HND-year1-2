<?php # DISPLAY CHECKOUT PAGE.

# Access session.
session_start() ;

# Redirect if not logged in.
if ( !isset( $_SESSION[ 'user_id' ] ) ) { require ( 'login_tools.php' ) ; load() ; }

# Set page title and display header section.
$page_title = 'Checkout' ;
include ( 'headerout.php' ) ;


# Check for passed total and cart.
if ( isset( $_GET['total'] ) && ( $_GET['total'] > 0 ) && (!empty($_SESSION['cart']) ) )
{
  # Open database connection.
  require ('connect_db.php');
  
  # Ticket reservation and total in 'bookings' database table.
  $q = "INSERT INTO booking ( user_id, total, booking_date ) VALUES (". $_SESSION['user_id'].",".$_GET['total'].", NOW() ) ";
  $r = mysqli_query ($link, $q);
  
  # Retrieve current order number.
  $booking_id = mysqli_insert_id($link) ;
  
  # Retrieve cart items from 'movie' database table.
  $q = "SELECT * FROM movie WHERE mov_id IN (";
  foreach ($_SESSION['cart'] as $id => $value) { $q .= $id . ','; }
  $q = substr( $q, 0, -1 ) . ') ORDER BY mov_id ASC';
  $r = mysqli_query ($link, $q);

   # Store order contents in 'booking_contents' database table.
  while ($row = mysqli_fetch_array ($r, MYSQLI_ASSOC))
  {
    $query = "INSERT INTO booking_contents
	( booking_id, mov_id, mov_title, quantity, mov_price )
    VALUES ( $booking_id, ".$row['mov_id'].",".$_SESSION['cart'][$row['mov_id']]['quantity'].",".$_SESSION['cart'][$row['mov_id']]['price'].")" ;
    $result = mysqli_query($link,$query);
  }
  
  # Close database connection.
  mysqli_close($link);

  # Display order number.
  echo "<div class=\"container\"><h1 class=\"dispaly\">Thank you for booking with <span>EC</span>inema.  </h1>";
  echo '<p><a href="reservation.php?id='.$row['booking_id'].'"><button type="button" class="btn btn-secondary" role="button">Collect at Box Office</a></button>
  <hr><p><a href="paypal.php?id='.$row['booking_id'].'"><button type="button" class="btn btn-secondary" role="button">Pay Now</a></button> ';
  # Remove cart items.  
  $_SESSION['cart'] = NULL ;
}
# Or display a message.
else { echo '<p>There are no movies booked.</p>' ; }

?>