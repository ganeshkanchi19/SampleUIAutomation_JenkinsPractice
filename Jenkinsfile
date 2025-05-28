pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven 3' // Make sure 'Maven 3' is configured in Jenkins tools
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ganeshkanchi19/SampleUIAutomation_JenkinsPractice.git' // Replace with your repo URL
            }
        }

        stage('Build & Run Package Tests') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn clean test -DsuiteXmlFile=testng.xml"
                }
            }
        }
    }

    post {
        always {
            testng '**/target/surefire-reports/testng-results.xml'
        }
    }
}
