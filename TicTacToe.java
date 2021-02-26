class TicTacToe {
    private char[] board = new char [10];
    public TicTacToe(){
        for(int i=0; i<10; i++){
            board[i] = ' ';
        }
    }
    public void printBoard(){
        for(int i=1; i<=3; i++){
            for(int j=1; j<=3;j++){
                int element = j+3*(i-1);
                System.out.print(board[element] + "| ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        TicTacToe tacToe = new TicTacToe();
        tacToe.printBoard();
    }
}

