package minigames.game.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import minigames.game.Game;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoHitNumberCalculator;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.model.GameResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameTest {

    private static final Scanner scannerMock = new Scanner(System.in);
    private static final LottoHitNumberCalculator LOTTO_HIT_NUMBER_GENERATOR = new LottoHitNumberCalculator();
    private static final LottoInputReceiver lottoInputReceiverMock = mock(LottoInputReceiver.class);
    private static final LottoRandomGenerator randomGeneratorMock = mock(LottoRandomGenerator.class);

    @ParameterizedTest(name = "player gave {0}, random numbers were {1}, result {2}")
    @MethodSource("provideNumbersAndMessages")
    void shouldReturnCorrectMessageWhenParametersWereGiven(Set<Integer> playerGivenNumbers,
                                                           Set<Integer> randomNumbers,
                                                           String expectedMessage) {
        // given
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(lottoInputReceiverMock, randomGeneratorMock, LOTTO_HIT_NUMBER_GENERATOR, scannerMock);
        // when
        final GameResult gameResult = lottoGame.startGame();
        // then
        assertEquals(expectedMessage, gameResult.getGameResultInfo().getGameResultMessage());
    }

    private static Stream<Arguments> provideNumbersAndMessages() {
        final Arguments argument1 = Arguments.of(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                "You hit 6 numbers! Winning numbers were [1, 2, 3, 4, 5, 6], and yours were [1, 2, 3, 4, 5, 6]");

        final Arguments argument2 = Arguments.of(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12))),
                "You hit 0 numbers! Winning numbers were [7, 8, 9, 10, 11, 12], and yours were [1, 2, 3, 4, 5, 6]");

        final Arguments argument3 = Arguments.of(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Collections.unmodifiableSet(new HashSet<>(Arrays.asList(6, 8, 9, 10, 11, 12))),
                "You hit 1 numbers! Winning numbers were [6, 8, 9, 10, 11, 12], and yours were [1, 2, 3, 4, 5, 6]");

        return Stream.of(argument1, argument2, argument3);
    }

    private void mockNumbers(Set<Integer> playerGivenNumbers, Set<Integer> randomNumbers) {
        when(lottoInputReceiverMock.getSixNumbers(scannerMock)).thenReturn(playerGivenNumbers);
        when(randomGeneratorMock.getRandomSixNumbers()).thenReturn(randomNumbers);
    }
}