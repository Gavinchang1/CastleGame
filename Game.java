package castle;
import java.util.Scanner;
class Room {
    public Room goExit(String direction) {
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom =  northExit;
        }
        if(direction.equals("east")) {
            nextRoom =  eastExit;
        }
        if(direction.equals("south")) {
            nextRoom =  southExit;
        }
        if(direction.equals("west")) {
            nextRoom =  westExit;
        }
        return  nextRoom;
    }
    public String getExitDesc() {
           StringBuffer sb = new StringBuffer();
           if( northExit != null) 
               sb.append("north");
           if( eastExit != null) 
               sb.append("east");
           if( southExit != null) 
              sb.append("south");
           if( westExit != null) 
              sb.append("weat");
           System.out.println();
           return sb;
    }
}
public class Game {
     private void goRoom(String direction) 
     {
        Room nextRoom = currentRoom.goExit(direction);
            if (nextRoom == null) {
                System.out.println("那里没有门！");
            }
            else {
                currentRoom = nextRoom;
                showPrompt();
            }
        }
        public void showPrompt() {
            System.out.println("你在" + currentRoom);
            System.out.print("出口有: ");
          System.out.println(currentRoom.getExitDesc());
            System.out.println();
        }
 }