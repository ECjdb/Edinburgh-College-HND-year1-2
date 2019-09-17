<?php

    use Psr\Http\Message\ServerRequestInterface as Request;
    use Psr\Http\Message\ResponseInterface as Response;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of DbHandler
 * This class will have CRUD methods for the database tables
 * @author EC1524329
 */

 /**
  * Constructor for DbHandler. Establishes a connection to the database.
  */
class DbHandler 
{
    private $conn;
    
    function __construct() 
    {
        //Requires a connection to the database
        require_once dirname(__FILE__) . './DbConnect.php';
        //opening the database connection
        $db = new DbConnect;
        $this->conn = $db->connect();      
    }

    /* 
    - Create Function -
    The function will insert a new user into the user_account database.
    */
    public function createUser($email, $password, $subscription)
    {
        if(!$this->ifEmailExists($email))
        {
            $stmt = $this->conn->prepare("INSERT INTO user_account(user_email, user_password, subscription_type) VALUES (?, ?, ?)");
            $stmt->bind_param("ssi", $email, $password, $subscription);
            if($stmt->execute())
            {
                return USER_CREATED_SUCCESSFULLY; 
            }
            else
            {
                return USER_CREATE_FAILED;   
            }
        }
            return USER_ALREADY_EXISTS; 
    }

    /*
    - Read Operation -
    This function checks to see if the user exists in the database.
    */
    private function ifEmailExists($email)
    {
        $stmt = $this->conn->prepare("SELECT user_id FROM user_account WHERE user_email = ?");
        $stmt->bind_param("s", $email);
        $stmt->execute(); 
        $stmt->store_result(); 
        
        //returns number of rows that exist. Since accounts are unique only one row will be returned.
        return $stmt->num_rows > 0;  
    }
  
    /* 
    - Read Function -
    The userLogin checks to see if the user exists in the user_account database.
    The function takes 2 parameters, an email address and a password.
    */
    public function userLogin($email, $password)
    {
        //Checks to see if the email exists in the databse
        //if the user exists, the passwords will then be compared.
        //if the passwords match then the user is authenticated.
        //if the passwords do not match then the user access is denied.
        if($this->ifEmailExists($email))
        {
            $check_password = $this->getUserPasswordByEmail($email); 
            if($password == $check_password)
            {
                return USER_AUTHENTICATED;
            }
            else
            {
                return USER_PASSWORD_DOES_NOT_MATCH; 
            }
        }
        //if the user is not found by email then the user does not exist.
        else
        {
            return USER_NOT_FOUND; 
        }
    }
  
    /*  
    - Read Function -
    The getUserPasswordByEmail method is returning the password of a given user
    to verify as to whether or not the given password is correct or not.
    */
    private function getUserPasswordByEmail($email)
    {
        $stmt = $this->conn->prepare("SELECT user_password FROM user_account WHERE user_email = ?");
        $stmt->bind_param("s", $email);
        $stmt->execute(); 
        $stmt->bind_result($password);
        $stmt->fetch(); 
        return $password; 
    }
    
