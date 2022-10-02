pipeline {
    agent any
    stages {
        stage('git repo clone') {
            steps {
                git branch: 'main', url: 'https://github.com/RemyaPillai99/FoodBox-BackEnd.git'
            }
        }
      stage('Maven Compile') {
            steps {
                echo '----------------- This is a compile phase ----------'
                sh 'mvn clean compile'
            }
        }
        
         stage('Maven Test') {
            steps {
                echo '----------------- This is a compile phase ----------'
                sh 'mvn clean test'
            }
        }
        
        stage('Maven Build') {
             steps {
                echo '----------------- This is a build phase ----------'
                sh 'mvn clean package -DskipTests'
            }
        }
//         stage('docker compose') {
//             steps {
//                 sh "docker-compose up"
//             }
//         }
//         stage('docker build') {
//             steps {
//                 sh "docker build -t my-movie-plan ."
//             }
//         }
        stage('docker run') {
             steps {
                 sh "docker run -p 5555:5555 --name foodBox-backend --link mysql-foodBox -d foodBox-backend:1.0"
             }
        }
    }
}