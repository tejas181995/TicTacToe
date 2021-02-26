import java.util.Scanner;

class TicTacToe {
    private char playerSymbol, computerSymbol;
    private char[] board = new char [10];
    public TicTacToe(){
        for(int i=0; i<10; i++){
            board[i] = ' ';
        }
    }

    public void chooseSymbol(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Symbol to start. [ x / o]");
        char sym = sc.nextLine().charAt(0);
        if(sym == 'x'){
            playerSymbol = sym;
            computerSymbol = 'o';
            System.out.println("your symbol is: " + playerSymbol);
        }else if (sym == 'o'){
            playerSymbol = sym;
            computerSymbol = 'x';
            System.out.println("your symbol is: " + playerSymbol);

        }else{
            System.out.println("Wrong symbol selected");
            chooseSymbol();
        }

    }
    public static void main(String[] args) {
        TicTacToe tacToe = new TicTacToe();
        tacToe.chooseSymbol();
    }
}

