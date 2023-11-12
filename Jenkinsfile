#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    envirement {
        DOCKERHUB_CREDENTIALS = credentials('dH_cred')
    }
    stages {
        stage('init') {
            steps {
                sh '''
                cat DOCKERHUB_CREDENTIALS_PSW | docker login --username DOCKERHUB_CREDENTIALS_USR --password-stdin
                '''
            }
        }

        stage('Test') {
            steps {
                sh '''
                docker build -t $DOCKERHUB_CREDENTIALS_USR/$JOB_NAME:$BUILD_NUMBER .
                '''
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'mvn deploy'
            }
        }
    }
}
