def username = 'Jenkins'

pipeline {
    agent any
    environment {
        CC = 'clang'
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            environment {
                DEBUG_FLAGS = '-g'
            }
            steps {
                echo "Hello Mr. ${username}"
                echo "I said, Hello Mr. ${username}"
                echo 'Building'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
            }
        }
        stage('Deploy') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                echo 'Deploying'
            }
        }
    }
}