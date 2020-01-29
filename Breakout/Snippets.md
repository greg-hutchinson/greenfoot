

# Goals

- To introduce you to the fundamentals of computer animation
- To learn what it means to write code and have a running program
    - Crash course in Java
- To pair program
- To have fun

# Code
- Is execute from top to bottom within a block (more on this later)
- Is executed in order
- Might have conditional statements
- Might have repetitional statements

Think of it like reading a very detailed recipe.

# Example

    cup = new Cup
    cup.addItems(pen, pencil, eraser, feather)
    totalWeight = EMPTY_CUP_WEIGHT
    For each item in cup {
        temp = item.weight  //get the items weight
        if (item == feather) {
            //Do Nothing with Feathers
        }
        else {            
            add the itemWeight to totalWeight
        }
    }
    //This next line prints out what???
    print totalWeight

# Java
- Java is an object oriented language.
    - Not a functional language or a procedural language
- The basic programming structure is a Class
- Classes have fields and methods (methods are also called functions)
- Fields are defined by dataTypes and names
    - int x // defines the variable x of type int (Integer)
    - String str  // defines the variable str of type String.
- Methods are a sequence of statements
- Statements always end in a ***;***

# A Sample Class
```Java
public class Rocket extends Actor { //This defines the class - to matching }
    public void act()  {            //This is a method - to matching }
        move(10);                   // This is a (simple) statement
        if (getX() >= 1199) {       // This is an if statement - to matching }
            setRotation(180 - getRotation() );
        }
        //This is a comment line - it is ignored by the compiler
    }

    public void addedToWorld(World aWorld) {  //This is another method
        setRotation(45);
    }
}   //This } marks the end of the class Rocket
```
# The Greenfoot metaphor
There are two primary types of objects in the Greenfoot environment. Either Worlds or Actors. For now, forget about Worlds - these will be explained
later. Everything else is represented as a subclass of the class Actor. You will make many
of these classes. A class to represent a ball, a paddle, etc. Each actor must implement a
simple method called act. Within this method you must tell your actor what to do. This method
will be called by the Greenfoot system every 10ms. Actors

# The Greenfoot Coordinate System
A computer screen can be thought of as a large grid of small points
(for example, 1000 x 1000) with (0,0) as the top left corner of the
screen. (X increases to the right, Y increases towards the bottom -
which is upside down to how we learned this in elementary math).
For now, let’s just imagine it as a 10 x 10 grid of points.
If we then say that there is a ball at x = 2 and y = 2, we should
envision this:

<img src="images/screen.png" alt="Coordinate System" style="width: 500px;"/>


# Greenfoot Integrated Development Environment (IDE)

# Classes, Methods and all that Stuff
    public class Rocketship extends Actor
    {
    //This is called by the greenfoot system ~ every 1/10 of a second.
        public void act() {
    	     move(3) ;		//statements always end with a ;
        }

        public void shoot() {
    	     //This is a comment. No code here yet
        }
    }


## Actors can move, turn, and report where they in the world
    move(4);          //move the actor 4 cells in the current direction
    setRotation(90);  //facing straight south - 0 faces east - this is default
    turn(180);        //Now would be facing north
    int x = getX();   //getX() returns the actor’s current x coordinate
    int y = getY();   //getY() returns the actor’s current y coordinate
    System.out.println ("x = " + x + " y = " + y);
Actors can do a lot more than this but that comes later.

## Functions


## Comparison - usually used in if statements

- <, <=, >, >=   	//These should be clear
- !=, == 		// Not equal, and is equal to


# The “If” statement
    public void act()
    {
      if ( getX() <= 500 ) {  //between () must result in a true or false expression
          move(8);            //this line is executed only if the above is true
      }
      else {
          move(1);              //move slower
      }
   }

***Note:*** the use of **(** **)** and **{** **}** above - I will explain

# Let's make a Ball class
- How to create a Class
- How to assign an image to a Class
- How to place it on the screen

# Understanding Rotation
All Actors have a current Rotation which by default is set to 0 degrees.
You can think of this as facing east. We can change the Rotation of an
Actor at any time with the following code snippet.

    setRotation(180); //Facing West

# Making the Ball bounce
We want the ball to bounce (in this phase) as soon as it gets to
the right edge of the screen (or to the left edge). Making something
bounce in the horizontal direction is quite easy. We just subtract
its currentRotation number from 180. One can easily see this with
a simple example. If the current rotation is facing east (0 degrees) and we
want to bounce, we would want to be facing due West (180 degrees). One
can easily see that (180 - 0) would give us the new value 180.

    setRotation(180 - getRotation()); //Bounce in x direction

Bouncing in the vertical direction is similar however, we need to subtract
from 360 instead. Again assume we are going due south (90 degrees) if we
subtract that from 360 that would leave 270 (or due north)

    setRotation(360 - getRotation()); //Bounce in y direction

