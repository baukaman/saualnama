package com.rc.saualnama.opros;

/**
 * Created with IntelliJ IDEA.
 * User: Bauyrzhan
 * Date: 4/10/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class OprosRaw {
    private long oprosId;
    private long questionId;
    private long optionId;
    private String ownerName;
    private String text;
    private long count;

    public long getOprosId() {
        return oprosId;
    }

    public void setOprosId(long oprosId) {
        this.oprosId = oprosId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
