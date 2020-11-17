#!/usr/bin/env groovy

def call(String buildResult,String stageName) {
  if ( buildResult == "SUCCESS" ) {
    slackSend channel: 'devops',color: 'good', message: "Stage \'${stageName}\' within ${JOB_NAME} with buildnumber ${BUILD_NUMBER} has completed, check ${BUILD_URL}", teamDomain: 'projectdevops', tokenCredentialId: 'Slackcred'
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend channel: 'devops',color: 'danger', message: "Stage \'${stageName}\' within ${JOB_NAME} with buildnumber ${BUILD_NUMBER} has failed, check ${BUILD_URL}", teamDomain: 'projectdevops', tokenCredentialId: 'Slackcred'
  }
  else {
      slackSend channel: 'devops',color: 'warning', message: "status for ${JOB_NAME} with buildnumber ${BUILD_NUMBER} unclear", teamDomain: 'projectdevops', tokenCredentialId: 'Slackcred'
  }
}