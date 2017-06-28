pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool(name: 'Maven', type: 'mvn')
        sh 'mvn clean install'
      }
    }
  }
}