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
        saveResumeAiEntity.setScore(resumeAiDTO.getScore());
        saveResumeAiEntity.setEval(resumeAiDTO.getEval());
        saveResumeAiEntity.setTimestamp(resumeAiDTO.getTimestamp());

        dynamoDBMapper.save(saveResumeAiEntity);

        return resumeAiDTO;
    }

    //READ
    public ResumeAiDTO getOneResume(String emailAddress){
        ResumeAiDTO getOneResume = new ResumeAiDTO();
        try {
            ResumeAiEntity getResumeEntity = dynamoDBMapper.load(ResumeAiEntity.class, emailAddress);
            getOneResume.setEmailAddress(getResumeEntity.getEmailAddress());
            getOneResume.setScore(getResumeEntity.getScore());
            getOneResume.setEval(getResumeEntity.getEval());
            getOneResume.setTimestamp(getResumeEntity.getTimestamp());
        }catch (NullPointerException ex){
            System.out.println(ex);
        }

        return getOneResume;
    }

    //UPDATE
    public ResumeAiDTO updateOneResume(ResumeAiDTO resumeAiDTO){
        ResumeAiEntity updatedResumeEntity = new ResumeAiEntity();
        updatedResumeEntity.setEmailAddress(resumeAiDTO.getEmailAddress());
        updatedResumeEntity.setScore(resumeAiDTO.getScore());
        updatedResumeEntity.setEval(resumeAiDTO.getEval());
        updatedResumeEntity.setTimestamp(Timestamp.from(Instant.now()));

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
