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
                sh "docker build -t simple-java-app ."
            }
        }
    }
}