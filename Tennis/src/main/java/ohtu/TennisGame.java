package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;
    private final String[] scoreName = new String[4];

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        initScoreNames();
    }

    private void initScoreNames() {
        scoreName[0] = "Love";
        scoreName[1] = "Fifteen";
        scoreName[2] = "Thirty";
        scoreName[3] = "Forty";
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            m_score1++;
        } else {
            m_score2++;
        }
    }

    public String getScore() {
        String score = "";
        if (m_score1 == m_score2) {
            score = getScoreEven();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getScoreLateGame();
        } else {
            score = getScoreEarlyGame();
        }
        return score;
    }

    private String getScoreEven() {
        if (m_score1 >= 0 && m_score1 <= 3) {
            return scoreName[m_score1] + "-All";
        } else {
            return "Deuce";
        }
    }

    private String getScoreLateGame() {
        int player1Advantage = m_score1 - m_score2;
        if (player1Advantage == 1) {
            return "Advantage player1";
        } else if (player1Advantage == -1) {
            return "Advantage player2";
        } else if (player1Advantage >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getScoreEarlyGame() {
        return scoreName[m_score1] + "-" + scoreName[m_score2];
    }
}
