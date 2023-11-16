package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRank;
import lotto.view.InputView;
import lotto.view.PrintView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        long inputAmount = InputView.requestPurchaseAmount();
        Money userMoney = new Money(inputAmount);

        int manualLottoCount = InputView.requestManualLottoCount();
        List<String> manualLottoNumbers = InputView.requestManualLottoNumber(manualLottoCount);

        LottoMachine lottoMachine = new LottoMachine(userMoney, manualLottoNumbers);
        PrintView.printLottoTickets(lottoMachine, manualLottoCount);

        String winningNumbers = InputView.requestWinningNumber();
        int bonusNumber = InputView.requestBonusNumber();
        WinningLotto winningLotto = WinningLotto.createWinningNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult(winningLotto);
        Map<Rank, Long> winningRanks = lottoResult.findWinningRankCont(lottoMachine.getLottos());
        PrintView.printStatistics(winningRanks);

        Money totalWinningMoney = new WinningRank(winningRanks).calcTotalWinningPrice();
        PrintView.printReturnRate(totalWinningMoney.calcReturnRate(userMoney));
    }
}
