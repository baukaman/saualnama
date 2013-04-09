package com.rc.saualnama.question;

import sun.org.mozilla.javascript.internal.Token;

/**
 * Created with IntelliJ IDEA.
 * User: Bauka
 * Date: 4/8/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public enum QuestionType {
    TEST('T'), TEXT('X');

    private char code;

    QuestionType(char code){
        this.code = code;
    }

    public char getCode(){
        return code;
    }
    public static QuestionType byCode(char code){
        switch(code){
            case 'T': return TEST;
            case 'X': return TEXT;
            default: return null;
        }
    }
}
