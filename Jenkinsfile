pipeline {
    environment {
        IMAGE_NAME="agasprosper/simple-java-pipeline-project:${BUILD_ID}"
    }
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
                sh "docker build -t $IMAGE_NAME ."
            }
        } 
        stage ("Pushing to Docker Hub") {
            steps {
                script{
                    withCredentials([usernamePassword(credentialsId: 'jenkins-to-access-dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push $IMAGE_NAME"
                    }
                }
            }
        }
        stage ("deployment stage") {
            steps {
                script {
                    def ShellCmd = "bash ./script.sh $IMAGE_NAME"
                    sshagent(["ssh-key"]) {
                        sh "scp -o StrictHostKeyCheching=no docker-compose.yml ec2-user@18.234.68.229 :/home/ec2-user"
                        sh "scp -o StrictHostKeyCheching=no script.sh ec2-user@18.234.68.229 :/home/ec2-user"
                        sh "ssh -o StrictHostKeyCheching=no ec2-user@18.234.68.229 :/home/ec2-user ${ShellCmd}" 
                        echo "SUCCESS"
                    }
                    
                }
            }
        }
    }
}
