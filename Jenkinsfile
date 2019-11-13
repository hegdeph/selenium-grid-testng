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
                 
                    sh 'apt-get install maven'
                    sh 'apt update'
                    sh 'mvn clean  -P chrome,grid,localhost test'
                
            
            }
        }
    }    
    
}
