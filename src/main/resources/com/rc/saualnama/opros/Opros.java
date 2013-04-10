package com.rc.saualnama.opros;

import com.rc.saualnama.question.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bauka
 * Date: 4/8/13
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Opros {
    private Long oprosId;
    private List<Question> questions = new ArrayList<Question>();


    public Long getOprosId() {
        return oprosId;
    }

    public void setOprosId(Long oprosId) {
        this.oprosId = oprosId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
