package com.budget.wiz.skip.app.service;

import com.budget.wiz.skip.app.domain.object.User;

public interface UserService {

    Long createUser(User user);
    void deleteUser(Long userID);
    User updateUser(User user);
    User getUserById(Long userID);
    User getByUserName(String userName);

}
