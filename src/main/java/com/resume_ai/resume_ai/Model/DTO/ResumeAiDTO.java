package com.resume_ai.resume_ai.Model.DTO;

import java.sql.Timestamp;

public class ResumeAiDTO {

    private String emailAddress;
    private int score;
    private Timestamp timestamp;
    private String eval;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }

    @Override
    public String toString() {
        return "ResumeAiDTO{" +
                "emailAddress='" + emailAddress + '\'' +
                ", score=" + score +
                ", timestamp=" + timestamp +
                ", eval='" + eval + '\'' +
                '}';
    }
}
