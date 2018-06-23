package com.budget.wiz.skip.app.service.impl;

import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.User;
import com.budget.wiz.skip.app.repository.UserRepository;
import com.budget.wiz.skip.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long createUser(User user) {
        try {
            user =  userRepository.save(user);
        } catch (Exception ex) {
            LOG.error("Error to save the user" + user.getUserID());
        }
        return user.getUserID();
    }

    @Override
    @Transactional
    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        User result = checkCarById(user.getUserID());
        result.setUserEmail(user.getUserEmail());
        result.setUserName(user.getUserName());

        if(user.getBudget() != null)
            result.setBudget(user.getBudget());
        return result;
    }

    @Override
    public User getUserById(Long userID) {
       return checkCarById(userID);
    }

    @Override
    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new EntityNotFoundException("User not found by User Name" + userName));
    }


    private User checkCarById(Long userID) throws EntityNotFoundException {
        return userRepository.findById(userID).orElseThrow(() -> new EntityNotFoundException("User Not Found !!!"));
    }
}
