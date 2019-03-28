package com.atguigu.atcrowdfunding.Exception;

/**
 * 〈土拔鼠的日常〉<br>
 * 〈登录异常〉
 *
 * @author chen
 * @create 2019/1/15
 */
public class LoginFailException extends RuntimeException {
    public LoginFailException(String message){
        super(message);
    }
}
