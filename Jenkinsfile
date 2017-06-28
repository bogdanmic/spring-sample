pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/Default/bin/mvn clean install'
      }
    }
  }
}