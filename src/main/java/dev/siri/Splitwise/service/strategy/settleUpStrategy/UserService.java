package dev.siri.Splitwise.service.strategy.settleUpStrategy;

import dev.siri.Splitwise.entity.User;

public interface UserService {
    User signup(String name, String email, String password);
    User login(String name,String password);
}
