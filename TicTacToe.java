import java.util.Scanner;


class TicTacToe {
    private char playerSymbol, computerSymbol;
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
            System.out.print(board[i] + "| ");
            if(i%3 == 0){
                System.out.println();
            }
        }

    }
    public static void main(String[] args) {
        TicTacToe tacToe = new TicTacToe();
        char [] board = tacToe.createBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Symbol [x / o ]");
        char symbol = sc.nextLine().charAt(0);
        while(!tacToe.chooseSymbol(symbol)){
            System.out.println("invalid Symbol");
            System.out.println("Enter Symbol [x / o ]");
            symbol = sc.nextLine().charAt(0);
        }
        System.out.println("player symbol is: "+  tacToe.getPlayerSymbol());
        tacToe.showBoard(board);


    }
}

