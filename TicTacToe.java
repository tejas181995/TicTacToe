import java.util.Scanner;


class TicTacToe {
    private char playerSymbol, computerSymbol;
    static Scanner sc = new Scanner(System.in);
    static TicTacToe tacToe ;
    static char [] board;
    public char [] createBoard(){
        char [] board = new char[10];
        for(int i=0; i<10; i++){
            board[i] = ' ';
        }
        return board;
    }
    public char getPlayerSymbol(){
        return playerSymbol;
    }
    public char getComputerSymbol(){
        return computerSymbol;
    }
    public boolean chooseSymbol(char symbol){
        
        if(symbol== 'x'){
            playerSymbol =symbol;
            computerSymbol = 'o';
            return true;

        }else if (symbol== 'o'){
            playerSymbol =symbol;
            computerSymbol = 'x';
            return true;

        }
        return false;

    }
    public void showBoard(char[] board){
        for(int i=1; i<10; i++ ){
            System.out.print( i + "  "+ board[i] + "  | " );
            if(i%3 == 0){
                System.out.println();
            }
        }

    }
    public static void selectSymbol(){
        System.out.println("Enter Symbol [x / o ]");
        char symbol = sc.nextLine().charAt(0);
        while(!tacToe.chooseSymbol(symbol)){
            System.out.println("invalid Symbol");
            System.out.println("Enter Symbol [x / o ]");
            symbol = sc.nextLine().charAt(0);
        }
        System.out.println("player symbol is: "+  tacToe.getPlayerSymbol());
    }
    public static void playGame(char symbol){
        int index;
        if(symbol == tacToe.getComputerSymbol()){
            index= (int) (Math.floor(Math.random() * 9) % 9 + 1);
            while(board[index] != ' '){
                index= (int) (Math.floor(Math.random() * 9) % 9 + 1);
            }
            board[index] = tacToe.getComputerSymbol();
        } else {
            System.out.println("Enter Position to place your mark");
            index = sc.nextInt();
            while(board[index] != ' '){
                System.out.println("position is already occupied");
                System.out.println("Enter Position to place your mark");
                index = sc.nextInt();
            }
            board[index] = tacToe.getComputerSymbol();
        }
    }
    public static void main(String[] args) {
        tacToe = new TicTacToe();
        board = tacToe.createBoard();
        selectSymbol();
        tacToe.showBoard(board);
        



    }
}
