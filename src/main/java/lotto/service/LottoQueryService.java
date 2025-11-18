package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningRecord;

import java.util.List;
import java.util.Map;

public class LottoQueryService {
    public int getLottoCount() {
        LottoMachine lottoMachine = LottoMachine.getInstance();
        return lottoMachine.getLottoAmount();
    }

    public List<Lotto> getLottos(){
        Lottos lottos = Lottos.getInstance();
        return lottos.getLottos();
    }

    public Map<RankReward, Integer> getWinningStatics() {
        WinningRecord winningRecord = WinningRecord.getInstance();
        return winningRecord.getRecords();
    }

    public double getRate() {
        LottoMachine lottoMachine = LottoMachine.getInstance();
        return lottoMachine.getRate();
    }
}