import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

//Art Parkeenvincha, Block 3, Starfield
Particle[] ball = new Particle[600];
int myWidth = 500;
int myHeight = 500;

//your code here
public void setup()
{
  size(myWidth, myHeight);
  for(int i = 0; i < ball.length-1; i++)
  {
    ball[i] = new NormalParticle();
  }
  ball[ball.length-1] = new OddballParticle();
  colorMode(HSB);
  noStroke();
}
public void draw()
{
  fill(0, 0, 80, 100);
  rect(0, 0, myWidth, myHeight);
  for(int i = 0; i < ball.length; i++)
  {
    ball[i].move();
    ball[i].show();
  }
}

public void keyPressed()
{
  for(int i = 0; i < ball.length-1; i++)
  {
    ball[i] = new NormalParticle();
  }
  ball[ball.length-1] = new OddballParticle();
}

class NormalParticle implements Particle
{
  double myX, myY, mySpeed, myAngle, mySize, myColor;
  NormalParticle()
  {
    myX = (myWidth/2);
    myY = (myHeight/2);
    mySpeed = (Math.random()*6);
    myAngle = Math.random()*2*Math.PI;
    mySize = Math.random()*8;
    myColor = Math.random()*255;
  }
  public void move()
  {
    myX += Math.cos(myAngle)*mySpeed;
    myY += Math.sin(myAngle)*mySpeed;
  }
  public void show()
  {
    fill((float)myColor, (float)255, (float)255);
    ellipse((float)myX, (float)myY, (float)mySize, (float)mySize);
  }
}
interface Particle
{
  public void move();
  public void show();
}
class OddballParticle implements Particle
{
  double myX, myY, myColor, mySize, myGrow;
  OddballParticle()
  {
    myX = Math.random()*myWidth;
    myY = Math.random()*myHeight;
    myColor = Math.random()*255;
  }
  public void move()
  {
    myX += (Math.random()*6)-3;
    myY += (Math.random()*6)-3;
  }
  public void show()
  {
    fill((float)myColor, (float)255, (float)255);
    if(frameCount % 30 == 0) {
      myGrow = 10;
    }
    if(mySize > 80) {
      mySize = 80;
      myGrow = -2;
    }
    if(mySize < 30) {
      mySize = 30;
      myGrow = 0;
    }
    
    ellipse((float)myX, (float)myY, (float)mySize, (float)mySize);
    
    mySize = mySize + myGrow;
  }
}


/*
Starfield with an Oddball
For this assignment you will make a simple animation of fireworks. This common animation is called a "starfield" since it can also be used to simulate movement through a field of stars.
 
Program requirements:
Your program must use two classes to model the particles. A "Normal" particle class and an "Oddball" partcle class
All the particles must be stored in a single array using an interface.
Your program must use at least one constant (for number of particles).
Steps to completing this assignment
Fork and clone down the Starfield repository,
First, finish the Particle class. It will need the following members:
5 data members: X and Y positions, Color, Angle and Speed. (Hint use doubles for X, Y, Speed and Angle)
Particle(), the class constructor
void move(), Takes the cos of the angle times the speed and adds it to the X coordinate. Does the same to Y with the sin of the angle.
void show(), sets the current color to the color of the particle and draws a dot using ellipse()
Now finish the program's setup and draw
Add one Particle variable, and see you can see it move
Now modify the program so you have an array of Particles.
 
Finish the Particle interface. It will list two methods:
public void show();
public void move();
Have your NormalParticle implement the Particle interface.
Add public in front of the move() & draw() methods in your Particle class.
Have your OddballParticle implement the Particle interface.
Finish OddballParticle class. It will be very similiar, but OddballParticles should have different move and draw methods.
Change your array of NormalParticles to an array of Particles.
Change the first element in the array to a OddballParticle instead of a NormalParticle
Submit the url of your GitHub webpage via the school loop drop box for the assignment
Extensions
Have a fun and be creative. If you have extra time you may want to modify your program and add extra features. Experiment with different arrangements of particles. Look at student work from previous years for other variations.
*/
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
