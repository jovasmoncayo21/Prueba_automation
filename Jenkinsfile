pipeline {
  agent any

  tools {
    maven 'Maven Apache'
  }
  stages {
    stage('Checkout') {
      steps {
        //Clonar repo desde Github
            git url: 'https://github.com/jovasmoncayo21/Prueba_automation.git', branch: 'master'
      }
    }

    stage('Build') {
      steps {
        //Compilar el proyecto usando Maven
        script {
          echo "Testing the plus-minus sign: ±" // Esto puede causar el error
                // Solución:
                echo "Testing the plus-minus sign: \\u00b1"  // Escapar el carácter
                echo "Testing the plus-minus sign: &#x00b1;" // Otra forma de escapar
      }
      
      //Compilar el proyecto
      bat 'mvn clean compile'
    }
  }
    stage('Test') {
      steps {
        echo 'Testing...'
        script {
          echo "Testing the plus-minus sign: ±" // Esto puede causar el error
                // Solución:
                echo "Testing the plus-minus sign: \\u00b1"  // Escapar el carácter
                echo "Testing the plus-minus sign: &#x00b1;" // Otra forma de escapar
        }
        // Run tests using Maven
        bat 'mvn test'
            }
        }
    stage ('Package'){
      steps {
        echo 'Packaging...'
        bat 'mvn package'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying...'
        bat 'java -cp target/Proyecto_prueba2-1.0-SNAPSHOT.jar org.example.Main'
}

post {
  success {
    echo 'Build completed successfully'
  }
  failure {
    echo 'Build failed'
  }
}
}
}
}
