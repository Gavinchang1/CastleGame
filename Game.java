package media;

import java.util.Scanner;

public class Game {
    private Room currentRoom;

    public Game() 
    {
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom,basement,attic;

        //  ���췿��
        outside = new Room("�Ǳ���");
        lobby = new Room("����");
        pub = new Room("С�ư�");
        study = new Room("�鷿");
        bedroom = new Room("����");
        basement =new Room("������");
        attic =new Room("��¥");

        //  ��ʼ������ĳ���
        outside.setExits("east", lobby);
        outside.setExits("south", study);
        outside.setExits("west", pub);
        lobby.setExits("west", outside);
        pub.setExits("east", outside);
        study.setExits("north", outside);
        study.setExits("east", bedroom);
        bedroom.setExits("west", study);
        lobby.setExits("up", attic);
        attic.setExits("down", lobby);
        basement.setExits("up", lobby);
        lobby.setExits("down", basement);


        currentRoom = outside;  //  �ӳǱ����⿪ʼ
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("��ӭ�����Ǳ���");
        System.out.println("�����Ҫ������������ 'help' ��");
        System.out.println();
        showPrompt();
    }

    // ����Ϊ�û�����

    private void printHelp() 
    {
        System.out.print("��·������������������У�go bye help");
        System.out.println("�磺\tgo east");
    }

    private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.goExit(direction);
        if (nextRoom == null) {
            System.out.println("����û���ţ�");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }

    public void showPrompt() {
         System.out.println("����" + currentRoom);
         System.out.print("������: ");
         System.out.println(currentRoom.getExitDesc());
         System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        game.printWelcome();

        while ( true ) {
                String line = in.nextLine();
                String[] words = line.split(" ");
                if ( words[0].equals("help") ) {
                    game.printHelp();
                } else if (words[0].equals("go") ) {
                    game.goRoom(words[1]);
                } else if ( words[0].equals("bye") ) {
                    break;
                }
        }

        System.out.println("��л���Ĺ��١��ټ���");
        in.close();
    }
}