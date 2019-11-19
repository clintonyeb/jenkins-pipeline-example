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
            archiveArtifacts artifacts: 'targets/jenkins-pipeline-example.jar', fingerprint: true
        }
    }
}
