pipeline {
    agent any

   

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
            junit '**/target/surefire-reports/testng-results.xml'
        }
    }
}
