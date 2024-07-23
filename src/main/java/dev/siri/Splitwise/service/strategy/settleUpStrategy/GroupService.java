package dev.siri.Splitwise.service.strategy.settleUpStrategy;

import dev.siri.Splitwise.entity.SettlementTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    List<SettlementTransaction> settleUp(int groupId);
}
