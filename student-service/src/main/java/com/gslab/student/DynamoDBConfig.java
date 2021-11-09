package com.gslab.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.gslab.student.entity.Student;


@Configuration
public class DynamoDBConfig {
	
	@Value("${aws.accessKey}")
	private String awsAccessKey;
	
	@Value("${aws.secretKey}")
	private String awsSecretKey;
	
	@Value("${aws.endPointUrl}")
    private String endPointUrl;

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPointUrl, "us-west-2"))
				.withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
				.build();
				//.withRegion(Regions.AP_SOUTHEAST_2).build();
		DynamoDBMapper dynamoMapper = new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
		init(dynamoMapper,client);
		return dynamoMapper;
				
	}

	

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
	}
	
	public void init(DynamoDBMapper dynamoMapper, AmazonDynamoDB client) {
		CreateTableRequest tableRequest = dynamoMapper.generateCreateTableRequest(Student.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		
		if(TableUtils.createTableIfNotExists(client, tableRequest)) {
			System.out.println("table created");
		}
		
	}
}
