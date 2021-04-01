
# Example on how to emulate AWS environment on local machine

Example on how to emulate AWS environment on local machine

**Steps**

* Install Docker
* Install docker-compose
* Install AWS Cli:
*(sudo apt install awscli)
https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html
* Configure - Configure Aws
aws configure --profile localstack
* Localstack Documentation: https://github.com/localstack/localstack
* Serverless (optional - not presented in the lecture): https://www.npmjs.com/package/serverless-localstack
* Docker-compose of the full presentation: https://github.com/cloud4java/localstack-example.git
* Optional: use project s3-sample to test creating and delete a s3 bucket.

* Reference Article: https://blog.jcore.com/2020/04/running-aws-locally-with-localstack/
