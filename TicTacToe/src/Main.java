import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        intro();
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        char[][] board = new char[3][3];
        while (true){
            int k=1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = (char)('0'+k);
                    k++;
                }
            }
            print(board);
            int l=0;
            while(true) {
                if(l==9){
                    System.out.println("It's DRAW");
                    break;
                }
                System.out.println("Choose your Box");
                int user = sc.nextInt();
                isValidUserplace(board, user, 'X');
                l++;
                print(board);
                if (isWon(board)) {
                    System.out.println("Congrats!! You Won.");
                    break;
                }
                int com = rn.nextInt(1, 10);
                isValidComPlace(board,com,'O');
                l++;
                System.out.println();
                print(board);
                if (isWon(board)) {
                    System.out.println("Sorry!! You Lost");
                    break;
                }
            }
            System.out.println("Do you want to play another game, Press N/n to exit");
            String exit=sc.next();
            if(exit.equals("N") || exit.equals("n")){
                System.out.println("Thanks for Playing!!!");
                break;
            }
        }

    }
    public static  void isValidComPlace(char[][] board,int box,char ch){
        Random rn = new Random();
        while(true){
            int r=(box-1)/3;
            int c=(box-1)%3;
            if(board[r][c]=='X' || board[r][c]=='O'){
                box= rn.nextInt(1,10);
            }
            else{
                board[r][c]=ch;
                break;
            }
        }
    }
    public static void isValidUserplace(char[][] board,int box,char ch){
        Scanner sc = new Scanner(System.in);
        while(true){
            if(box<1 || box>9){
                System.out.println("Please Enter a valid box number(1-9)");
                box=sc.nextInt();
            }
            else{
                break;
            }
        }
        while(true){
            int r=(box-1)/3;
            int c=(box-1)%3;
            if(board[r][c]=='X' || board[r][c]=='O'){
                System.out.println("Please Enter a valid box,which is unused");
                box= sc.nextInt();
            }
            else{
                board[r][c]=ch;
                break;
            }
        }
    }

    public static boolean isWon(char[][] board){
        if(board[0][0]==board[0][1] && board[0][1]==board[0][2])return true;
        if(board[1][0]==board[1][1] && board[1][1]==board[1][2])return true;
        if(board[2][0]==board[2][1] && board[2][1]==board[2][2])return true;
        if(board[0][0]==board[1][0] && board[1][0]==board[2][0])return true;
        if(board[0][1]==board[1][1] && board[1][1]==board[2][1])return true;
        if(board[0][2]==board[1][2] && board[1][2]==board[2][2])return true;
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2])return true;
        if(board[0][2]==board[1][1] && board[1][1]==board[2][0])return true;
        return false;
    }
    public static void print(char[][] board){
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }
    public static void intro(){
        System.out.println("Welcome to TIC-TAC-TOE");
    }
}