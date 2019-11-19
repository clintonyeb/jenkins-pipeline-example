pipeline {
    agent any
    stage('Deploy - Staging') {
        steps {
            sh './deploy staging'
            sh './run-smoke-tests'
        }
    }

    stage('Sanity check') {
        steps {
            input "Does the staging environment look ok?"
        }
    }

    stage('Example') {
        input {
            message "Should we continue?"
            ok "Yes, we should."
            parameters {
                string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
            }
        }
        steps {
            echo "Hello, ${PERSON}, nice to meet you."
        }
    }

    stage('Deploy - Production') {
        steps {
            sh './deploy production'
        }
    }
}
