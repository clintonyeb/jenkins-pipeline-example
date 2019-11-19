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
        SECRET_PHRASE = 'peanut butter cheese'
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
        stage('Deploy') {
            input {
                message "Should we continue?"
                ok "Yes, we should."
                parameters {
                    string(name: 'local_phrase', description: 'Provide the top secret phrase')
                }
            }
            when {
                sh "echo ${SECRET_PHRASE}"
                sh "echo ${params.local_phrase}"
                expression { params.local_phrase.equals(env.SECRET_PHRASE) }
            }
            steps {
                sh 'echo "Building Project"'
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
