pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'E:\\Programs\\gradle-4.10\\bin\\gradle build '
        bat 'E:\\Programs\\gradle-4.10\\bin\\gradle javadoc'
        bat 'E:\\Programs\\gradle-4.10\\bin\\gradle uploadArchives'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: 'Build Phase End', body: 'The build phase has been done successfully.', from: 'Cypher', charset: 'utf-8', to: 'fh_rebatchi@esi.dz')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            echo 'Code Analysis'
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