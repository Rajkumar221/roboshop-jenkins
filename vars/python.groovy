def call() {
    pipeline {
    agent { node { label 'workstation' } }

    stages{
      
      stage { 'Unit tests' }{
        steps {
            echo 'Unit tests'
            //sh 'python -n unittest'
        }
      }

      stage { 'code Analysis' }{
        steps {
            sh 'sonar-scanner -Dsonar.host.url-(sonarqube ip:9000) -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectkey=payment'
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