package lotto.domain;

import lotto.exception.LottoErrorCode;

import java.util.Arrays;
import java.util.function.BiPredicate;

import static lotto.constants.LottoPrice.*;
import static lotto.constants.LottoWinner.*;

public enum RankReward {
    FIRST(FIRST_LOTTO_PRICE, (matchCount, bonus) -> matchCount == FIRST_COUNT),
    SECOND(SECOND_LOTTO_PRICE, (matchCount, bonus) -> matchCount == SECOND_COUNT && bonus),
    THIRD(THIRD_LOTTO_PRICE, (matchCount, bonus) -> matchCount == THIRD_COUNT && !bonus),
    FOURTH(FOURTH_LOTTO_PRICE, (matchCount, bonus) -> matchCount == FOURTH_COUNT),
    FIFTH(FIFTH_LOTTO_PRICE, (matchCount, bonus) -> matchCount == FIFTH_COUNT);

    private final int reward;
    private final BiPredicate<Integer, Boolean> condition;

    RankReward(int reward, BiPredicate<Integer, Boolean> condition) {
        this.reward = reward;
        this.condition = condition;
    }

    // TODO: rank 정하는 거 여기에
    public static RankReward from(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(r -> r.condition.test(matchCount, bonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LottoErrorCode.RANK_OUT_OF_RANGE.getMessage()));
    }

    public int getReward() {
        return reward;
    }
}