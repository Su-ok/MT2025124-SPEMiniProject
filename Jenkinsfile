pipeline {
    agent any
    
    // Check for GitHub changes every minute 
    triggers {
        pollSCM('* * * * *')
    }

    environment {
        // Replace with your Docker Hub ID [cite: 16]
        DOCKER_HUB_USER = "suchirokram" 
        IMAGE_NAME = "Scientific_calculator"
        DOCKER_CREDS = 'DockerHubCred'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clones your specific repository [cite: 12]
                checkout scm
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
                sh "ansible-playbook -i inventory.ini playbook_pull.yml"
            }
        }
    }

    post {
        always {
            // Clean up to save space on your host
            sh "docker system prune -f"
        }
    }
}
