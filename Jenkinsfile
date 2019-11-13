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
                 container('kubectl'){
                    sh 'NODE_IP=$(kubectl get svc --namespace default selenium-grid-selenium-hub -o jsonpath="{.status.loadBalancer.ingress[0].ip}")'
                    sh 'echo $NODE_IP'
                    sh 'mvn clean -Dparam=1234 -P chrome,grid,localhost test'
                
            }
            }
        }
    }    
    
}
