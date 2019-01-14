pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'E:\\Programs\\gradle-4.10\\bin\\gradle build '
        bat 'E:\\Programs\\gradle-4.10\\bin\\gradle javadoc'
        bat 'E:\\Programs\\gradle-4.10\\bin\\gradle uploadArchives'
      }
      post {
        failure {
          mail (subject: 'Build Phase End', body: 'There has been an error in the Build Phase.', from: 'Cypher', charset: 'utf-8', to: 'eng_rebatchi@outlook.fr')
        }
      }
    }
    stage('Mail Notification') {
      steps {
        mail (subject: 'Build Phase End', body: 'The build phase has been done successfully.', from: 'Cypher', charset: 'utf-8', to: 'eng_rebatchi@outlook.fr')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            waitForQualityGate true
          }
        }
        stage('Test Reporting') {
          steps {
            echo 'Test Reporting'
          }
        }
      }
    }
    stage('Deployment') {
      steps {
        echo 'Deployment'
      }
    }
    stage('Slack Notification') {
      steps {
        echo 'Slack Notification'
      }
    }
  }
}
