package clean_code.bai_tap;

public class TennisGame {
    public static final String zero = "Love";
    public static final String one = "Fifteen";
    public static final String two = "Thirty";
    public static final String three = "Forty";
    public static final String equal = "-All";

    public static String getScore(String namePlayer1 , String namePlayer2 , int scoreOfPlayer1 , int scoreOfPlayer2){
        if (scoreOfPlayer1 == scoreOfPlayer2){
            return equalScore(scoreOfPlayer1);
        } else if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >=4){
            return maxScore(scoreOfPlayer1,scoreOfPlayer2);
        } else {
            return otherScore(scoreOfPlayer1,scoreOfPlayer2);
        }
    }

    public static String equalScore(int scoreOfPlayer1){
        switch (scoreOfPlayer1){
            case 0:
                return zero + equal;
            case 1:
                return one + equal;
            case 2:
                return two + equal;
            case 3:
                return three + equal;
            default:
                return "Deuce";
        }
    }

    public static String maxScore(int scoreOfPlayer1 , int scoreOfPlayer2){
        int result = scoreOfPlayer1 - scoreOfPlayer2;
        if (result == 1){
            return "Advantage player1";
        } else if(result > 1){
            return "Win for player1";
        } else if (result == -1){
            return "Advantage player2";
        } else {
            return "Win for player2";
        }
    }

    public static String otherScore(int scoreOfPlayer1 , int scoreOfPlayer2){
        String result = "";
        int tempCode = 0;
        for (int i = 1 ; i < 3 ; i++){
            if (i == 1){
                tempCode = scoreOfPlayer1;
            } else {
                tempCode = scoreOfPlayer2;
                result += "-";
            }
            switch (tempCode){
                case 0:
                    result += zero;
                    break;
                case 1:
                    result += one;
                    break;
                case 2:
                    result += two;
                    break;
                case 3:
                    result += three;
                    break;
            }
        }
        return result;
    }

}
