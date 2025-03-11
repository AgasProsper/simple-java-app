pipeline{
    environment{
        IMAGE_NAME="prosperagada/simple-java-app"
    }
    agent any
    tools{
        maven "Maven"
    }
    stages{
        stage ("Testing Stage") {
            steps{
                echo "No test for now"
            }
        }
        stage ("Building stage") {
            steps{
                sh "mvn clean package"
            }
        }
        stage ("Build DockerImage") {
            steps{
                sh "docker build -t ${IMAGE_NAME}:${BUILD_ID} ."
            }
        }
        stage ("push to docker hub") {
            steps{
                withCredentials([usernamePassword(credentialsId: "Jekins-DockerHub-cred", passwordVariable: "PASS",usernameVariable: "USER"  )]){
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker push ${IMAGE_NAME}:${BUILD_ID}"
                } 
            }
        }
    }
}
