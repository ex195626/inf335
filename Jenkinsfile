pipeline {
    agent any

    tools {
        jdk 'JDK11'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ex195626/inf335.git'
            }
        }

        stage('Clean & Dependencies') {
            steps {
                bat 'mvn clean install -DskipTests=true'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            cleanWs()
        }

        success {
            echo 'Pipeline executado com sucesso!'
        }

        failure {
            echo 'O pipeline falhou. Verifique os logs.'
        }
    }
}