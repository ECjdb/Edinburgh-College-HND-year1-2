<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of DbConnect
 * This class handles connect to the database
 * @author EC1524329
 */
class DbConnect 
{
    private $conn;
    
    function __construct() 
    {
        
    }
    
    /*
     * Establish connection to database
     * @return the database connection handler
     */
    
    function connect() 
    {
        //Include the database config file
        //include_once dirname(__FILE__) . './Config.php';
        
        include_once dirname(__FILE__) . './Config.php';
 
        // Connecting to mysql database
        $this->conn = new mysqli(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);
 
        // Check for database connection error
        if (mysqli_connect_errno()) 
        {
            echo "Failed to connect to MySQL: " . mysqli_connect_error();
            return null;
        }
 
        // returing connection resource
        return $this->conn;
    }
    
}
