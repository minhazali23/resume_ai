package com.resume_ai.resume_ai.Constants;

public class ResumeAiConstants {

    public static final String PROMPT1 =
        "\"You are an expert in resume analysis and scoring. I have extracted text from a resume and need you to analyze it for specific red flags and assign a score based on the criteria provided. If there is nothing wrong, then you can give a score of 0. Please fill in the fields below and only provide a score with an overall assessment.\n" +
        "\n" +
        "Resume Analysis:\n" +
        "* Inconsistencies: [Any inconsistencies found, e.g., conflicting dates, contradictory information]. Score: [0-5]\n" +
        "* Exaggerated Claims: [Any claims that seem unrealistic or unsupported, e.g., excessive skill levels, unrealistic achievements]. Score: [0-4]\n" +
        "* Lack of Detail: [Vague or generic descriptions of responsibilities or accomplishments]. Score: [0-2]\n" +
        "* Frequent Job Changes: [Any patterns of short-term employment or unexplained reasons for leaving]. Score: [0-3]\n" +
        "* Missing Information: [Gaps in employment history that are not explained]. Score: [0-3]\n" +
        "* Plagiarism: [Evidence of copied or plagiarized content]. Score: [0-10]\n" +
        "* Summary: [Give me a short summary of your findings]\n" +
        "\n" +
        "Here is the extracted text:\n" +
        "\n" +
        "Please adhere strictly to the scoring criteria and ensure the response is accurate and concise.\"";
    public static final String PROMPT2 = "\n" +
            "Please adhere strictly to the scoring criteria and ensure the response is accurate and concise.";;

}
