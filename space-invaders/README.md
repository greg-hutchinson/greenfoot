# SpaceInvaders Tutorial

## Setting up our World
Open Greenfoot and double-click on MyWorld.
- Now in the editor, everywhere that there is the word MyWorld replace it with 
SpaceInvadersWorld. (Note the capitalization). Change the size to 1024 by 800.
// super(1024, 800, 1); 
- Lets set a nice space type background as well.

## Reminder - Animation
Remember that animation is achieved by placing an object at an x, y location on the screen. Everytime the screen is redrawn if that x and/or y coordinate has changed the object will appear as if it had moved there. This can be thought of much like movie frames in film.


## Understanding Objects
- Assume we have a class of Person. Each person can know their name, age, and team that they belong to. They might also know how to do the following:
sit(), stand(), moveForward(someNumberOfSteps) //More on functions later
- Let's look at this on Miro
https://miro.com/app/board/uXjVO6NNQBE=/?moveToWidget=3458764526885156301&cot=14



## Understanding Actors
Actors are the basic building blocks within Greenfoot.
Explore how to create an Actor (Rocket)
- Set the icon
- Now we will use the Greenfoot environment to look at some of the methods 
inherited from Actor
- turn(), getRotation(), getX(), getY(), act()

Note that all Actors will have an act() method. This is where all (most) of your programming will occur.

## How to know what methods that Actors can respond to.
From your **main screen** in the Greenfoot environment, select Help then Greenfoot Class Documentation. 


## How To Do User Input
There is another class in the Greenfoot environment named - well - **Greenfoot**. This class provides some useful functions for communicating with the player of the game. One of these methods is the **isKeyDown** method.


So, after we understand how this method works, we can now make our act method look like this.  We haven't discussed the **if** statement yet, but for now, I think you will get the idea.


```Java
    public void act()
    {
        if (Greenfoot.isKeyDown("left")) {
            move (-5);
        }
    }
```
That works great - our Rocket now moves to the left. Enhance the code so that the Rocket will also move to the right.


## Understanding Variables in Java
Variables are things that can hold on to values that might change over the course of your program. Variables can be thought of as labelled "pockets" or "boxes" to hold things until you later want to retrieve the things or change the things. When we **declare** a variable we must also declare what **type** of object this variable is going to hold on to. For example, if I want a variable to hold on to the current x coordinate of something I might declare it like this.

    int x;

This says that x is a variable (named box) that can hold onto any integer value. (Integers are whole numbers - positive or negative).

Remember that any time you declare a variable you always declare the type first. So the general form for declaring variables is 

**someType** **variableName**

where some common **someTypes** are int, String, Object, or Rocket.

And remember to think of it as a named box where a value can be put in or taken out.

      +-----------+
    x |   300     |
      +-----------+
    
The way that we put things into the box is by assigning a value to the box. (i.e the value 300 was put into the above box by the following code)

    x = 300;    //Note the semicolon at the end;

and the way that we get values out of the box later is by refering to the box name.

    y = x + 1; 
    
IMPORTANT NOTE:
When there is an "=" sign you need to think of it as an assignment operation not as a mathematical equality sign so the above should be said as 
    "Take whatever is in box x, add 1 to it and put it in box y"

This would result in the following:

      +-----------+
    x |   300     |
      +-----------+

      +-----------+
    y |   301     |
      +-----------+

Variables must be defined within the class you are working in.
```Java
    public class YourClass extends Actor
    {
        //Variables must be defined here before the act method.
        //This is not always true, but for now - just trust me. :-)

        int numberOfPixels = 5;

        public void act() {
    	     move(5);   // hard-coded 5
             // is the same as ...
             move(numberOfPixels);
        }
    }
```

### First Exercise - Create some objects
- Create an Alien subclass (from Actor)
    - set the icon
    - make your Actor move across the screen from left to right 5 pixels
- Create a Rocket subclass (from Actor)
    - set the icon
    - make your Actor move across the screen from right to left 8 pixels

After you have the above working, change the numbers in your move statement to use a variable of type int.



## Understanding the if statement
# The “If” statement
The if statement must occur within your act() method.
```Java
    ...
    if ( someBooleanExpression ) {
        statement1;
        statement2;
            ...
        statementN;
    }
    else {
        elseStatement1;
        elseStatement2;
            ...
        elseStatementN;
      }
   }
```

Let's break that down - firstly what is someBooleanExpression. It is an expression that after it is evaluate results in a "true" or "false" value.  For example

    4 <= 6;  // this results in a "true" value
or

    int y = 10;
    y <= 6;  // this results in a "false" value.

or say that getX() is a function that currently returns 1 (If the Actor
was against the left side of the screen) then

    getX() <= 1    //this results in a "true" value.

Combining this we now have a valid "if" statement
```Java
if (getX() <= 1) {
    // Do something that makes sense here
    // Like ... Let's bounce 
}
```


```Java
    public void act()
    {
        int currentX = getX();
        int newX = currentX + x;
        if (newX <= 1) {
            x = -x;
        }
        if (newX >= getWorld().getWidth() - 1) {
            x = -x;
        }
        setLocation(newX, currentY);
    }


```



```Java
    public void act()
    {
        int currentX = getX();
        int newX = currentX + x;
        int currentY = getY();
        if (newX <= 1) {
            x = -x;
            currentY = getY() + 30; //
        }
        if (newX >= getWorld().getWidth() - 1) {
            x = -x;
            currentY = getY() + 30;
        }
        setLocation(newX, currentY);
    }
```     





## Collision Detection.
```Java
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (bullet != null) {
            SpaceInvadersWorld world = getWorldOfType(SpaceInvadersWorld.class);
            world.addScore(10);
            world.removeObject(bullet);
            world.removeObject(this);
        }

```



## Functions
- Notice the difference in Functions


Exercise
- Create an Alien



## Explain Object relationships




## Understanding the Environment


## Understanding Java





The first thing that we want to get working is to add some Aliens to our World that allows them to March across the screen.


1. Create a Class Crab
1. Give it an appropriate Icon
1. Make it move left to right on the screen. This should look funny because the crab is facing the wrong direction. How are we going to fix that?
1. Now when the crab gets to the border of the screen he should bounce. (go the other sideways direction)





Some useful Snippets of Code.
Whenever you need to get information to or from the SpaceInvadersWorld you need to do it with this line of code.
```Java
    SpaceInvadersWorld world = getWorldOfType(SpaceInvadersWorld.class);
```

Now you can invoke methods that exist within your SpaceInvadersWorld class like such


```Java
    SpaceInvadersWorld world = getWorldOfType(SpaceInvadersWorld.class);
    int width = world.getWidth();
```

