pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out....'
                checkout scm
                slackSend botUser: true, color: '#ff0000', message: 'Test slack'
            }
        }
        stage('Build') {
            steps {
                echo 'Building....'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing....'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}