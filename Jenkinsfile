pipeline {
    agent any 
    options {
        skipStagesAfterUnstable()
    }
  stages {
        stage('Compile Stage') { 
            steps {
 		withMaven(maven:'maven_3_5_0'){
                sh 'mvn clean package -DskipTests' 
            }}
        stage('Testing Stage') { 
            steps { 
		withMaven(maven: 'maven_3_5_0')
                {sh 'mvn test'} 
            }
        }
        stage('Test'){
            steps {
                sh 'make check'
                junit 'reports/**/*.xml' 
            }
        }
        stage('Deployment Stage') {
            steps {
		withMaven(maven:'maven_3_5_0'){
                sh 'make publish'
            }}
}}