pipeline {
    agent any

    tools {
        maven 'M2_HOME'
    }

    stages {

        stage('GIT') {
            steps {
                git branch: 'sahem',
                    url: 'https://github.com/Sahemomrane/tasnim_sahem.git',
                    credentialsId: 'github-token'
            }
        }

        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('MVN COMPILE') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('SONARQUBE') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('DOCKER BUILD') {
            steps {
                sh 'docker build -t tasnim-app:latest .'
            }
        }

        stage('DEPLOY TO KUBERNETES') {
            steps {
                sh '''
                  kubectl apply -f k8s-deployment.yaml
                  kubectl apply -f k8s-service.yaml
                '''
            }
        }
    }

    post {
        success {
            echo 'CI/CD terminé avec succès 🚀'
        }
        failure {
            echo 'Pipeline échoué ❌'
        }
    }
}
