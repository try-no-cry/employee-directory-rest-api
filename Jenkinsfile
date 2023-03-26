pipeline{
    agent any
    tools{
        maven 'MAVEN_HOME'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/try-no-cry/employee-directory-rest-api']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    bat 'docker build -t abhaytiwari/employee-repository-api .'
                }
            }
        }
        stage('Push Image to docker hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerpwd')]) {
                                
                                    bat 'docker login -u abhaytiwari -p %dockerpwd%'
                            }
                           
                    
                    bat 'docker push abhaytiwari/employee-repository-api'
                }
            }
        }
    }
}