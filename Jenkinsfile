pipeline {
    environment {
        IMAGE_NAME = "025600686378.dkr.ecr.us-east-2.amazonaws.com/simple-jave-app"
        ACCOUNT_ID = "025600686378.dkr.ecr.us-east-2.amazonaws.com"
        REPO_NAME = "simple-jave-app"
        AWS_REGION = "us-east-2"
    }
    agent any
    tools {
        maven "Maven"
    }
    stages {
        stage("Testing Stage") {
            steps {
                echo "No test for now"
            }
        }
        stage("Building Stage") {
            steps {
                sh "mvn clean package"
            }
        }
        stage("Build Docker Image") {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${BUILD_ID} ."
            }
        }
        stage("Push to ECR") {
            steps {
                withCredentials([aws(credentialsId: 'aws-creds', region: 'us-east-2')]) {
                    sh "aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin ${IMAGE_NAME}"
                    sh "docker push ${IMAGE_NAME}:${BUILD_ID}"
                }
            }
        }
    }
}
