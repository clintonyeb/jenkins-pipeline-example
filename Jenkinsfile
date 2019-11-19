pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn package'
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
            dir("${env.WORKSPACE}/target"){
                sh "pwd"
            }
            archiveArtifacts artifacts: "${env.WORKSPACE}/targets/jenkins-pipeline-example-1.0-SNAPSHOT.jar", fingerprint: true
        }
    }
}
