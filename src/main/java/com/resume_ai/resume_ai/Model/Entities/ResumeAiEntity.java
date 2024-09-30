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
    @DynamoDBAttribute(attributeName = "inconsistencies")
    private String inconsistencies;
    @DynamoDBAttribute(attributeName = "exaggeratedClaims")
    private String exaggerated_claims;
    @DynamoDBAttribute(attributeName = "lackOfDetail")
    private String lack_of_detail;
    @DynamoDBAttribute(attributeName = "frequentJobChanges")
    private String frequent_job_changes;
    @DynamoDBAttribute(attributeName = "missingInformation")
    private String missing_information;

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

    public String getInconsistencies() {
        return inconsistencies;
    }

    public void setInconsistencies(String inconsistencies) {
        this.inconsistencies = inconsistencies;
    }

    public String getExaggerated_claims() {
        return exaggerated_claims;
    }

    public void setExaggerated_claims(String exaggerated_claims) {
        this.exaggerated_claims = exaggerated_claims;
    }

    public String getLack_of_detail() {
        return lack_of_detail;
    }

    public void setLack_of_detail(String lack_of_detail) {
        this.lack_of_detail = lack_of_detail;
    }

    public String getFrequent_job_changes() {
        return frequent_job_changes;
    }

    public void setFrequent_job_changes(String frequent_job_changes) {
        this.frequent_job_changes = frequent_job_changes;
    }

    public String getMissing_information() {
        return missing_information;
    }

    public void setMissing_information(String missing_information) {
        this.missing_information = missing_information;
    }

    @Override
    public String toString() {
        return "ResumeAiEntity{" +
                "emailAddress='" + emailAddress + '\'' +
                ", score=" + score +
                ", timestamp=" + timestamp +
                ", eval='" + eval + '\'' +
                ", inconsistencies='" + inconsistencies + '\'' +
                ", exaggerated_claims='" + exaggerated_claims + '\'' +
                ", lack_of_detail='" + lack_of_detail + '\'' +
                ", frequent_job_changes='" + frequent_job_changes + '\'' +
                ", missing_information='" + missing_information + '\'' +
                '}';
    }

}
