# NiceStart

---

## Index

- ### [Design](#Design)
- ### [Layouts](#Layouts)

---

## Design
NiceStart's design is focused on being simple and responsive, using a blue color palette 
enlightened with a greyscale.
The used colors are:
- Black `#FF000000`
- White `#FFFFFFFF`
- Blue `#13678A` -> mainly used for the gradient background
- Emerald `#45C4B0` -> to draw attention to the buttons that are desired to be pressed 
- Transparent `#00FFFF00` -> for the outlined button style
 


## Layouts
NiceStart is composed by 3 layouts: a login page, a signup page and a main page where the user will 
be sent after completing one of the previous pages.
<br>
Every page has the app's logotype positioned on the top.

### Login
[see activity_login.xml](app/src/main/res/layout/activity_login.xml)
<br>
The login page has two inputs, one for the username and another for the password.
Under them there are positioned two buttons, which will allow the user to complete the login process 
and switch to the [signup page](#signup), respectively.
<br>
<img src="images/login.PNG" alt="login layout image" width="30%"/>
<img src="images/login-land.PNG" alt="login land layout image" width="65%"/>

### Signup
[see activity_signup.xml](app/src/main/res/layout/activity_signup.xml)
<br>
Our signup page is built quite simple, having only a username, email, password and password
confirmation input, all followed by a SIGNUP button that will complete the process and send the 
user to the [main page](#main). On the other hand, there is a CANCEL button that will stop the process and 
return the user to the [login page](#login).
<br>
It also has an ActionBar that can do the same as the CANCEL button - returning to the login page -.
<br>
<img src="images/signup.PNG" alt="signup layout image" width="30%"/>
<img src="images/signup-land.PNG" alt="signup land layout image" width="65%"/>


### Main
[see activity_main.xml](app/src/main/res/layout/activity_main.xml)
<br>
After completing the login/signup process the user will be sent to the main page although it only 
has an ActionBar, background image and logotype, so there's no difference with the landscape version.
<br>
<img src="images/main.PNG" alt="main layout image" width="30%"/>
<img src="images/main-land.PNG" alt="main land layout image" width="65%"/>


