pipeline {
  agent {
    kubernetes {
      yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: maven
    image: maven:3.9.6-eclipse-temurin-17
    command:
    - cat
    tty: true

  - name: sonar
    image: sonarsource/sonar-scanner-cli:latest
    command:
    - cat
    tty: true

  - name: docker
    image: docker:26-cli
    command:
    - cat
    tty: true
    volumeMounts:
    - name: dockersock
      mountPath: /var/run/docker.sock

  volumes:
  - name: dockersock
    hostPath:
      path: /var/run/docker.sock
'''
    }
  }

  stages {

    stage('Checkout') {
      steps {
        container('maven') {
          git branch: 'sahem',
              url: 'https://github.com/Sahemomrane/tasnim_sahem.git',
              credentialsId: 'github-token'
        }
      }
    }

    stage('Maven Build') {
      steps {
        container('maven') {
          sh 'mvn clean package -DskipTests'
        }
      }
    }

    stage('SonarQube Analysis') {
      steps {
        container('sonar') {
          withSonarQubeEnv('sonarqube') {
            sh '''
              sonar-scanner \
              -Dsonar.projectKey=tasnim-app \
              -Dsonar.sources=src \
              -Dsonar.java.binaries=target
            '''
          }
        }
      }
    }

    stage('Docker Build') {
      steps {
        container('docker') {
          sh 'docker build -t tasnim-app:latest .'
        }
      }
    }

  }

  post {
    success {
      echo 'Pipeline terminé avec succès ✅'
    }
    failure {
      echo 'Pipeline échoué ❌'
    }
  }
}
