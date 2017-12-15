#!/bin/bash
StackName=$1
wget https://raw.githubusercontent.com/likhith-3399/IntuitCodingChallange/master/src/main/resources/automation/ec2_cloudformation.json

aws cloudformation create-stack --stack-name $StackName --region us-east-1 --template-body file://./ec2_cloudformation.json
