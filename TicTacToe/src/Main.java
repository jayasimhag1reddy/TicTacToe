public class Main {
    public static void main(String[] args) {
        intro();
        char[][] board=new char[3][3];
        print(board);
    }
    public static void print(char[][] board){
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println("");
        }
    }
    public static void intro(){
        System.out.println("Welcome to TIC-TAC-TOE");
    }
}