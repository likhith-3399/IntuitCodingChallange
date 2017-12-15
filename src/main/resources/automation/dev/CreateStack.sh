#!/bin/bash
StackName=$1
wget https://raw.githubusercontent.com/likhith-3399/IntuitCodingChallange/master/src/main/resources/automation/stack_cloudformation.json

#aws s3 sync . s3://mybucket/cloudformation --sse
aws cloudformation create-stack --stack-name $StackName --region us-east-1 --template-body file://./stack_cloudformation.json
