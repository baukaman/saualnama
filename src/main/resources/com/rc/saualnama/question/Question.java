package com.rc.saualnama.question;


import com.rc.saualnama.option.Option;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bauka
 * Date: 4/8/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Question {
    private Long questionId;
    private List<Option> options = new ArrayList<Option>();
    private String text;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
