pipeline {
    agent {
        docker {
            image 'maven:3.3.3'
            args '-v /root/.m2:/root/.m2'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE = 'sqlite'
    }
    stages {
        stage('build') {
            steps {
                echo "Database engine is ${DB_ENGINE}"
                echo "DISABLE_AUTH is ${DISABLE_AUTH}"
                sh 'printenv'
                sh 'mvn clean package'
            }
        }
        stage('test') {
            steps {
                sh 'echo "Testing Project"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
                sh 'mvn test'
            }
        }
    }
    post {
        success {
            echo 'I succeeeded!'
            dir("${env.WORKSPACE}/target"){
                sh "pwd"
                sh "ls"
            }
            archiveArtifacts artifacts: "jenkins-pipeline-example-1.0-SNAPSHOT.jar", fingerprint: true
        }
        always {
            echo 'One way or another, I have finished'
            junit 'target/surefire-reports/*.xml'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
            mail to: 'clintonyeb@gmail.com',
                    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Something is wrong with ${env.BUILD_URL}"
        }
        changed {
            echo 'Things were different before...'
        }
    }
}
