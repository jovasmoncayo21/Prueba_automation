pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

    tools {
        maven 'Maven 3.9.9' // Asegúrate de que este nombre coincida con el que configuraste en Jenkins > Global Tool Configuration
        jdk 'JDK 17'         // También ajusta si usas otra versión de Java
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Descargando código..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Compilando el proyecto..."
                sh 'mvn clean compile'
            }
        }

        stage('Ejecución clase Main') {
            steps {
                echo "Ejecutando clase principal (Main)..."
                sh 'mvn exec:java -Dexec.mainClass="org.example.Main"'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                echo "Ejecutando pruebas automatizadas..."
                sh 'mvn test'
            }
        }

        stage('Publicar resultados de pruebas') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo "Finalizando build..."
            cleanWs()
        }

        success {
            echo "¡Build completado exitosamente!"
        }

        failure {
            echo "Hubo un error durante la ejecución."
        }
    }
}
