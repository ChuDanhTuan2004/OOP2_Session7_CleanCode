package tennisgame;

public class TennisGame {

    public static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    public static final char LOVE = 0;
    public static final char FIFTEEN = 1;
    public static final char THIRTY = 2;
    public static final char FORTY = 3;
    public static final int SCORE_CHECK_MATE = 4;

    public static void main(String[] args) {
        System.out.println(getResult("Jane", "Tom", 5, 7));
    }

    public static boolean isWin(int score1, int score2) {
        return Math.abs(score1 - score2) == 2;
    }

    public static String getResult(String player1, String player2, int score1, int score2) {
        String result = "";
        if (score1 == score2) {
            if (score1 > FORTY) {
                result = "Deuce";
            } else {
                result = SCORE_NAMES[score1] + "-All";
            }
        } else if (score1 >= SCORE_CHECK_MATE || score2 >= SCORE_CHECK_MATE) {
            result = "Advantage: ";

            if (isWin(score1, score2)) {
                result = "Win: ";
            }

            result += (score1 > score2) ? player1 : player2;
        } else {
            result = SCORE_NAMES[score1] + "-" + SCORE_NAMES[score2];
        }
        return result;
    }
}

