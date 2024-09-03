package com.resume_ai.resume_ai.Model.Entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.sql.Timestamp;

@DynamoDBTable(tableName = "Resumes")
public class ResumeAiEntity {

    @DynamoDBHashKey(attributeName = "emailAddress")
    private String emailAddress;
    @DynamoDBAttribute(attributeName = "score")
    private int score;
    @DynamoDBAttribute(attributeName = "timestamp")
    private Timestamp timestamp;
    @DynamoDBAttribute(attributeName = "eval")
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
        return "ResumeAiEntity{" +
                "emailAddress='" + emailAddress + '\'' +
                ", score=" + score +
                ", timestamp=" + timestamp +
                ", eval='" + eval + '\'' +
                '}';
    }
}
