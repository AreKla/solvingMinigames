package minigames.game.lotto.model;

import java.util.Set;

import minigames.game.lotto.input.messageprovider.LottoMessageProvider;
import minigames.model.GameResultInfo;

public record LottoGameResultInfo(Set<Integer> userGivenNumbers,
                                  Set<Integer> randomSixNumbers,
                                  Set<Integer> finalHitNumbers) implements GameResultInfo {

    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessageProvider.LOTTO_RESULT, finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }
}