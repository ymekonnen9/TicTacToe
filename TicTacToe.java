import java.lang.StringBuilder;

public class TicTacToe{
    public static final int X = 1;
    public static final int O = -1;
    public static final int EMPTY = 0;
    public int board[][] = new int[3][3];
    public int player;

    public TicTacToe(){
        clearBoard();
    }

    public void clearBoard(){
        for(int i=0; i<3 ; i++){
            for(int j =0; j < 3; j++){
                board[i][j] = EMPTY;
            }
        }
        player = X;
    }

    public void putMark(int i, int j) throws IllegalArgumentException{
        if((i<0) || (i>2) || (j<0) || (j>2)){
            throw new IllegalArgumentException("Invalid index argument");
        }
        if(board[i][j] != EMPTY){
            throw new IllegalArgumentException("Player already marked this position");
        }
        board[i][j] = player;
        player = - player;
    }

    public boolean isWin(int mark){
        if((board[0][0] + board[0][1] + board[0][2] == mark*3) || 
        (board[1][0] + board[1][1] + board[1][2] ==mark*3) ||
        (board[2][0] + board[2][1] + board[2][2] == mark*3) ||
        (board[0][0] + board[1][1]+ board[2][2] == mark*3) ||
        (board[0][2] + board[1][1] + board[2][0]==mark*3)){
            return true;
        }
        return false;

    }

    public int isWinner(){
        if(isWin(X)){
            return X;
        }
        if(isWin(O)){
            return O;
        }

        return 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                switch(board[i][j]){
                    case X: sb.append("X");
                    break;
                    case O: sb.append("O");
                    break;
                    case EMPTY: sb.append(" ");
                    break;
                }
                if(j<2){
                    sb.append("|");
                }
            }
            if(i<2){
                sb.append("\n---------\n");
            }
        }

        return sb.toString();

    }



    public static void main(String[] args){
        TicTacToe game = new TicTacToe();

        game.putMark(1,1);
        game.putMark(2,2);
        game.putMark(0,1);
        game.putMark(1,2);
        game.putMark(2,0);
        game.putMark(0,2);
        game.putMark(0,0);
        game.putMark(2,1);
        game.putMark(1,0);

        System.out.println(game);

        int winning = game.isWinner();
        System.out.println(winning);
    }

}