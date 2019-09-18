import java.util.*;

public class Battleship {
    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();
    public static int [][] pcord = new int[10][10];         //player coordinates
    public static int [][] compcord = new int[10][10];      //computer coordinates
    public static void main(String[] args) {

        intro();
        playerShip();
        compShip();
        battle();

    }
        public static void intro(){

            System.out.println("**** Welcome to Battle Ships game ****");
            System.out.println("Right now, the sea is empty");
            System.out.println("   0123456789");
            for(int i=0 ; i<10; i++){
                System.out.print(i +" |");
                for(int j=0; j<10; j++){
                    System.out.print(" ");
                }
                System.out.println("| " + i);
            }
            System.out.println("   0123456789");
        }



        public static void playerShip(){



        for(int i=1; i<6; i++){

        System.out.print("Enter X co-ordinate for your " + i +". ship: ");
        int x = input.nextInt();
        while(x < 0 || x > 9 ){
            System.out.println("X co-ordinates out of the grid.Enter it within the grid");
            System.out.print("Enter X co-ordinate for your " + i +". ship: ");
            x = input.nextInt();
            }
        System.out.print("Enter Y co-ordinate for your " + i +". ship: ");
        int y = input.nextInt();
        while(y < 0 || y > 9 ){
                System.out.println("Y co-ordinates out of the grid.Enter it within the grid");
                System.out.print("Enter Y co-ordinate for your " + i + ". ship: ");
             y = input.nextInt();
            }
        while (pcord[x][y] == 1){
            System.out.println("You already placed a ship at this location..!");
            System.out.print("Enter X co-ordinate for your " + i + ". ship: ");
             x = input.nextInt();
            while(x < 0 || x > 9 ){
                System.out.println("X co-ordinates out of the grid.Enter it within the grid");
                System.out.print("Enter X co-ordinate for your " + i + ". ship");
                x = input.nextInt();
            }
            System.out.print("Enter Y co-ordinate for your " + i + ". ship: ");
             y = input.nextInt();
            while(y < 0 || y > 9 ){
                System.out.println("Y co-ordinates out of the grid.Enter it within the grid");
                System.out.print("Enter Y co-ordinate for your " + i + ". ship: ");
                y = input.nextInt();
            }

        }
        pcord[x][y] =1;


        }

        System.out.println("The current state of the player's ship is as below:");
        System.out.println("   0123456789");
            for(int i=0 ; i<10; i++){
                System.out.print(i +" |");
                for(int j=0; j<10; j++){
                    if(pcord[i][j] ==1){System.out.print("@");}
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println("| " + i);
            }
            System.out.println("   0123456789");

        }

        public static void compShip(){
        System.out.println("Computer is deploying ships");
        for (int i =1 ; i<6; i++){
         int x = rand.nextInt(10);
         int y = rand.nextInt(10);
            while (pcord[x][y] == 1 || compcord[x][y] == 1){
                x = rand.nextInt(10);
                y = rand.nextInt(10);
            }
            compcord[x][y] =1;
            System.out.println(i+ ". ship DEPLOYED");

        }
        }
        public static void battle(){
        int pship =5, cship=5;

        while(pship>0 && cship >0){

            //Player Turn
            System.out.println("YOUR TURN");
            System.out.print("Enter X coordinate: ");
            int x = input.nextInt();
            while(x < 0 || x > 9 ){
                System.out.println("X co-ordinates out of the grid.Enter it within the grid");
                System.out.print("Enter X co-ordinate: ");
                x = input.nextInt();
            }
            System.out.print("Enter Y coordinate: ");
            int y = input.nextInt();
            while(y < 0 || y > 9 ){
                System.out.println("Y co-ordinates out of the grid.Enter it within the grid");
                System.out.print("Enter Y co-ordinate: ");
                y = input.nextInt();
            }
            if(pcord[x][y] == 1){
                System.out.println("Oh no, you sunk your own ship :(");
                pcord[x][y] = 3;
                pship -= 1;
                if (pship ==0) break;
            }
            else if(compcord[x][y] == 1){
                System.out.println("Boom! You sunk the ship!");
                compcord[x][y]=3;
                cship -= 1;
                if (cship == 0) break;
            }
            else{
                System.out.println("Sorry...You missed");
                pcord[x][y] =2;
            }

            // Computer's Turn
            System.out.println("COMPUTER TURN");
            int a =rand.nextInt(10);
            int b =rand.nextInt(10);

            while (compcord[a][b] == 2 || compcord[a][b] == 3|| pcord[a][b] == 3){
                a = rand.nextInt(10);
                b = rand.nextInt(10);
            }

            if(compcord[a][b] == 1){
                System.out.println("The Computer sunk one of its own ships");
                compcord[a][b] = 3;
                cship -= 1;
                if (cship ==0) break;
            }
            else if(pcord[a][b] == 1){
                System.out.println("The Computer sunk one of your ships!");
                pcord[a][b]=3;
                pship -= 1;
                if (pship == 0) break;
            }
            else{
                System.out.println("Computer missed");
                compcord[a][b] =2;
            }

            //printing the current state

            System.out.println("   0123456789");
            for(int i=0 ; i<10; i++){
                System.out.print(i +" |");
                for(int j=0; j<10; j++){
                    if(pcord[i][j] ==1){System.out.print("@");}
                    else if(pcord[i][j]==3){System.out.print("x");}
                    else if(pcord[i][j]==2){System.out.print("-");}
                    else if(compcord[i][j]==3){System.out.print("!");}
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println("| " + i);
            }
            System.out.println("   0123456789");

            System.out.println("Your ships: "+ pship +" | Computer ships: "+ cship);
        }

            System.out.println("Your ships: "+ pship +" | Computer ships: "+ cship);

        if (pship == 0){
            System.out.println("Sorry!..You loose..;(");}
         else{
                System.out.println("Hooray!! You won the battle :)");
        }

        }

}
