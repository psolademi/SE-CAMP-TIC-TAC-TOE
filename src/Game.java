public class Game {
    private TTTBoard board;
    private char currentPlayer;

    public Game() {
        board = new TTTBoard();
        currentPlayer = 'X';
    }

    public boolean makeMove(int row, int col) {
        if (board.makeMove(row, col, currentPlayer)) {
            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isWin() {
        return board.isWin(currentPlayer);
    }

    public boolean isDraw() {
        return board.isFull() && !board.isWin('X') && !board.isWin('O');
    }
}