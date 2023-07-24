def call() {
    pipeline {
    agent { node { label 'workstation' } }

    stages{
      stage { 'Build' }{
        steps {
            sh 'npm install'
        }
      }

      stage { 'Unit tests' }{
        steps {
            echo 'Unit tests'
            // sh 'npm test'
        }
      }

      stage { 'code Analysis' }{
        steps {
          echo 'sonar'
            // sh 'sonar-scanner -Dsonar.host.url-(sonarqube ip:9000) -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectkey=cart'
        }
      }

      stage { 'security Scans' }{
        steps {
            echo 'security Scans'
        }
      }

      stage { 'Publish a Artifact' }{
        when {
          expression {
            env.TAG_NAME==~ '.*'
          }

        }
        steps {
            echo 'Publish a Artifact'
        }
      }

    }
}

}