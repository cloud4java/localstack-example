package com.silva.awsexample;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.*;

/**
 * Example on how to manipulate S3 Buckets either on real AWS or emulated on LocalStack.
 */
public class S3Sample{

    private String s3Endpoint = "http://localhost:4566/";
//    private String s3Endpoint = "https://s3.us-west-1.amazonaws.com";

//    private String awsRegion = "us-east-1";
    private String awsRegion = "us-west-1";

    public static void main(String[] args) {
        new S3Sample().uploads3File();
    }

    public void uploads3File() {
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(s3Endpoint,awsRegion))
                .withPathStyleAccessEnabled(true)
//                .withCredentials(new ProfileCredentialsProvider("default"))
                .build();

        String myBucket = "bucket-310321";

        s3.createBucket(myBucket);

        System.out.println("client = " + s3.listBuckets());

        s3.deleteBucket(myBucket);

        System.out.println("client = " + s3.listBuckets());
    }
}