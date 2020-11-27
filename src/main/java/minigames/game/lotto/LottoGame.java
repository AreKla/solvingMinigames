package minigames.game.lotto;

import java.util.Scanner;
import java.util.Set;

import lombok.AllArgsConstructor;
import minigames.game.Game;
import minigames.game.lotto.input.LottoInputReceiver;
import minigames.game.lotto.logic.LottoHitNumberCalculator;
import minigames.game.lotto.logic.LottoRandomGenerator;
import minigames.game.lotto.messageprovider.LottoMessageProvider;
import minigames.model.GameResult;
import minigames.model.GameResultInfo;

import static minigames.game.lotto.config.LottoGameConfiguration.GAME_NAME;

@AllArgsConstructor
public class LottoGame implements Game {

    private final LottoInputReceiver lottoInputReceiver;
    private final LottoRandomGenerator randomGenerator;
    private final LottoHitNumberCalculator lottoHitNumberCalculator;
    private final Scanner scanner;

    public GameResult startGame() {
        System.out.println(String.format(LottoMessageProvider.GAME_S_STARTED, GAME_NAME));
        final GameResultInfo gameResultInfo = getHitNumbers();
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        System.out.println(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }

    private GameResultInfo getHitNumbers() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        final Set<Integer> randomNumbers = randomGenerator.getRandomSixNumbers();
        System.out.println(inputNumbers);
        System.out.println(randomNumbers);
        return lottoHitNumberCalculator.getHitNumbers(inputNumbers, randomNumbers);
    }
}
