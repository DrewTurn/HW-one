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

public class sketch_190916a extends PApplet {

PImage img,op,close, elevator;
int Timer = 0, elevatorFloor = 358;//start on the first floor 
boolean ePress = false, Emergency = false; 

public void setup() {
  
  img = loadImage("sectionDraft2.jpg");
   op =loadImage("op.png");
   close = loadImage("close.png");
  elevator = loadImage("elevator.jpg");//the celter is 87 px from the edge to then lineing up the x coord it is 250 - 87 = 163 the y for the floors are 563 -> 264
}

public void draw() {
   
  background(0);
  // Draw the image to the screen at coordinate (0,0)
  image(img,0,0);
  
  
  fill(216,21,35);
  rect(450, 50, 300, 200);
  
  
  fill(255,255,255);
  //op close buttons
  ellipse(500,400,75,75);
  ellipse(700,400,75,75);
  
  tint(255,127);
  imageMode(CENTER);
 
   image(op,500,400);  
   image(close,700,400);
  imageMode(CORNER);
 
  tint(255,200);
  //elevator setup
  image(elevator,163,elevatorFloor);
  tint(255,255);
  
  
  textSize(32);
  fill(6,26,5);
  textAlign(CENTER);
  text("EMERGENCY ONLY", 600, 150); 
  if (Emergency){
     rect(0, 0, 800, 500);
     textSize(50);
     fill(216,21,35);
     textAlign(CENTER);
     text("EMERGENCY PLEASE WAIT ",400,250);
     text("FOR HELP",400,300); 
     
  }
  else{
      mouseCheck(mouseX, mouseY);
  }
  
  if(ePress){
    
    Timer= Timer+1;
  }
  
}

public void mousePressed() {
  if(mouseX >450 && mouseX < 750 && mouseY >50 && mouseY < 250 && ePress == false){
    ePress = true;
  }
  if(mouseX >450 && mouseX < 750 && mouseY >50 && mouseY < 250 && ePress == true && Timer > 5){
   Emergency = true;
   
  }
  
      
      if(mouseX >5 && mouseX < 410 && mouseY >50 && mouseY < 150 && Emergency == false){
    elevatorFloor = 50;
  }  //4th
      if(mouseX >5 && mouseX < 410 && mouseY >150 && mouseY < 256&& Emergency == false){
    elevatorFloor = 154;
  } //3th
      if(mouseX >5 && mouseX < 410 && mouseY >256 && mouseY < 353&& Emergency == false){
    elevatorFloor = 260;
  }  //2th
      if(mouseX >5 && mouseX < 410 && mouseY >358 && mouseY < 464 && Emergency == false){
    elevatorFloor = 360;
  } //1th
  
  
  
  
}

public void mouseCheck(int x, int y){
  
      if(x >5 && x < 410 && y >50 && y < 150){
    fill(243,243,21,63);
    rect(5,50,388,100);
    
  }  //4th
      if(x >5 && x < 410 && y >150 && y < 256){
    fill(243,243,21,63);
    rect(5,150,388,100);
  } //3th
      if(x >5 && x < 410 && y >256 && y < 353){
    fill(243,243,21,63);
    rect(5,256,388,100);
  }  //2th
      if(x >5 && x < 410 && y >358 && y < 464){
    fill(243,243,21,63);
    rect(5,358,388,100);
  } //1th
  

  
  if(x >450 && x < 750 && y >50 && y < 250){
    fill(243,243,21,63);
    rect(450, 50, 300, 200);
  } //emergency
  
  //open  buttons
  float disX = 500 - mouseX;
  float disY = 400 - mouseY;
  
  if(sqrt(sq(disX) + sq(disY)) < 75/2) {
    fill(243,243,21,63);
  ellipse(500,400,75,75);
  }
  //close button
  disX = 700 - mouseX;  
  if(sqrt(sq(disX) + sq(disY)) < 75/2) {
    fill(243,243,21,63);
    ellipse(700,400,75,75);
  }
  
  
}


  public void settings() {  size(800, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_190916a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
