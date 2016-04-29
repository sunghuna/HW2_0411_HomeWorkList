package com.example.sunghuncom.hw2_0411_homeworklist2;
/**
 * Created by SunghunCom on 16. 3. 30..
 */
public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super();
    }
    public DivideByZeroException(String msg) {
        super(msg);
    }
}