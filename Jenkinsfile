def gv
pipeline{
    environment{
        IMAGE_NAME="simple-java-ap"
    }
    agent any
    tools{
        maven "Maven"
    }

    stages{
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }

        stage ("Testing Stage") {
            steps{
                echo "No test for now"
            }
        }
        stage ("Building stage") {
            steps{
                gv.buildJar()
            }
        }
        stage ("Build DockerImage") {
            steps{
                gv.buildImage()
            }
        }
        stage ("Pushing Image to Repo"){
            steps{
                gv.PushImage()
            }
        }
    }
}
