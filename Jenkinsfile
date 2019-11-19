pipeline {
    agent {
        docker {
            image 'maven:3.3.3'
            args "-v /root/.m2:/root/.m2"
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    environment {

    }
    stages {
        stage('Build') {
            steps {
                sh 'echo "Building Project"'
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Testing Project"'
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
            archiveArtifacts artifacts: "target/jenkins-pipeline-example-1.0-SNAPSHOT.jar", fingerprint: true
        }
        always {
            echo 'One way or another, I have finished'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
    }
}
