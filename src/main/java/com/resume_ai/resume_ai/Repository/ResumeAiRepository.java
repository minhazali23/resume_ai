package com.resume_ai.resume_ai.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.resume_ai.resume_ai.Model.DTO.ResumeAiDTO;
import com.resume_ai.resume_ai.Model.Entities.ResumeAiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;

@Repository
public class ResumeAiRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    //CREATE
    public ResumeAiDTO saveOneResume(ResumeAiDTO resumeAiDTO){

        ResumeAiEntity saveResumeAiEntity = new ResumeAiEntity();
        saveResumeAiEntity.setEmailAddress(resumeAiDTO.getEmailAddress());
        saveResumeAiEntity.setScore(resumeAiDTO.getTotalScore());
        saveResumeAiEntity.setEval(resumeAiDTO.getEval());
        saveResumeAiEntity.setTimestamp(resumeAiDTO.getTimestamp());

        saveResumeAiEntity.setInconsistencies(resumeAiDTO.getInconsistencies());
        saveResumeAiEntity.setExaggerated_claims(resumeAiDTO.getExaggerated_claims());
        saveResumeAiEntity.setLack_of_detail(resumeAiDTO.getLack_of_detail());
        saveResumeAiEntity.setFrequent_job_changes(resumeAiDTO.getFrequent_job_changes());
        saveResumeAiEntity.setMissing_information(resumeAiDTO.getMissing_information());

        saveResumeAiEntity.setInconsistencies_Score(resumeAiDTO.getInconsistencies_Score());
        saveResumeAiEntity.setExaggerated_claims_Score(resumeAiDTO.getExaggerated_claims_Score());
        saveResumeAiEntity.setLack_of_detail_Score(resumeAiDTO.getLack_of_detail_Score());
        saveResumeAiEntity.setFrequent_job_changes_Score(resumeAiDTO.getFrequent_job_changes_Score());
        saveResumeAiEntity.setMissing_information_Score(resumeAiDTO.getMissing_information_Score());

        dynamoDBMapper.save(saveResumeAiEntity);

        return resumeAiDTO;
    }

    //READ
    public ResumeAiDTO getOneResume(String emailAddress){
        ResumeAiDTO getOneResume = new ResumeAiDTO();
        try {
            ResumeAiEntity getResumeEntity = dynamoDBMapper.load(ResumeAiEntity.class, emailAddress);
            getOneResume.setEmailAddress(getResumeEntity.getEmailAddress());
            getOneResume.setTotalScore(getResumeEntity.getScore());
            getOneResume.setEval(getResumeEntity.getEval());
            getOneResume.setTimestamp(getResumeEntity.getTimestamp());

            getOneResume.setInconsistencies(getOneResume.getInconsistencies());
            getOneResume.setExaggerated_claims(getOneResume.getExaggerated_claims());
            getOneResume.setLack_of_detail(getOneResume.getLack_of_detail());
            getOneResume.setFrequent_job_changes(getOneResume.getFrequent_job_changes());
            getOneResume.setMissing_information(getResumeEntity.getMissing_information());

            getOneResume.setInconsistencies_Score(getOneResume.getInconsistencies_Score());
            getOneResume.setExaggerated_claims_Score(getOneResume.getExaggerated_claims_Score());
            getOneResume.setLack_of_detail_Score(getOneResume.getLack_of_detail_Score());
            getOneResume.setFrequent_job_changes_Score(getOneResume.getFrequent_job_changes_Score());
            getOneResume.setMissing_information_Score(getOneResume.getMissing_information_Score());

        }catch (NullPointerException ex){
            System.out.println(ex);
        }

        return getOneResume;
    }

    //UPDATE
    public ResumeAiDTO updateOneResume(ResumeAiDTO resumeAiDTO){
        ResumeAiEntity updatedResumeEntity = new ResumeAiEntity();
        updatedResumeEntity.setEmailAddress(resumeAiDTO.getEmailAddress());
        updatedResumeEntity.setScore(resumeAiDTO.getTotalScore());
        updatedResumeEntity.setEval(resumeAiDTO.getEval());
        updatedResumeEntity.setTimestamp(Timestamp.from(Instant.now()));

        updatedResumeEntity.setInconsistencies(resumeAiDTO.getInconsistencies());
        updatedResumeEntity.setExaggerated_claims(resumeAiDTO.getExaggerated_claims());
        updatedResumeEntity.setLack_of_detail(resumeAiDTO.getLack_of_detail());
        updatedResumeEntity.setFrequent_job_changes(resumeAiDTO.getFrequent_job_changes());
        updatedResumeEntity.setMissing_information(resumeAiDTO.getMissing_information());

        updatedResumeEntity.setInconsistencies_Score(resumeAiDTO.getInconsistencies_Score());
        updatedResumeEntity.setExaggerated_claims_Score(resumeAiDTO.getExaggerated_claims_Score());
        updatedResumeEntity.setLack_of_detail_Score(resumeAiDTO.getLack_of_detail_Score());
        updatedResumeEntity.setFrequent_job_changes_Score(resumeAiDTO.getFrequent_job_changes_Score());
        updatedResumeEntity.setMissing_information_Score(resumeAiDTO.getMissing_information_Score());

        DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
                .build();

        dynamoDBMapper.save(updatedResumeEntity, dynamoDBMapperConfig);

        return resumeAiDTO;
    }

    //DELETE
    public void deleteOneResume(String emailAddress){
        ResumeAiEntity deleteThisResume = new ResumeAiEntity();
        deleteThisResume.setEmailAddress(emailAddress);
        dynamoDBMapper.delete(deleteThisResume);
    }

}
