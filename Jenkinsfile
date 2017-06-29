pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out....'
                checkout scm
                slackSend color: '#ff0000', message: 'Test'
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