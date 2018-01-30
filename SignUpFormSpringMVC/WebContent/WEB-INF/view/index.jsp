<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="top-image">
                <img src="${pageContext.request.contextPath}/resources/images/img.jpg" alt="top-image">
                <p class="sign-in">SIGN IN</p>
            </div>
            <div class="for-form">
                <form action="display" class="formForSignIn" method="post">
                    <div class="box">
                        <div class="icon-box"><i class="fa fa-address-book-o" aria-hidden="true"></i></div>
                        <input type="text" name="first-name" id="first-name" placeholder="Sarah" required>
                    </div>
                    <div class="box">
                            <div class="icon-box"><i class="fa fa-address-card" aria-hidden="true"></i></div>
                        <input type="text" name="last-name" id="last-name" placeholder="Joe" required>
                    </div>
                    <div class="box">
                            <div class="icon-box"><i class="fa fa-user" aria-hidden="true"></i></div>
                        <input type="user-name" name="user-name" id="user-name" placeholder="SarahJoe5" required>
                    </div>
                    <div class="box">
                            <div class="icon-box"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                        <input type="email" name="email" id="email" placeholder="sarahjoe@gmail.com" required>
                    </div>
                    <div class="box">
                            <div class="icon-box"><i class="fa fa-phone-square" aria-hidden="true"></i></div>
                        <input type="phone" name="phone" id="phone" placeholder="98789 12345" required>
                    </div>
                    <div class="box">
                        <input type="submit" name="submit" id="submit" value="Sign Me Up Now" class="buttonSub">
                    </div>

                </form>
                <p class="lower-text">I already have an account. I want to Sign In.</p>
            </div>
        </div>
    </body>
</html>