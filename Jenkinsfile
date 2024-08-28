pipeline {
    agent any
    tool 'Maven'
    stages {
        stage("Building Stage") {
            steps {
                sh "mvn clean package"
            }
        }
    }
}