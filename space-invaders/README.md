# SpaceInvaders Tutorial

## Understanding Variables in Java
Variables are things that can hold on to values that might change over the course of your program. Variables can be thought of as labelled "pockets" or "boxes" to hold things until you later want to retrieve the things or change the things. When we **declare** a variable we must also declare what **type** of object this variable is going to hold on to. For example, if I want a variable to hold on to the current x coordinate of something I might declare it like this.

    int x;

This says that x is a variable (named box) that can hold onto any integer value. (Integers are whole numbers - positive or negative).

Remember that any time you declare a variable you always declare the type first.




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

