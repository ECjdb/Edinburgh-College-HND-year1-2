<?php

use Psr\Http\Message\ServerRequestInterface as Request;
use Psr\Http\Message\ResponseInterface as Response;

require_once '../include/DbHandler.php';
require '../vendor/autoload.php';

$app = new \Slim\App;

/**
 * Description of DbHandler
 * This class contains all API calls to the database
 * @author EC1524329
 */

/** 
 * Create user API calls.
 */

 //Create User - This API call handles create user POST requests from the front end,
 //send via Retrofit2 POST request.
$app->post('/createUser', function(Request $request, Response $response)
{
    //the first thing needing to be identified is whether or not the parameters that have been sent
    //are empty or not. Here we are passing in 3 parameters, email, password and subscriber.
    if(!haveEmptyParameters(array('email', 'password', 'subscriber'), $request, $response))
    {
        //The data contained in the request variable is parsed and stored in the request_data variable.
        $request_data = $request->getParsedBody(); 
        //The data held within each parameter from the parsed request_data variable
        //is then individually stored each in their own variable.
        $email = $request_data['email'];
        $password = $request_data['password'];
        $subscriber = $request_data['subscriber'];
        //create new instance of DbHandler
        $db = new DbHandler; 

        //create variable result and call createUser function, passing in the variable parameters.
        $result = $db->createUser($email, $password, $subscriber);
        
        //if the returned result equals USER_CREATED_SUCCESSFULLY.
        if($result == USER_CREATED_SUCCESSFULLY)
        {
            //message array stores error as false, message as created successfully, encodes the JSON response and writes it back
            //to the front end, with the respective code.
            $message = array(); 
            $message['error'] = false; 
            $message['message'] = 'User created successfully';
            $response->write(json_encode($message));
            return $response
                        ->withHeader('Content-type', 'application/json')
                        ->withStatus(201);
        }
        //else if the returned result is equal to USER_CREATE_FAILED, then error is true, an appropriate message is added
        //the reponse is then JSON encoded and sent back to the fron end with the respective error code.
        else if($result == USER_CREATE_FAILED)
        {
            $message = array(); 
            $message['error'] = true; 
            $message['message'] = 'An error has occurred, please try again';
            $response->write(json_encode($message));
            return $response
                        ->withHeader('Content-type', 'application/json')
                        ->withStatus(422);    
        }
        //else if the returned result is equal to USER_ALREADY_EXISTS, then error is true, an appropriate message is added
        //the reponse is then JSON encoded and sent back to the fron end with the respective error code.
        else if($result == USER_ALREADY_EXISTS)
        {
            $message = array(); 
            $message['error'] = true; 
            $message['message'] = 'User Already Exists';
            $response->write(json_encode($message));
            return $response
                        ->withHeader('Content-type', 'application/json')
                        ->withStatus(422);    
        }
    }
    return $response
        ->withHeader('Content-type', 'application/json')
        ->withStatus(422);    
});

//User Login - This API call is reponsible for handling the user login response,
//sent via retrofit2 POST request.
$app->post('/userLogin', function(Request $request, Response $response)
{
    //the first thing needing to be identified is whether or not the parameters that have been sent
    //are empty or not. Here we are passing in 2 parameters, email,and password.
    if(!haveEmptyParameters(array('email', 'password'), $request, $response))
    {
        //if none of the parameters are empty, we parse the content and store it in the request_data variable.
        $request_data = $request->getParsedBody(); 
        //similar to the create user call, each parameter is stored in its own variable.
        $email = $request_data['email'];
        $password = $request_data['password'];
        
        $db = new DbHandler; 
        
        //create result variable and store the result from the function call userLogin.
        $result = $db->userLogin($email, $password);

        //if the result returned equals USER_AUTHENTICATED then the user was found successfully.
        if($result == USER_AUTHENTICATED)
        {
            //create the user variable and store the data from the getUserByEmail function.
            //takes email address as an argument so the correct user can be identified.
            //encode the response in JSON and write the data stored in user to the response variable
            //and return the data to the front end, with its respective response code.
            $user = $db->getUserByEmail($email);
            $response_data = array();
            $response_data['error']=false; 
            $response_data['message'] = 'Login Successful';
            $response_data['user']=$user; 
            $response->write(json_encode($response_data));
            return $response
                ->withHeader('Content-type', 'application/json')
                ->withStatus(200);
        }
        //if the result returned is equal to USER_NOT_FOUND then an array is created an appropriate message is added
        //the reponse is then JSON encoded and sent back to the fron end with the respective error code.
        else if($result == USER_NOT_FOUND)
        {
            $response_data = array();
            $response_data['error'] = true; 
            $response_data['message'] = 'User does not exist';
            $response->write(json_encode($response_data));
            return $response
                ->withHeader('Content-type', 'application/json')
                ->withStatus(200);    
        }
        //if the result returned is equal to USER_PASSWORD_DOES_NOT_MATCH then an array is created an appropriate message is added
        //the reponse is then JSON encoded and sent back to the fron end with the respective error code.
        else if($result == USER_PASSWORD_DOES_NOT_MATCH)
        {
            $response_data = array();
            $response_data['error'] = true; 
            $response_data['message'] = 'Invalid credential';
            $response->write(json_encode($response_data));
            return $response
                ->withHeader('Content-type', 'application/json')
                ->withStatus(200);  
        }
    }
    return $response
        ->withHeader('Content-type', 'application/json')
        ->withStatus(422);    
});

