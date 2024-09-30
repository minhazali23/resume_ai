package com.resume_ai.resume_ai.Model.DTO;

import java.sql.Timestamp;

public class ResumeAiDTO {
    private String emailAddress;
    private int totalScore;
    private String inconsistencies;
    private String exaggerated_claims;
    private String lack_of_detail;
    private String frequent_job_changes;
    private String missing_information;
    private int inconsistencies_Score;
    private int exaggerated_claims_Score;
    private int lack_of_detail_Score;
    private int frequent_job_changes_Score;
    private int missing_information_Score;
    private Timestamp timestamp;
    private String eval;

    public int getInconsistencies_Score() {
        return inconsistencies_Score;
    }

    public void setInconsistencies_Score(int inconsistencies_Score) {
        this.inconsistencies_Score = inconsistencies_Score;
    }

    public int getExaggerated_claims_Score() {
        return exaggerated_claims_Score;
    }

    public void setExaggerated_claims_Score(int exaggerated_claims_Score) {
        this.exaggerated_claims_Score = exaggerated_claims_Score;
    }

    public int getLack_of_detail_Score() {
        return lack_of_detail_Score;
    }

    public void setLack_of_detail_Score(int lack_of_detail_Score) {
        this.lack_of_detail_Score = lack_of_detail_Score;
    }

    public int getFrequent_job_changes_Score() {
        return frequent_job_changes_Score;
    }

    public void setFrequent_job_changes_Score(int frequent_job_changes_Score) {
        this.frequent_job_changes_Score = frequent_job_changes_Score;
    }

    public int getMissing_information_Score() {
        return missing_information_Score;
    }

    public void setMissing_information_Score(int missing_information_Score) {
        this.missing_information_Score = missing_information_Score;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
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
        return "ResumeAiDTO{" +
                "emailAddress='" + emailAddress + '\'' +
                ", totalScore=" + totalScore +
                ", inconsistencies='" + inconsistencies + '\'' +
                ", exaggerated_claims='" + exaggerated_claims + '\'' +
                ", lack_of_detail='" + lack_of_detail + '\'' +
                ", frequent_job_changes='" + frequent_job_changes + '\'' +
                ", missing_information='" + missing_information + '\'' +
                ", inconsistencies_Score='" + inconsistencies_Score + '\'' +
                ", exaggerated_claims_Score='" + exaggerated_claims_Score + '\'' +
                ", lack_of_detail_Score='" + lack_of_detail_Score + '\'' +
                ", frequent_job_changes_Score='" + frequent_job_changes_Score + '\'' +
                ", missing_information_Score='" + missing_information_Score + '\'' +
                ", timestamp=" + timestamp +
                ", eval='" + eval + '\'' +
                '}';
    }

}
