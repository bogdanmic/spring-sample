pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool(name: 'Default', type: 'Maven')
        sh 'mvn clean install'
      }
    }
  }
}