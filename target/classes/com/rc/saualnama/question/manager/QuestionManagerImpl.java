package com.rc.saualnama.question.manager;

import com.rc.saualnama.question.repository.QuestionRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Bauka
 * Date: 4/9/13
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class QuestionManagerImpl implements QuestionManager {
    private QuestionRepository questionRepository;
    @Override
    public Long addQuestion(String text) {
        return getQuestionRepository().createNewQuestion(text);
    }

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
