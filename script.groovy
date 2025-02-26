def buildJar(){
    echo "building java app"
    sh "mvn clean package"
}

def buildImage(){
    echo "building docker image"
    sh "docker build -t ${IMAGE_NAME}:${BUILD_ID} ."
}

def PushImage(){
    echo "Pushing image to docker hub"
    withCredentials([usernamePassword(credentialsId: "docker-repo-cred", passwordVariable: "PASSWORD", usernameVariable: "USERNAME")]){
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker push ${IMAGE_NAME}:${BUILD_ID}"
    }
}