// Have Empty Params - This function checks to see if parameters are empty or not.
function haveEmptyParameters($required_params, $request, $response){
    //sets error variable to false
    $error = false; 
    //sets error_params variable to empty string.
    $error_params = '';
    //parse the content contained within the request variable and store it in error_params string variable.
    $request_params = $request->getParsedBody(); 
    //goes through each required parameter individually, for each parameter. 
    foreach($required_params as $param)
    {
        //isset determines if a variable is declared and set. If it is not set (Null/empty) or 
        //if the length of the string length 'strlen' is less than or equal to zero
        if(!isset($request_params[$param]) || strlen($request_params[$param])<=0)
        {
            //error is set to true.
            $error = true; 
            //adds the parameter in question to the error_params string and adds a comment
            //allowing for additional errors found to be added to the string.
            $error_params .= $param . ', ';
        }
    }
    //if error is true
    if($error)
    {
        //create an array, store error equal to true, store message including the missing parameters
        //return to the response to the front end.
        $error_detail = array();
        $error_detail['error'] = true; 
        $error_detail['message'] = 'Required parameters ' . substr($error_params, 0, -2) . ' are missing or empty';
        $response->write(json_encode($error_detail));
        
    }
    return $error; 
}

/** 
 * Below are the Request API calls.
 * The get All API requests are identical but call each unique table and return their unique objects
 * in an array. The array is encoded in JSON and is handled on the front end via retrofit2 GET request.
 */

/*
* http://localhost/rcfcapp/v1/allusers
*/
$app->get('/allusers', function(Request $request, Response $response)
{
    $db = new DbHandler;
    $users = array();
    $users = $db->getAllUsers();

    echo json_encode($users);
});

/*
* http://localhost/rcfcapp/v1/allnews
*/
$app->get('/allnews', function(Request $request, Response $response)
{
    $db = new DbHandler;
    $newsletters = array();
    $newsletters = $db->getAllNews();

    echo json_encode($newsletters);
});

/*
* http://localhost/rcfcapp/v1/allleague
*/
$app->get('/allleague', function(Request $request, Response $response) 
{
    $db = new DbHandler();
    $league = array();
    $league = $db->getLeagueTable();

    echo json_encode($league);
});

/*
* http://localhost/rcfcapp/v1/allclub
*/
$app->get('/allclub', function(Request $request, Response $response) 
{
    $db = new DbHandler();
    $club = array();
    $club = $db->getAllClubInfo();

    echo json_encode($club);
});

/*
* http://localhost/rcfcapp/v1/allcoop
*/
$app->get('/allcoop', function(Request $request, Response $response) 
{
    $db = new DbHandler();
    $coop = array();
    $coop = $db->getAllCoopEvents();

    echo json_encode($coop);
});

/*
* http://localhost/rcfcapp/v1/allfixtures
*/
$app->get('/allfixtures', function(Request $request, Response $response) 
{
    $db = new DbHandler();
    $fixture = array();
    $fixture = $db->getAllMatchFixtures();

    echo json_encode($fixture);
});

/*
* http://localhost/rcfcapp/v1/allreports
*/
$app->get('/allreports', function(Request $request, Response $response) 
{
    $db = new DbHandler();
    $report = array();
    $report = $db->getAllMatchReports();

    echo json_encode($report);
});

/*
* http://localhost/rcfcapp/v1/allplayers
*/
$app->get('/allplayers', function(Request $request, Response $response) 
{
    $db = new DbHandler();
    $player = array();
    $player = $db->getAllPlayers();

    echo json_encode($player);
});

/** 
 * Below are the Update API calls.
 */

