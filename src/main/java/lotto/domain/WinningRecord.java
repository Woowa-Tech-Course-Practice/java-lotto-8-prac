package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static lotto.constants.LottoVariable.*;
import static lotto.exception.LottoErrorCode.OUT_OF_LOTTO_NUMBER;

public class WinningRecord {
    private final Map<RankReward, Integer> records = new HashMap<>();

    private static WinningRecord instance;

    private WinningRecord() {

    }

    public static WinningRecord getInstance() {
        if (instance == null) {
            instance = new WinningRecord();
        }
        return instance;
    }

    public void addRecord(int correctCount, boolean bonus) {
        validateRecord(correctCount);

        RankReward rank = RankReward.from(correctCount, bonus);
        records.put(rank, records.getOrDefault(rank, 0) + 1);
    }

    private void validateRecord(int number) {
        if(number < LOTTO_NUMBER_COUNT_NONE || number > LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException(OUT_OF_LOTTO_NUMBER.getMessage());
        }
    }

    public Map<RankReward,Integer> getRecords() {
        return Collections.unmodifiableMap(records);
    }

    public long getTotalReward() {
        long total = 0;
        for (Map.Entry<RankReward, Integer> entry : records.entrySet()) {
            RankReward rank = entry.getKey();
            int count = entry.getValue();
            total += (long) rank.getReward() * count;
        }
        return total;
    }

    public void clearRecords() {
        records.clear();
    }
}