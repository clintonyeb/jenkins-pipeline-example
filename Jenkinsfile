pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
                sh 'javac -d . src/*.java'
                sh 'echo Main-Class: Rectangulator > MANIFEST.MF'
                sh 'jar -cvmf MANIFEST.MF rectangle.jar *.class'
            }
        }
        stage('run') {
            steps {
                sh 'java -jar rectangle.jar 7 9'
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'rectangle.jar', fingerprint: true
        }
    }
}
