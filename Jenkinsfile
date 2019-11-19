def username = 'Jenkins'

pipeline {
    agent any
    environment {
        AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
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