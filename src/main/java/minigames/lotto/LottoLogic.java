package minigames.lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoLogic {

    public Set<Integer> getHitNumbers(Set<Integer> sixNumbers, Set<Integer> randomSixNumbers) {
        Set<Integer> finalHitNumbers = new HashSet<Integer>(sixNumbers);
        finalHitNumbers.retainAll(randomSixNumbers);
        return finalHitNumbers;
    }
}
