<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /**
 * Description of config
 * This class contains information to connect to the database
 * @author EC1524329
 */

define('DB_USERNAME', 'root');
define('DB_PASSWORD', 'root');
define('DB_HOST', 'localhost');
define('DB_NAME','rosscounty');

define('USER_CREATED_SUCCESSFULLY', 100);
define('USER_CREATE_FAILED', 101);
define('USER_ALREADY_EXISTS', 102);
define('USER_AUTHENTICATED', 201);
define('USER_NOT_FOUND', 202); 
define('USER_PASSWORD_DOES_NOT_MATCH', 203);
define('PASSWORD_CHANGED', 301);
define('PASSWORD_DOES_NOT_MATCH', 302);
define('PASSWORD_NOT_CHANGED', 303);