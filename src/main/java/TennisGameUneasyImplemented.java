public class TennisGameUneasyImplemented implements TennisGame {

    private int P1point = 0;
    private int P2point = 0;

    private final String player1;
    private final String player2;

    public TennisGameUneasyImplemented(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (gameHasAWinner(P1point, P2point)) {
            return "Win for " + getWinner(P1point, P2point);
        } else if (gameHasDeuceOrAdvantage(P1point, P2point)) {
            return getScoreForDeuceOrAdvantage(P1point, P2point);
        }
        return getRunningScore(P1point, P2point);
    }

    private String getRunningScore(int p1point, int p2point) {
        if (p1point == p2point) {
            return getScoreFromPoint(p1point) + "-All";
        }
        return getScoreFromPoint(p1point) + "-" + getScoreFromPoint(p2point);
    }

    private String getScoreForDeuceOrAdvantage(int p1point, int p2point) {
        if (p1point == p2point) {
            return "Deuce";
        } else if (p1point > p2point) {
            return "Advantage " + this.player1;
        }
        return "Advantage " + this.player2;
    }

    private boolean gameHasDeuceOrAdvantage(int p1point, int p2point) {
        return p1point >= 3 && p2point >= 3;
    }

    private String getWinner(int p1point, int p2point) {
        if (p1point > p2point) return this.player1;
        return this.player2;
    }

    private boolean gameHasAWinner(int p1point, int p2point) {
        boolean player1HasWon = p1point >= 4 && (p1point - p2point) >= 2;
        boolean player2HasWon = p2point >= 4 && (p2point - p1point) >= 2;
        return player1HasWon || player2HasWon;
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
        if (player == this.player1)
            P1point++;
        else
            P2point++;
    }
}