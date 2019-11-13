pipeline{
    
    agent {
    kubernetes {
      label 'default'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  serviceAccountName: esteemed-bear-jenkins
  containers:
  - name: golang
    image: golang:1.10
    command:
    - cat
    tty: true
  - name: gcloud
    image: gcr.io/cloud-builders/gcloud
    command:
    - cat
    tty: true
  - name: mvn
    image: gcr.io/cloud-builders/mvn
    command:
    - cat
    tty: true    
  - name: kubectl
    image: gcr.io/cloud-builders/kubectl
    command:
    - cat
    tty: true
"""
}
}
    
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
