pipeline {
    agent any
    tools {
        maven "Maven"
    }

    stages {
        stage ("Testing stage") {
            steps {
                echo "No test for now"
            }
        }
        stage ("Build Stage") {
            steps {
                sh "mvn clean package"
            }
        }

        stage ("Build DockerImage") {
            steps {
                sh "docker build -t agasprosper/simple-java-pipeline-project:${BUILD_ID} ."
            }
        } 
        stage ("Pushing to Docker Hub") {
            steps {
                script{
                    withCredentials([usernamePassword(credentialId: 'jenkins-to-access-dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push agasprosper/simple-java-pipeline-project:${BUILD_ID}"
                    }
                }
            }
        }
    }
}