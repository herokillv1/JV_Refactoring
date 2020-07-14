public class TennisGame {

    public static final int constantOne = 1;
    public static final int constantTow = 2;
    public static final String Equal = "-";

    public static String getScore(String player1Name, String player2Name, int scoreFirstPlayer, int scoreSecondPlayer) {
        String score = "";
        int tempScore=0;
        boolean CompareWithEqual = scoreFirstPlayer == scoreSecondPlayer;
        if (CompareWithEqual)
        {
            score = getString(scoreFirstPlayer);
        }
        else {
            boolean CompareFirstPlayer = scoreFirstPlayer >= 4;
            boolean CompareSecondPlayer = scoreSecondPlayer >= 4;
            if (CompareFirstPlayer || CompareSecondPlayer)
            {
                score = getString(scoreFirstPlayer, scoreSecondPlayer);
            }
            else
            {
                score = getString(scoreFirstPlayer, scoreSecondPlayer, score);
            }
        }
        return score;
    }

    private static String getString(int scoreFirstPlayer, int scoreSecondPlayer) {
        String score;
        int minusResult = scoreFirstPlayer-scoreSecondPlayer;
        if (minusResult== constantOne) score ="Advantage player1";
        else if (minusResult ==-constantOne) score ="Advantage player2";
        else if (minusResult>= constantTow) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String getString(int scoreFirstPlayer, int scoreSecondPlayer, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = scoreFirstPlayer;
            else { score+= Equal; tempScore = scoreSecondPlayer;}
            score = getString(score, tempScore);
        }
        return score;
    }

    private static String getString(String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        return score;
    }

    private static String getString(int scoreFirstPlayer) {
        String score;
        switch (scoreFirstPlayer)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
