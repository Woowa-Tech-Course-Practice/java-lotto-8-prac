package lotto.constants;

public class LottoRegex {
    public static final String NUMBER_REGEX = "^[1-9]\\d*$";
    public static final String WINNER_REGEX = "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5]))*$";
    public static final String BONUS_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";
    public static final String SPLIT_PATTERN = ",";
}