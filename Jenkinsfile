pipeline {
    agent any
    tool {
        maven "Maven"
    }

    stages {
        stage ("Checkout stage") {
            steps {
                echo "this is a checkout stage"
            }
        }
        stage ("Build Stage") {
            steps {
                echo "this is a Build stage"
            }
        }

        stage ("Deploy Stage") {
            steps {
                echo "this is my deployment stage"
            }
        }
    }
}