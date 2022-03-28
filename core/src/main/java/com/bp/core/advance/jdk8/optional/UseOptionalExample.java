package com.bp.core.advance.jdk8.optional;

import java.util.Optional;

/**
 * @description: 举例
 * @author: hansiyuan
 * @date: 2022/3/28 6:56 PM
 */
public class UseOptionalExample {
    public static void main(String[] args) {
        Optional<User> user = getUser();
        System.out.println(user.isPresent());
    }

    public static Optional<User> getUser() {
        User user = null;
        return Optional.ofNullable(user);
    }
}
