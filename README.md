# Resume AI

A Spring Boot service to process, analyze, and store resume data using an ETL pipeline, Amazon DynamoDB, and OpenAI integration.

## Features

- ETL pipeline to extract and transform resume content
- Store parsed resume entities in DynamoDB
- Integrates with OpenAI to enrich / analyze resume content
- Simple REST API for submitting and retrieving resume data

## Tech stack

- Java, Spring Boot
- Maven (wrapper included)
- Amazon DynamoDB

## Getting started

Prerequisites:

- Java 17 or later
- Maven (or use the included `mvnw` wrapper)
- AWS credentials with access to DynamoDB (or a local DynamoDB endpoint)
- OpenAI API key (if using the OpenAI integration)

Build:

```bash
./mvnw clean package
```

Run (development):

```bash
./mvnw spring-boot:run
```

Run the produced jar:

```bash
java -jar target/*.jar
```

## Configuration

Application configuration is in src/main/resources/application.properties.

Important settings you may need to provide as environment variables or in the properties file:

- AWS access: `AWS_ACCESS_KEY_ID`, `AWS_SECRET_ACCESS_KEY`, and `AWS_REGION`
- DynamoDB endpoint (for local testing): `dynamodb.endpoint` or configure in `DynamoDbConfig`
- OpenAI API key: set as `OPENAI_API_KEY` or configure in `OpenAiServiceClient`

Key project files:

- `src/main/java/com/resume_ai/resume_ai/ResumeAiApplication.java` - Spring Boot entrypoint
- `src/main/java/com/resume_ai/resume_ai/Configuration/DynamoDbConfig.java` - DynamoDB configuration
- `src/main/java/com/resume_ai/resume_ai/Service/OpenAiServiceClient.java` - OpenAI integration
- `src/main/java/com/resume_ai/resume_ai/Controller/RestController.java` - REST endpoints
- `src/main/java/com/resume_ai/resume_ai/Repository/ResumeAiRepository.java` - DynamoDB repository

## API

The service exposes REST endpoints (see `RestController`) for submitting resumes and retrieving processed entities. Use common tools like `curl` or Postman to interact.

Example (replace host and port as needed):

```bash
curl -X POST http://localhost:8080/api/resume -H "Content-Type: application/json" -d '{"rawText":"..."}'
```

## Tests

Run unit tests with:

```bash
./mvnw test
```

## Troubleshooting

- If DynamoDB access fails, confirm AWS credentials and region, or use a local DynamoDB endpoint and update `DynamoDbConfig`.
- For OpenAI failures, verify `OPENAI_API_KEY` and check network access.

## Next steps

- Add API documentation (Swagger/OpenAPI)
- Add CI pipeline to run tests and package artifacts
- Add more robust error handling and retry logic for external calls

## License & Contact

Add an appropriate license file if you plan to open-source this project. For questions, contact the project maintainer.
