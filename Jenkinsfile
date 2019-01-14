pipeline {
  agent any
  stages {
    stage('Build') {
      post {
        failure {
          mail(subject: 'Build Phase End', body: 'There has been an error in the Build Phase.', from: 'Cypher', charset: 'utf-8', to: 'eng_rebatchi@outlook.fr')

        }

      }
      steps {
        bat 'gradle build '
        bat 'gradle javadoc'
        bat 'gradle jar'
        archiveArtifacts 'build/libs/*.jar'
        archiveArtifacts 'build/docs/javadoc/'
      }
    }
    stage('Mail Notification') {
      steps {
        mail(subject: 'Build Phase End', body: 'The build phase has been done successfully.', from: 'Cypher', charset: 'utf-8', to: 'eng_rebatchi@outlook.fr')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            withSonarQubeEnv('sonarqube') {
              bat 'E:\\Programs\\Sonar Scanner\\sonar-scanner-3.2.0.1227-windows\\bin\\sonar-scanner'
            }

            waitForQualityGate true
          }
        }
        stage('Test Reporting') {
          steps {
            jacoco(buildOverBuild: true, changeBuildStatus: true)
          }
        }
      }
    }
    stage('Deployment') {
      when {
        not {
          changeRequest target: 'master'
        }

      }
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      steps {
        echo 'Slack Notification'
      }
    }
  }
}
