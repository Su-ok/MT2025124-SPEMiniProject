pipeline {
    agent any
    
    // Just checking commit with ngrok
    // Switch from Polling to Webhook trigger
    triggers {
        githubPush()
    }

    environment {
        // Replace with your Docker Hub ID [cite: 16]
        DOCKER_HUB_USER = "suchirokram" 
        IMAGE_NAME = "scientific_calculator"
        DOCKER_CREDS = 'DockerHubCred'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clones your specific repository [cite: 12]
                //checkout scm
                git branch: 'main', url: 'https://github.com/Su-ok/MT2025124-SPEMiniProject.git'
            }
        }

        stage('Unit Tests') {
            steps {
                // Runs the tests in ScientificCalcTest.java
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                // Builds the image using the Dockerfile above [cite: 15]
                sh "docker build -t ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                // Pushes the image to Docker Hub [cite: 16]
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDS}", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
                    sh "docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
                }
            }
        }

        stage('Ansible Deployment') {
            steps {
                // Deploys using your local Ansible playbook [cite: 17, 18]
                sh "ansible-playbook -i inventory.ini ansbldeploy.yml"
            }
        }
    }

    post {
        success {
            // Sends email on successful build
            mail to: 'noiropx59@gmail.com',
                 subject: "Success: Pipeline ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build successful! View details: ${env.BUILD_URL}"
        }
        failure {
            // Sends email on failed build
            mail to: 'noiropx59@gmail.com',
                 subject: "Failure: Pipeline ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build failed! Please check the logs here: ${env.BUILD_URL}"
        }
    }
}
