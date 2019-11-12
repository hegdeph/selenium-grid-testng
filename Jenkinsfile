pipeline{
    agent any
    
    environment {
      SKIP_THIS_VAR = ''
    }
    
    stages{
    
        stage('source'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
                doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
                userRemoteConfigs: [[url: 'https://github.com/hegdeph/selenium-grid-testng']]])
            }
        }
    
        
    
        stage('run unit test'){
            steps{
                dir('test'){
                    sh 'pwd'
                    
                    sh 'uname -a'
                    sh 'apt-get update'
                    sh 'apt-get install -y maven'
                    
                    sh 'cd /var/jenkins_home/workspace/sele-maven'
                    sh 'pwd'
                    sh 'ls -lrt'
                    sh 'mvn clean -P chrome,grid,localhost test'
                }
            }
        }
    }    
    
}
