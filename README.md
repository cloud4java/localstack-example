
  
# Example on how to emulate AWS environment on local machine  
  
Example on how to emulate AWS environment on local machine  
  
**Steps**  
  
* Install Docker  
* Install docker-compose  
* Install AWS Cli:  
```
 sudo apt install awscli  
```
https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html  
* Configure - Configure Aws
```
aws configure --profile localstack 
```
 
* Localstack Documentation: https://github.com/localstack/localstack  
* Serverless (optional - not presented in the lecture): https://www.npmjs.com/package/serverless-localstack  
* Docker-compose of the full presentation: https://github.com/cloud4java/localstack-example.git  
* Optional: use the project **s3-sample** to create and delete a s3 bucket.  

    **Localstack S3 Commands**
  ``` 
  aws --endpoint=http://localhost:4566 s3 ls                                           
                                                                                        
  aws --endpoint=http://localhost:4566 s3 mb s3://bucket-222                             
                                                                                         
  aws --endpoint=http://localhost:4566 s3 cp gradlew.bat s3://bucket-222                 
                                                                                         
  aws --endpoint=http://localhost:4566 s3 ls s3://bucket-222                             
                                                                                         
  aws --endpoint=http://localhost:4566 s3 cp ./src/ s3://bucket-222 --recursive          
                                                                                         
  aws --endpoint=http://localhost:4566 s3 ls bucket-222                                  
                                                                                         
  aws --endpoint=http://localhost:4566 s3 ls bucket-222 --recursive                      
                                                                                         
     ``` 

* Reference Article: https://blog.jcore.com/2020/04/running-aws-locally-with-localstack/