Wrapping these up into nice methods makes them easier to use

    public void changeXDirection() {
        int current = getRotation();
        setRotation(180 - current);
    }

    public void changeYDirection() {
        int current = getRotation();
        setRotation(360 - current);
    }




# Java Types
There are many types in Java - a couple worth noting for now

- int - can hold any integer value in the range -2,147,483,648 to 2,147,483,647
Can be added or subtracted, multiplied or divided (remainder is dropped).
- String - is any representation of a piece of text “Hello World”
Can be added “Hello” + “World” would be “HelloWorld”
- ints can be added to Strings but not vice versa
  - "You must be " + 8 + "years old"
  - 8 + " years old"     //Won’t work



# Java Variables
Variables are used to hold on to other Java objects. Variables must be declared before they can be used.

    int x;	//declares variable x of type int.
    String s; //delcares variable s of type String.
    Rocketship  paddle;
    // Now they can be assigned to something
    x = “dsaf”;
    s = “Greg”;

# Assignment - “=”
When you read this use the word “becomes”

    x = getX();
Should be read as - The variable x becomes the value of what the getX() function returned”


# User Input - The Greenfoot class
In the documentation you will find the Greenfoot class as well. One method worth noting is Greenfoot.isKeyDown(String aKey)
We can now make a method like the following

    private boolean shouldMoveLeft() {
      return Greenfoot.isKeyDown(“left”);
    }

and then use it in our act() method like this
    if (shouldMoveLeft()) {
		   // you decide what to do
    }


# Making Sound - The GreenfootSound class
In the documentation you will find the GreenfootSound class.
One way to play sound is by the following snippet.

    GreenfootSound sound = new GreenfootSound("ping.wav");
    sound.play();
    //of course there are many other methods - see the Docs.
    //One that is also interesting might be sound.setVolume(anInt);



# Object Collision - The Actor class
    Paddle paddle = (Paddle) getOneIntersectingObject(Paddle.class);
    if (paddle != null) {
		    //object collision did occur - do whatever
	  }
    else {
		  //object collision did not occur
	  }

# Exercise - Create the Paddle Class
- Part 1
  - Create the Paddle class and give it a good image. (Copy from USB)
    - Needs to be put in the images subdirectory
  - Make it move left or right depending on keyboard input
- Part 2
  - Make the ball bounce off of the paddle as well
  - Make a sound when the ball strikes the paddle

# More on Variables

    int x;
    String s;
    x = 5;		//valid
    s = “Hello”	//valid
    x = “Hello”	//Invalid

# More on Variables
When you declare a variable it always has the same format;

    	javaType variableName ;
For example

    	int x;           //Which is the variable name?
    	String s;        //Which is the type?
    	Paddle paddle;   //This confuses people


# Greenfoot - the World Class
Many interesting methods - the most useful is the addObject method (This snippet must be executed within a World Class)

    Paddle paddle = new Paddle();
    addObject(paddle, getWidth() / 2, 50);	//Add the paddle in the middle, 50



# Greenfoot - the Actor Class
When an actor is added to a World class, the actor will be informed. The way this happens is the actor is sent the addedToWorld() message.

    public void addedToWorld(World aWorld) {
    	//Do whatever you would like here - this is only executed once per instance
      img = new GreenfootImage(20,aWorld.getHeight());
      img.setColor(Color.CYAN);
      img.fill();
      setImage(img);
    }

# Java - iteration (looping)

    // World Class Snippet
    for (int x= 1; x<= 4; x++) {
        System.out.println(“X = “ + x);
        Paddle paddle = new Paddle();
        addObject(paddle, x*30, getHeight());
    }




# Todo
- Give them access to a paddle?
- Access to the sound? ping.wav, pacman.wav
- Bricks, Smoke

# Cheat Sheet
- When you add a new method, it must go after the last closing }
of the last method, but BEFORE the last } of the class

      public class Ball {

        public void act() {
          // code for act goes here ....
        }
      // New method must go here.
      }
- if statements must be
      if ( someExpression ) {   //Note the () and {
          // do some more code if the above is true
      }   //Note the close of the if



# Random Snippets

    public void addedToWorld(World aWorld) {
        setRotation(45);
    }


    public void act()
    {
        move(10);


        if (getX() >= 799)
            changeXDirection();
        if (getX() < 1)
           changeXDirection();

        if (getY() >= 599)
            setRotation(- getRotation());
        if (getY() < 1)
            setRotation( - getRotation());
    //        System.out.println(getWidth());
    }

    public Breakout getBreakout() {
        return (Breakout) getWorld();
    }

    public int getWidth() {
        return getBreakout().getWidth();
    }

    }
