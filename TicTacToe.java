import java.util.Scanner;

class TicTacToe {
    private char playerSymbol, computerSymbol;
    static Scanner sc = new Scanner(System.in);
    static TicTacToe tacToe;
    static char[] playerOrder = new char[2];
    static char[] board;

    public char[] createBoard() {
        char[] board = new char[10];
        for (int i = 0; i < 10; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public char getComputerSymbol() {
        return computerSymbol;
    }

    public boolean chooseSymbol(char symbol) {

        if (symbol == 'x') {
            playerSymbol = 'x';
            computerSymbol = 'o';
            return true;

        } else if (symbol == 'o') {
            playerSymbol = 'o';
            computerSymbol = 'x';
            return true;

        }
        return false;

    }

    public void showBoard(char[] board) {
        for (int i = 1; i < 10; i++) {
            System.out.print(i + "  " + board[i] + "  | ");
            if (i % 3 == 0) {
                System.out.println();
            }
        }

    }

    public static void selectSymbol() {
        System.out.println("Enter Symbol [x / o ]");
        char symbol = sc.nextLine().charAt(0);
        while (!tacToe.chooseSymbol(symbol)) {
            System.out.println("invalid Symbol");
            System.out.println("Enter Symbol [x / o ]");
            symbol = sc.nextLine().charAt(0);
        }
        System.out.println("player symbol is: " + tacToe.getPlayerSymbol());
    }

    public static void playGame(char symbol) {
        int index;
        if (symbol == tacToe.getComputerSymbol()) {
            index = (int) (Math.floor(Math.random() * 9) % 9 + 1);
            while (board[index] != ' ') {
                index = (int) (Math.floor(Math.random() * 9) % 9 + 1);
            }
            board[index] = tacToe.getComputerSymbol();
        } else {
            System.out.println("Enter Position to place your mark");
            index = sc.nextInt();
            while (board[index] != ' ') {
                System.out.println("position is already occupied");
                System.out.println("Enter Position to place your mark");
                index = sc.nextInt();
            }
            board[index] = tacToe.getPlayerSymbol();
        }
    }

    public static void toss() {
        int turn = (int) (Math.floor(Math.random() * 10) % 2);
        if (turn == 1) {
            System.out.println("Player plays First..!");
            playerOrder[0] = tacToe.getPlayerSymbol();
            playerOrder[1] = tacToe.getComputerSymbol();
        } else {
            System.out.println("Computer plays First..!");
            playerOrder[1] = tacToe.getPlayerSymbol();
            playerOrder[0] = tacToe.getComputerSymbol();
        }

    }

    public static boolean isGameOver() {
        for (int i = 0; i < 3; i++) {
            if (board[0 * 3 + i + 1] == board[1 * 3 + i + 1] && board[0 * 3 + i + 1] == board[2 * 3 + i + 1]
                    && board[1 * 3 + i + 1] != ' ')
                return true;
            if (board[i * 3 + 0 + 1] == board[i * 3 + 1 + 1] && board[i * 3 + 1 + 1] == board[i * 3 + 2 + 1]
                    && board[i * 3 + 0 + 1] != ' ')
                return true;
        }
        if (board[3] == board[5] && board[3] == board[7] && board[3] != ' ')
            return true;
        if (board[1] == board[5] && board[1] == board[9] && board[1] != ' ')
            return true;
        return false;

    }

    public static void greetWinner(char symbol) {
        if (symbol == tacToe.getComputerSymbol()) {
            System.out.println("Computer Won..!!");
        } else
            System.out.println("player Won..!!");
    }

    public static void main(String[] args) {
        boolean isOver = false;
        tacToe = new TicTacToe();
        board = tacToe.createBoard();
        selectSymbol();
        System.out.println(tacToe.getPlayerSymbol() + " " + " " + tacToe.getComputerSymbol());
        toss();
        tacToe.showBoard(board);
        for (int i = 0; i < 4; i++) {
            tacToe.showBoard(board);
            playGame(playerOrder[0]);
            isOver = isGameOver();
            if (isOver) {
                System.out.println("Game Over..!!");
                greetWinner(playerOrder[0]);
                break;
            }
            tacToe.showBoard(board);
            playGame(playerOrder[1]);
            isOver = isGameOver();
            if (isOver) {
                System.out.println("Game Over..!!");
                greetWinner(playerOrder[1]);
                break;
            }
        }
        if (!isOver) {
            playGame(playerOrder[0]);
            tacToe.showBoard(board);
            isOver = isGameOver();
            if (isOver) {
                System.out.println("Game Over..!!");
                greetWinner(playerOrder[0]);
            }
        }

    }
}
