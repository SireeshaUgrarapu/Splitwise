package dev.siri.Splitwise.service.strategy.settleUpStrategy;

import dev.siri.Splitwise.entity.Expense;
import dev.siri.Splitwise.entity.SettlementTransaction;

import java.util.List;

public interface SettleUpStrategy {
    List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses);
}