      /*
    - Read Operation -
    The getUserByEmail reads function gets a specific user from database based on the valid email variable it is passed.
    */
    public function getUserByEmail($email)
    {
        /**
         * This function stores the mySQL statement in $stmt variable. The passed in variable $email is then bound and is then exectuted.
         * After retrieving the results, the user objects values are then bound to 4 variables, one for each value.
         * Then for the user object retrieved the object is assigned 4 key names, and the 4 values that were bound to the variables are assigned
         * to the appropriate key and the object is returned.
         */
        $stmt = $this->conn->prepare("SELECT user_id, user_email, user_password, subscription_type FROM user_account WHERE user_email = ?");
        $stmt->bind_param("s", $email);
        $stmt->execute(); 
        $stmt->bind_result($id, $email, $password, $subscriber);
        $stmt->fetch(); 
        $user = array(); 
        $user['user_id'] = $id; 
        $user['user_email']=$email; 
        $user['user_password'] = $password; 
        $user['subscription_type'] = $subscriber; 
        
        return $user; 
    }
     /*
    - Read Operation -
    The getUserById reads function gets a specific user from database based on the valid Id variable it is passed.
    */
    public function getUserById($id)
    {
        $stmt = $this->conn->prepare("SELECT user_id, user_email, user_password, subscription_type FROM user_account WHERE user_id = ?");
        $stmt->bind_param("i", $id);
        $stmt->execute(); 
        $stmt->bind_result($id , $email, $password, $subscriber);
        $stmt->fetch(); 
        $user = array(); 
        $user['user_id'] = $id; 
        $user['user_email']=$email; 
        $user['user_password'] = $password; 
        $user['subscription_type'] = $subscriber; 
        
        return $user; 
    }
    /*
    - Read Operation -
    The getAllUsers function returns all users from the database
    */
    public function getAllUsers()
    {
        /*
        * This function stores the mySQL statement in $stmt variable. The passed in variable $email is then bound and is then exectuted.
        * After retrieving the results, the user objects values are then bound to 4 variables, one for each value.
        * An array is declared called $users and while there are objects to fetch from $stmt, a second array $user is declared to act as object to store each
        * key and value for that object. The $user object is then pushed on to the $users array that will hold all of the $user objects.
        * The $users array holding all $user objects is then returned
        */
        $stmt = $this->conn->prepare("SELECT user_id, user_email, user_password, subscription_type FROM user_account");
        $stmt->execute(); 
        $stmt->bind_result($id, $email, $password, $subscriber);
        $users = array(); 
        while($stmt->fetch())
        { 
            $user = array(); 
            $user['user_id'] = $id; 
            $user['user_email']=$email; 
            $user['user_password'] = $password; 
            $user['subscriber'] = $subscriber; 
            array_push($users, $user);
        }             
        
        return $users; 
    }

    /*
    - Read Operation -
    The getAllNews function returns all newsletters from the database.
    */
    public function getAllNews()
    {
        /*
        * See getAllUsers for explantation
        */ 
    
        $stmt = $this->conn->prepare("SELECT newsletter_id, news_title, news_date, news_image, news_text FROM newsletter");
        $stmt->execute(); 
        $stmt->bind_result($id, $title, $date, $image, $text);
        $newsletters = array(); 
        while($stmt->fetch())
        { 
            $news = array(); 
            $news['newsletter_id'] = $id; 
            $news['news_title']=$title; 
            $news['news_date'] = $date;
            $news['news_image'] = $image;  
            $news['news_text'] = $text; 
            array_push($newsletters, $news);
        }             
        
        return $newsletters; 
    }

