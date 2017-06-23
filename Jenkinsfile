pipeline {
  agent any
  stages {
    stage('Wait') {
      steps {
        parallel(
          "Wait": {
            sleep 3
            echo 'Test'
            
          },
          "Tst": {
            echo 'tst2'
            
          },
          "JavaV": {
            sh 'java -version'
            
          },
          "Build": {
            sh 'mvn clean install'
            
          }
        )
      }
    }
    stage('TEST') {
      steps {
        echo 'Another msg'
      }
    }
    stage('Final') {
      steps {
        echo 'done'
      }
    }
  }
  environment {
    asdfa = 'asdfa'
  }
}