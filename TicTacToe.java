class TicTacToe {
    private char[] board = new char [10];
    public TicTacToe(){
        for(int i=0; i<10; i++){
            board[i] = ' ';
        }
    }
    
    public static void main(String[] args) {
        TicTacToe tacToe = new TicTacToe();
    }
}