    /*
    - Read Operation -
    The getLeagueTable function returns all league table results from the database.
    */
    public function getLeagueTable()
    {
        /*
        * See getAllUsers for explantation
        */ 

        $stmt = $this->conn->prepare("SELECT league_entry_id, team, position, games_played, games_won, games_drawn, games_lost, games_for, against, goal_difference, 
                                                                                                                                                total_points FROM league_entry");
        $stmt->execute(); 
        $stmt->bind_result($id, $team, $position, $played, $won, $drawn, $lost, $for, $against, $difference, $total);
        $league = array(); 
        while($stmt->fetch())
        { 
            $entry = array(); 
            $entry['league_entry_id'] = $id; 
            $entry['team']= $team; 
            $entry['position'] = $position;
            $entry['games_played'] = $played;  
            $entry['games_won'] = $won; 
            $entry['games_drawn'] = $drawn; 
            $entry['games_lost']= $lost; 
            $entry['for'] = $for;
            $entry['against'] = $against;  
            $entry['goal_difference'] = $difference; 
            $entry['total_points'] = $total;  
            array_push($league, $entry);
        }             
        
        return $league; 
    }

    /*
    - Read Operation -
    The getAllClubInfo function returns all clubinfo results from the database.
    */
    public function getAllClubInfo()
    {

        /*
        * See getAllUsers for explantation
        */ 

        $stmt = $this->conn->prepare("SELECT club_id, club_title, club_date, club_image, club_text FROM club_information");
        $stmt->execute(); 
        $stmt->bind_result($id, $title, $date, $image, $text);
        $clubs = array(); 
        while($stmt->fetch())
        { 
            $entry = array(); 
            $entry['club_id'] = $id; 
            $entry['club_title']=$title; 
            $entry['club_date'] = $date;
            $entry['club_image'] = $image;  
            $entry['club_text'] = $text; 
            array_push($clubs, $entry);
        }             
        
        return $clubs; 
    }
    
    /*
    - Read Operation -
    The getAllCoopEvents function returns all coopevent results from the database.
    */
    public function getAllCoopEvents()
    {

        /*
        * See getAllUsers for explantation
        */ 

        $stmt = $this->conn->prepare("SELECT coop_event_id, coop_title, coop_date, coop_image, coop_text FROM coop_event");
        $stmt->execute(); 
        $stmt->bind_result($id, $title, $date, $image, $text);
        $coops = array(); 
        while($stmt->fetch())
        { 
            $entry = array(); 
            $entry['coop_event_id'] = $id; 
            $entry['coop_title']=$title; 
            $entry['coop_date'] = $date;
            $entry['coop_image'] = $image;  
            $entry['coop_text'] = $text; 
            array_push($coops, $entry);
        }             
        
        return $coops; 
    }
    
    /*
    - Read Operation -
    The getAllMatchFixtures function returns all match fixture results from the database.
    */
    public function getAllMatchFixtures()
    {

        /*
        * See getAllUsers for explantation
        */ 

        $stmt = $this->conn->prepare("SELECT fixture_id, fixture_title, fixture_date, fixture_image, fixture_text FROM match_fixture");
        $stmt->execute(); 
        $stmt->bind_result($id, $title, $date, $image, $text);
        $fixtures = array(); 
        while($stmt->fetch())
        { 
            $entry = array(); 
            $entry['fixture_id'] = $id; 
            $entry['fixture_title']=$title; 
            $entry['fixture_date'] = $date;
            $entry['fixture_image'] = $image;  
            $entry['fixture_text'] = $text; 
            array_push($fixtures, $entry);
        }             
        
        return $fixtures; 
    }
    
    /*
    - Read Operation -
    The getAllMatchReports function returns all match fixture reports from the database.
    */
    public function getAllMatchReports()
    {

        /*
        * See getAllUsers for explantation
        */ 

        $stmt = $this->conn->prepare("SELECT match_report_id, match_title, match_score , match_date, match_image, match_type FROM match_report");
        $stmt->execute(); 
        $stmt->bind_result($id, $title, $score, $date, $image, $type);
        $reports = array(); 
        while($stmt->fetch())
        { 
            $entry = array(); 
            $entry['match_report_id'] = $id; 
            $entry['match_title']=$title; 
            $entry['match_score'] = $score;
            $entry['match_date'] = $date;
            $entry['match_image'] = $image;  
            $entry['match_type'] = $type; 
            array_push($reports, $entry);
        }             
        
        return $reports; 
    }

    /*
    - Read Operation -
    The getAllMatchReports function returns all players from the database.
    */
    public function getAllPlayers()
    {

        /*
        * See getAllUsers for explantation
        */ 

        $stmt = $this->conn->prepare("SELECT player_id, year, player_role, player_image, player_name, player_position FROM player");
        $stmt->execute(); 
        $stmt->bind_result($id, $year, $role, $image, $name, $position);
        $players = array(); 
        while($stmt->fetch())
        { 
            $entry = array(); 
            $entry['player_id'] = $id; 
            $entry['year']=$year; 
            $entry['player_role'] = $role;
            $entry['player_image'] = $image;
            $entry['player_name'] = $name;  
            $entry['player_position'] = $position; 
            array_push($players, $entry);
        }             
        
        return $players; 
    }
  
    /*
    - Update Operation -
    The updateUser function will update an existing user in the database.
    The function takes 3 parameters, email address, password and subscriber value.
    */
    public function updateUser($id, $email, $password)
    {
        //connects to the database, finds the user_account table and sets user_email, user_password and subscription_type by id.
        $stmt = $this->conn->prepare("UPDATE user_account SET user_email = ?, user_password = ? WHERE user_id = ?");
        $stmt->bind_param("ssi", $email, $password, $id);
        if($stmt->execute())
        {
            return true; 
        }         
        
        return false;
    }

    public function updateSubscription($id, $subscriber)
    {
        //connects to the database, finds the user_account and sets subscription_type by id.
        $stmt = $this->conn->prepare("UPDATE user_account SET subscription_type = ? WHERE user_id = ?");
        $stmt->bind_param("ii", $subscriber, $id);
        if($stmt->execute())
        {
            return true; 
        }         
        
        return false;
    }
    
    /*
    - Delete Function -
    The deleteUser function will delete a specified user from the database.
    */
    public function deleteUser($id)
    {
        $stmt = $this->conn->prepare("DELETE FROM user_account WHERE user_id = ?");
        $stmt->bind_param("i", $id);
        
        //if the statement is executed then the user will be deleted from the database.
        if($stmt->execute())
        {
            return true; 
        }
        
        //else the user was not deleted and the return value is false.
        return false;   
    }
    
}