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
            
          }
        )
      }
    }
    stage('TEST') {
      steps {
        echo 'Another msg'
        waitUntil() {
          echo '111'
          echo '2222'
        }
        
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