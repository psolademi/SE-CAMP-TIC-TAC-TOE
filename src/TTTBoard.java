public class TTTBoard {
    private char[][] board;

    public TTTBoard() {
        board = new char[3][3];
        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false; // Invalid move
        }
        board[row][col] = symbol;
        return true;
    }

    public boolean isWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true; // Row win
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true; // Column win
            }
        }
        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true; // Main diagonal win
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true; // Other diagonal win
        }
        return false;
    }

    public boolean isFull() {
        // Check if the board is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }
}