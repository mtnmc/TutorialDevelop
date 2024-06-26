package com.techacademy.service;

import java.util.List;
import java.util.Set;// 追加３

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // 追加

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    /** 全件を検索して返す　*/
    public List<User> getUserList(){
        // リポジトリのfindAllメソッドを呼び出す
        return userRepository.findAll();
    }

    // --------　追加：ここから2 ----------
    /** Userを1件検索して返す　*/
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
    // ----- 追加：ここまで2 -----


    // --------　追加：ここから1 ----------
    /** Userの登録をおこなう */
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    // ----- 追加：ここまで1 -----

    // --------　追加：ここから3 ----------
    /** Userの削除を行う */
    @Transactional
    public void deleteUser(Set<Integer> idck) {
        for(Integer id : idck) {
            userRepository.deleteById(id);
        }
    }
    // --------　追加：ここまで3 ----------
}
