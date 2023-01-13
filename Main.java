import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        int flatStart= 0;
        int flatFinish=0;
        int prevX=0;
        int prevY=0;

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            if(prevY== landY){
                if (flatFinish == 0) {
                    flatStart = prevX;
                    flatFinish = landX;
                } else flatFinish = landX;
            } else{
                prevX = landX;
                prevY = landY;}
        }



        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).
            int speed=0;
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // rotate power. rotate is the desired rotation angle. power is the desired thrust power.

            if (X< flatStart){
                if (hSpeed<60) System.out.println("-40 4");
                if (hSpeed >= 60) System.out.println("20 4");
            }

            if (X> flatStart && X< flatFinish){
                if (hSpeed> 5) System.out.println("50 4");
                if (hSpeed<-5) System.out.println("-50 4");
                if (hSpeed<=5 && hSpeed >= -5) {
                    if(vSpeed< -39) System.out.println("0 4");
                    else if(vSpeed>= -39) System.out.println("0 2");;

                }
            }

            if (X> flatFinish){
                if (hSpeed>-60) System.out.println("40 4");
                if (hSpeed <= -60) System.out.println("-20 4");
            }

        }
    }
}