package lotto.domain;

import java.util.List;

public class LottoRank {

    // TODO 준형 : 위치 이동하기 (현재 package -> lotto.domain.util)을
    // TODO 준형 : LottoCalculator 아닌 다른 이름(원하는대로) 변경하고 다른 패키지로 이동
    public enum Rank {
        FIRST(6, false),
        SECOND(5, true),
        THIRD(5, false),
        FOURTH(4, false),
        FIFTH(3, false),
        NONE(0, false)
        ;

        private final int matchCount;
        private final boolean bonus;

        Rank(int matchCount, boolean bonus) {
            this.matchCount = matchCount;
            this.bonus = bonus;
        }

        public Rank calculateRank(List<Integer> winningNumbers, int bonusNumber, List<Integer> userNumbers) {
            // TODO -> 준형 : stream으로 고치기
            // TODO -> 현빈 : for문을 유지하되, 더 깔끔하게 + List<Integer>가 아닌 만들어놓은 객체 사용하기
            long matchCount = 0;
            matchCount = userNumbers.stream().filter(num->winningNumbers.contains(num)).count();

            boolean bonusMatch = userNumbers.contains(bonusNumber);


            // TODO -> 준형 : Rank enum에 findByCount() 만들어서 호출하는 쪽으로 변경
            // TODO -> 현빈 : Rank enum 구조 변경(description 추가) 및 기존 정의한 matchCount 활용으로 변경
            return RankReward.findByCount(matchCount,bonusMatch);
        }
    }

}
