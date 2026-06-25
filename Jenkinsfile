pipeline {
    agent {
        node {
            label "maven"
        }
    }

    environment {
        PATH = "/opt/maven/bin:$PATH"
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-user-pass')
        GITHUB_TOKEN = credentials('github-token')
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('docker login and push image to docker hub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                sh 'docker build -t 890iop/myapp:latest .'
                sh 'docker push 890iop/myapp:latest'
            }
        }
        stage('deploy to k8s') {
            steps {
                script{
                sh './k8s/deploy.sh'
                sh 'kubectl rollout restart deployment.apps/myapp-deployment'
                }
            }
        }
    }
}
