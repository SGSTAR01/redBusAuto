pipeline {
    agent any

    tools {

         maven 'mvn-3.9.8'
         jdk 'jdk-21'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Running tests using Maven
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Publish JUnit/TestNG test results
            junit 'target/surefire-reports/*.xml'

            // Archive the Cucumber HTML report and TestNG reports
            archiveArtifacts artifacts: 'target/cucumber-report.html, target/surefire-reports/**/*.html', allowEmptyArchive: true
        }
    }
}


