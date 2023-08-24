def call() {
    pipeline {
    agent { node { label 'workstation' } }

    stages{
      stage { 'Build' }{
        steps {
            sh 'mvn package'
        }
      }

      stage { 'Unit tests' }{
        steps {
            echo 'Unit tests'
            //sh 'mvn test'
        }
      }

      stage { 'code Analysis' }{
        steps {
          echo 'sonar'
            // sh 'sonar-scanner -Dsonar.host.url-(sonarqube ip:9000) -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectkey=shipping -Dsonar.java.bineries=target'
        }
      }

      stage { 'security Scans' }{
        steps {
            echo 'security Scans'
        }
      }

      stage { 'Publish a Artifact' }{
        steps {
            echo 'Publish a Artifact'
        }
      }

    }
}

}