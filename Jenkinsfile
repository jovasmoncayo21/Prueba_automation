pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

    tools {
        maven 'Maven 3.9.9' // Asegúrate de que este nombre coincida con el que configuraste en Jenkins > Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                echo "Descargando codigo..."
                git url: 'https://github.com/jovasmoncayo21/Prueba_automation.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                echo "Compilando el proyecto..."
                bat 'mvn clean compile'
            }
        }

        stage('Ejecucion clase Main') {
            steps {
                echo "Ejecutando clase principal (Main)..."
                bat 'mvn exec:java -Dexec.mainClass="org.example.Main"'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                echo "Ejecutando pruebas automatizadas..."
                bat 'mvn test'
            }
        }

        stage('Publicar resultados de pruebas') {
            steps {
                junit 'target/custom-reports/*.xml'
            }
        }
        stage('Guardar reportes como artefactos') {
            steps {
                archiveArtifacts artifacts: 'target/custom-reports/*', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "¡Build completado exitosamente!"
        }

        failure {
            echo "Hubo un error durante la ejecución."
        }
    }
}
