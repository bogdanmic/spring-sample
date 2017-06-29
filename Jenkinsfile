node {
    try {
        notifyBuild('STARTED')

        stage('Checkout') {
            echo 'Checking out....'
            checkout scm
        }

        stage('Build') {
            echo 'Building....'
            docker.image('maven:3-jdk-8').inside {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            echo 'Testing....'
        }

        stage('Deploy') {
            echo 'Deploying....'
        }

    } catch (e) {
        // If there was an exception thrown, the build failed
        currentBuild.result = "FAILED"
        throw e
    } finally {
        // Success or failure, always send notifications
        notifyBuild(currentBuild.result)
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    // Default values
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"

    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        // Here we can also use hexa values like #FF00FF and such
        colorCode = 'warning'
    } else if (buildStatus == 'SUCCESSFUL') {
        colorCode = 'good'
    } else {
        colorCode = 'danger'
    }

    // Send notifications
    slackSend(color: colorCode, message: summary)
}