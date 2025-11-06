def call (String Project, String ImageTag, String dockerHubuser){

 withCredentials([usernamePassword(
                    credentialsId: "dockerHubCred", 
                    usernameVariable: "dockerHubUser", 
                    passwordVariable: "dockerHubPass")]){
                sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
      }

    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
