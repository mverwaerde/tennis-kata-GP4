public class TennisGameUneasyImplemented implements TennisGame {

    private int P1point = 0;
    private int P2point = 0;

    public String getScore() {
        String score = "";

        if (gameHasAWinner(P1point, P2point)) {
            score = "Win for " + getWinner(P1point, P2point);
        } else if (gameHasDeuceOrAdvantage(P1point, P2point)) {
            score = getScoreForDeuceOrAdvantage(P1point, P2point);
        } else {
            score = getRunningScore(P1point, P2point);
        }

        return score;
    }

    private String getRunningScore(int p1point, int p2point) {
        String score;
        if (p1point == p2point) {
            score = getScoreFromPoint(p1point);
            score += "-All";
            return score;
        }

        return getScoreFromPoint(p1point) + "-" + getScoreFromPoint(p2point);
    }

    private String getScoreForDeuceOrAdvantage(int p1point, int p2point) {
        String score;
        if (p1point == p2point) {
            score = "Deuce";
        } else if (p1point > p2point) {
            score = "Advantage player1";
        } else {
            score = "Advantage player2";
        }
        return score;
    }

    private boolean gameHasDeuceOrAdvantage(int p1point, int p2point) {
        return p1point >= 3 && p2point >= 3;
    }

    private String getWinner(int p1point, int p2point) {
        if (p1point > p2point) return "player1";
        return "player2";
    }

    private boolean gameHasAWinner(int p1point, int p2point) {
        return (p1point >= 4 && (p1point - p2point) >= 2) || (p2point >= 4 && (p2point - p1point) >= 2);
    }

    private String getScoreFromPoint(int point) {
        return switch (point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> null;
        };
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}