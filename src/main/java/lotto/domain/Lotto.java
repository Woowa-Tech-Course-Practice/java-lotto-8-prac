package lotto.domain;

import lotto.domain.util.LottoValidator;

import java.util.Collections;
import java.util.List;

import static lotto.constants.LottoVariable.*;
import static lotto.exception.LottoErrorCode.LOTTO_COUNT_OUT_OF_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLottoCount(numbers);
        LottoValidator.checkDuplicate(numbers);
    }

    private void checkLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_OUT_OF_RANGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int prepareLotto(List<Integer> winningNumbers) {
        return (int) this.numbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean checkBonus(int bonus) {
        return this.numbers.contains(bonus);
    }
}