    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
    <style>
    h1 {color:blue;}
    fieldset {
        background-color:  #dfdfdf;
        border:  1px solid #ccc;
        margin:  2em 0;
        padding:  1em;
    }
    </style>
    </head>
    <body>
    <form action="register" method='POST'>
        <h2>Fill up to register</h2>
        <fieldset style = "width:400px">
                    Enter Username<input type="text" name="username"> </br>
                    Enter Password <input type="text" name="password" /></br>
                    Enter Firstname <input type="text" name="firstname" /></br>
                    Enter Lastname<input type="text" name="lastname" /></br>
                    Enter Email <input type="text" name="email" /></br>
                    <label for="role">User- Role:</label>
                      <select name="role">
                        <option value="Admin">admin</option>
                        <option value="User">user</option>
                      </select>
                    </br>
                    </br>
                    </fieldset>
                    </br>
                    </br>
                     </br>
                        <input name="submit" type="submit" value="submit">

            </form>
    </body>
    </html>