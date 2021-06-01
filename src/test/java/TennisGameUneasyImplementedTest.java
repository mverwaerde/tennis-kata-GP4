import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class TennisGameUneasyImplementedTest {
  public static Stream<Arguments> getAllScores() {
    return Stream.of(
        of(0, 0, "Love-All"),
        of(1, 1, "Fifteen-All"),
        of(2, 2, "Thirty-All"),
        of(3, 3, "Deuce"),
        of(4, 4, "Deuce"),

        of(1, 0, "Fifteen-Love"),
        of(0, 1, "Love-Fifteen"),
        of(2, 0, "Thirty-Love"),
        of(0, 2, "Love-Thirty"),
        of(3, 0, "Forty-Love"),
        of(0, 3, "Love-Forty"),
        of(4, 0, "Win for loic"),
        of(0, 4, "Win for cyril"),

        of(2, 1, "Thirty-Fifteen"),
        of(1, 2, "Fifteen-Thirty"),
        of(3, 1, "Forty-Fifteen"),
        of(1, 3, "Fifteen-Forty"),
        of(4, 1, "Win for loic"),
        of(1, 4, "Win for cyril"),

        of(3, 2, "Forty-Thirty"),
        of(2, 3, "Thirty-Forty"),
        of(4, 2, "Win for loic"),
        of(2, 4, "Win for cyril"),

        of(4, 3, "Advantage loic"),
        of(3, 4, "Advantage cyril"),
        of(5, 4, "Advantage loic"),
        of(4, 5, "Advantage cyril"),
        of(15, 14, "Advantage loic"),
        of(14, 15, "Advantage cyril"),

        of(6, 4, "Win for loic"),
        of(4, 6, "Win for cyril"),
        of(16, 14, "Win for loic"),
        of(14, 16, "Win for cyril")
    );
  }

  @ParameterizedTest
  @MethodSource("getAllScores")
  public void checkAllScoresTennisGame2(int player1Score, int player2Score, String expectedScore) {
    TennisGameUneasyImplemented game = new TennisGameUneasyImplemented("loic", "cyril");

    int highestScore = Math.max(player1Score, player2Score);
    for (int i = 0; i < highestScore; i++) {
      if (i < player1Score)
        game.wonPoint("loic");
      if (i < player2Score)
        game.wonPoint("cyril");
    }
    assertThat(game.getScore()).isEqualTo(expectedScore);
  }

}