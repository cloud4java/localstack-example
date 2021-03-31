package com.silva.awsexample;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;

public class DynamoDbSample {

    private static AmazonDynamoDB getAmazonDynamoDBClient() {
        //Create endpoint configuration which points to the Edge service (running on http://localhost:4566)
        AwsClientBuilder.EndpointConfiguration endpointConfig = new AwsClientBuilder.EndpointConfiguration("http://localhost:4566",
                Regions.EU_WEST_1.getName());

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(endpointConfig)
                .build();
    }
    private static CreateTableRequest getCreateTableRequest(){
        return new CreateTableRequest()
                .withAttributeDefinitions(new AttributeDefinition("Name", ScalarAttributeType.S))
                .withKeySchema(new KeySchemaElement("Name", KeyType.HASH))
                .withProvisionedThroughput(new ProvisionedThroughput(10L, 10L))
                .withTableName("MyTable");
    }

    public static void main(String[] args) {
        final AmazonDynamoDB amazonDynamoDBClient = getAmazonDynamoDBClient();
        final CreateTableRequest request = getCreateTableRequest();
        try {
            CreateTableResult result = amazonDynamoDBClient.createTable(request);
            System.out.println(result.getTableDescription().getTableName());
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
    }
}
