package minigames.game.lotto.model;

import java.util.Set;

import lombok.Data;
import minigames.game.lotto.input.messageprovider.LottoMessageProvider;
import minigames.model.GameResultInfo;

@Data
public class LottoGameResultInfo implements GameResultInfo {

    private final Set<Integer> userGivenNumbers;
    private final Set<Integer> randomSixNumbers;
    private final Set<Integer> finalHitNumbers;

    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessageProvider.LOTTO_RESULT, finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }
}
