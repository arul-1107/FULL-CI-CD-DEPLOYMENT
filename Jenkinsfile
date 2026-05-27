pipeline {
    agent any

    environment {
        BACKEND_IMAGE = "metallic-backend"
        FRONTEND_IMAGE = "metallic-frontend"
    }

    stages {

        stage('Clone Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/arul-1107/FULL-CI-CD-DEPLOYMENT'
            }
        }

        stage('Build Backend (Maven)') {
            steps {
                dir('metallic-backend') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Frontend (NPM)') {
            steps {
                dir('metallic-frontend') {
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                dir('metallic-backend') {
                    bat 'docker build -t %BACKEND_IMAGE% .'
                }

                dir('metallic-frontend') {
                    bat 'docker build -t %FRONTEND_IMAGE% .'
                }
            }
        }

        stage('Run Containers') {
            steps {
                bat 'docker stop backend || exit 0'
                bat 'docker rm backend || exit 0'

                bat 'docker stop frontend || exit 0'
                bat 'docker rm frontend || exit 0'

                bat 'docker run -d --name backend -p 8090:8080 %BACKEND_IMAGE%'
                bat 'docker run -d --name frontend -p 90:80 %FRONTEND_IMAGE%'
            }
        }
    }
}
