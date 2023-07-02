<%-- 
    Document   : HealthReport
    Created on : Jul 1, 2023, 10:42:38 PM
    Author     : CIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
        <style>
            h1{
                text-align: center;
            }
            hr{
                border:2px solid black;
                width: 20%;
            }
            .container{
                border:2px solid black;
                width: 20%;
                margin-top: 20px;
  background-color: #fff;
  padding: 25px 30px;
  border-radius: 5px;
  font-weight: bold;
            }   
    form .button{
   height: 30px;
   width:50%;
   margin: 35px 0;
    }
   form .button input{
       height: 100%;
   width: 100%;
   border: none;
   
   font-size: 18px;
   font-weight: 500;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, #71b7e6, #9b59b6);
   }
   form .button input:hover{
  /* transform: scale(0.99); */
  background: linear-gradient(-135deg, #71b7e6, #9b59b6);
  }
 
   
 
        </style>
    </head>
    <body>
        <h1>Fetch Health Report</h1>
        <hr>
    <center>
        <div class="container">
        <form action="HealthReport" method="post">
        Email ID<input type="email" name="emailId"></td><!-- comment -->
       <div class="button">
                                <input type="submit" value="Submit">
                            </div>
        </form>
        </div></center>
    </body>
</html>