// Update User - The update user api call handles PUT requests from retrofit2.
// this call takes the id parameter as its argument.
$app->put('/updateUser/{id}', function(Request $request, Response $response, array $args)
{
    //stores the args array data in the id variable.
    $id = $args['id'];

    //the first thing needing to be identified is whether or not the parameters that have been sent
    //are empty or not. Here we are passing in 3 parameters, email, password and subscriber.
    if(!haveEmptyParameters(array('email','password'), $request, $response))
    {
        //The data contained in the request variable is parsed and stored in the request_data variable.
        $request_data = $request->getParsedBody(); 

        //The data held within each parameter from the parsed request_data variable
        //is then individually stored each in their own variable.
        $email = $request_data['email'];
        $password = $request_data['password'];
     
        $db = new DbHandler; 
        //Calls the updateUser function and passes the 4 parameters required to update the user stored in the database.
        if($db->updateUser($id, $email, $password))
        {
            //if the response data is returned as true, then a success message is stored in
            //the response_data array.
            $response_data = array(); 
            $response_data['message'] = 'User Updated Successfully';
            //the specfic user that was updated is then retrieved via the getUserByEmail
            //function and stored in response_data.
            $user = $db->getUserByEmail($email);
            $response_data['user'] = $user; 
            //the data in response_data is then JSON encoded and returned to the front end
            //with the appropriate response.
            $response->write(json_encode($response_data));
            return $response
            ->withHeader('Content-type', 'application/json')
            ->withStatus(200);  
        
        }
        else
        {
            //if the response data is returned as false, then a failure message is stored in
            //the response_data array.
            $response_data = array(); 
            $response_data['message'] = 'An error has occured, please try again';
            //the specfic user that was attempted to be updated is then retrieved via the getUserByEmail
            //function and stored in response_data.
            $user = $db->getUserByEmail($email);
            $response_data['user'] = $user; 
            //the data in response_data is then JSON encoded and returned to the front end
            //with the appropriate response.
            $response->write(json_encode($response_data));
            return $response
            ->withHeader('Content-type', 'application/json')
            ->withStatus(200);   
        }
    }
    
    return $response
    ->withHeader('Content-type', 'application/json')
    ->withStatus(200);  
});

// Update subscription - The update subscription api call handles PUT requests from retrofit2.
// this call takes the id parameter as its argument.
$app->put('/updateSubscription/{id}', function(Request $request, Response $response, array $args)
{
    //stores the args array data in the id variable.
    $id = $args['id'];

    //the first thing needing to be identified is whether or not the parameters that have been sent
    //are empty or not. Here we are passing in 1 parameter subscriber.
    if(!haveEmptyParameters(array('subscriber'), $request, $response))
    {
        //The data contained in the request variable is parsed and stored in the request_data variable.
        $request_data = $request->getParsedBody(); 

        //The data held within each parameter from the parsed request_data variable
        //is then individually stored each in their own variable.
        $subscriber= $request_data['subscriber'];
     
        $db = new DbHandler; 
        //Calls the updateSubscription function and passes the 2 parameters required to update the user stored in the database.
        if($db->updateSubscription($id, $subscriber))
        {
            //if the response data is returned as true, then a success message is stored in
            //the response_data array.
            $response_data = array(); 
            $response_data['message'] = 'Subscription Successful!';
            //the specfic user that was updated is then retrieved via the getUserById
            //function and stored in response_data.
            $user = $db->getUserById($id);
            $response_data['user'] = $user; 
            //the data in response_data is then JSON encoded and returned to the front end
            //with the appropriate response.
            $response->write(json_encode($response_data));
            return $response
            ->withHeader('Content-type', 'application/json')
            ->withStatus(200);  
        
        }
        else
        {
            //if the response data is returned as false, then a failure message is stored in
            //the response_data array.
            $response_data = array(); 
            $response_data['message'] = 'An error has occured, please try again';
            //the specfic user that was attempted to be updated is then retrieved via the getUserByEmail
            //function and stored in response_data.
            $user = $db->getUserById($id);
            $response_data['user'] = $user; 
            //the data in response_data is then JSON encoded and returned to the front end
            //with the appropriate response.
            $response->write(json_encode($response_data));
            return $response
            ->withHeader('Content-type', 'application/json')
            ->withStatus(200);   
        }
    }
    
    return $response
    ->withHeader('Content-type', 'application/json')
    ->withStatus(200);  
});

/** 
* Below are the Delete API calls.
*/

$app->delete('/deleteUser/{id}', function(Request $request, Response $response, array $args)
{
    //The 'id' key value passed in to the deleteUser function is stored in $id
    $id = $args['id'];
    $db = new DbHandler; 
    $response_data = array();
    
    //call is made to delete user passing the value stored in $id
    if($db->deleteUser($id))
    {
        //if the user is successfully deleted then return this message
        $response_data['message'] = 'User has been successfully deleted';    
    }
    else
    {
        //else an error has occured
        $response_data['message'] = 'An error has occured, please try again.';
    }
    
    //response is returned to the front-end application.
    $response->write(json_encode($response_data));
    return $response
    ->withHeader('Content-type', 'application/json')
    ->withStatus(200);
});
$app->run();