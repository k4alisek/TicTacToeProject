public class TicTacToe {
    private int round;
    private final int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    public void updateRound() {
        round++;
    }
    public int getRound() {
        return round;
    }
    public void updateBoard(int digit, int player) {
        if (player == 1) {
            if (digit == 0) {
                board[0][0] = 1;
            }
            else if (digit == 1) {
                board[0][1] = 1;
            }
            else if (digit == 2) {
                board[0][2] = 1;
            }
            else if (digit == 3) {
                board[1][0] = 1;
            }
            else if (digit == 4) {
                board[1][1] = 1;
            }
            else if (digit == 5) {
                board[1][2] = 1;
            }
            else if (digit == 6) {
                board[2][0] = 1;
            }
            else if (digit == 7) {
                board[2][1] = 1;
            }
            else if (digit == 8) {
                board[2][2] = 1;
            }
        }
        else if (player == 2) {
            if (digit == 0) {
                board[0][0] = 2;
            }
            else if (digit == 1) {
                board[0][1] = 2;
            }
            else if (digit == 2) {
                board[0][2] = 2;
            }
            else if (digit == 3) {
                board[1][0] = 2;
            }
            else if (digit == 4) {
                board[1][1] = 2;
            }
            else if (digit == 5) {
                board[1][2] = 2;
            }
            else if (digit == 6) {
                board[2][0] = 2;
            }
            else if (digit == 7) {
                board[2][1] = 2;
            }
            else if (digit == 8) {
                board[2][2] = 2;
            }
        }
    }
    public boolean win() {
        if (board[0][0] == board[0][1] && board[0][0] == board [0][2] && board[0][0] != 0) {
            return true;
        }
        else if (board[1][0] == board[1][1] && board[1][0] == board [1][2] && board[1][0] != 0) {
            return true;
        }
        else if (board[2][0] == board[2][1] && board[2][0] == board [2][2] && board[2][0] != 0) {
            return true;
        }
        else if (board[0][0] == board[1][0] && board[0][0] == board [2][0] && board[0][0] != 0) {
            return true;
        }
        else if (board[0][1] == board[1][1] && board[0][1] == board [2][1] && board[0][1] != 0) {
            return true;
        }
        else if (board[0][2] == board[1][2] && board[0][2] == board [2][2] && board[0][2] != 0) {
            return true;
        }
        else if (board[0][0] == board[1][1] && board[0][0] == board [2][2] && board[1][0] != 0) {
            return true;
        }
        else return board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != 0;
    }
}