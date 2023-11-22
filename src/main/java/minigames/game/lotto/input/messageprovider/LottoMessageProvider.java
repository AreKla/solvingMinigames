package minigames.game.lotto.input.messageprovider;

public class LottoMessageProvider {

    public static final String GAME_NAME = "Lotto";
    public static final String GAME_S_STARTED = "Game: %s started";
    public static final String GIVE_NUMBER = "Please give number";
    public static final String PLEASE_GIVE_NUMBERS = "Please give %d numbers";
    public static final String NOT_IN_RANGE = "Incorrect input please give number in range %d-%d inclusive";
    public static final String NOT_IN_RANGE_WITH_GIVEN_NUMBER = "Given number: %d must be in range %d-%d";
    public static final String LOTTO_RESULT = "You hit %d numbers! Winning numbers were %s, and yours were %s";

    private LottoMessageProvider() {
    }
}
