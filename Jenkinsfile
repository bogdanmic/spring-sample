pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        parallel(
          "Build": {
            sh 'mvn clean install'
            
          },
          "Wait": {
            sleep 3
            
          }
        )
      }
    }
  }
  environment {
    asdfa = 'asdfa'
  }
}