pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''gradle build
gradle javadoc
gradle uploadArchives'''
      }
    }
    stage('Mail Notification') {
      steps {
        echo 'Mail Notification'
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