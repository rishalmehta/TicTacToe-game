//tic tac toe game

import java.util.*;

class Main{
    static String[] board;
    static String turn=null;
    static String winner=null;
    static int input;

    //checking for winner
    static String checkWinner(){
        String line=null;
        
        for(int i=0;i<8;i++){
            switch(i){
                case 0:
                    line=board[0]+board[1]+board[2];
                    break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                case 2:
                    line=board[6]+board[7]+board[8];
                    break;
                case 3:
                    line=board[0]+board[3]+board[6];
                    break;
                case 4:
                    line=board[1]+board[4]+board[7];
                    break;
                case 5:
                    line=board[2]+board[5]+board[8];
                    break;
                case 6:
                    line=board[0]+board[4]+board[8];
                    break;
                case 7:
                    line=board[2]+board[4]+board[6];
                    break;
            }//switch end
            if(line.equals("XXX")){
                return "X";
            }
            else if(line.equals("OOO")){
                return "O";
            }
        }//for loop end
        
        //finding the draw condition
        for(int k=0;k<9;k++){
            if(board[k].equals(String.valueOf(k+1))){
                return null;
            }
        }
        
        // it is draw situation
        return "draw";
    }
    
    
    //printing the tic tack toe
    static void printBoard(){
 System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        board=new String[9];
        System.out.println("welcome to tic tak toe game");
        System.out.println("X will play first then O");
        
        //assigning elements in board
        for(int i=0;i<9;i++){
            board[i]=String.valueOf(i+1);
        }
        turn="X";

        // //printing board index values
        // for(int j=0;j<9;j++){
        //   System.out.println(" board index j = "+j+" value = "+board[j]);
        // }
        
        //playing the game
        while(winner==null){
        printBoard();
        System.out.println("enter number where you want to place "+turn+" = ");
        input=sc.nextInt();
        if(!(input>=1&&input<=9)){
        System.out.println("please enter valid number from 1 to 9!");
        continue;
        }
        else{
            if(board[input-1].equals(String.valueOf(input))){
                board[input-1]=turn;
                
                if(turn=="X"){
                    turn="O";
                }
                else{
                    turn="X";
                }
            }
            else{
                System.out.println(input+" place is already occupied!,choose other number -");
                continue;
            }
            //checking for winner
            winner=checkWinner();
        }
        }//while end
        
        //declaring the winner
        if(winner=="X"){
        System.out.println("X is winner!");            
        }
        else if(winner=="O"){
         System.out.println("O is winner!");            
        }
        else if(winner=="draw"){
         System.out.println("It's a draw!");            
        }
         System.out.println("Thank you!");            
   }
}