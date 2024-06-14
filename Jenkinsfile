pipeline {
    agent any
    stages {
        stage (Compile Code) {
            steps {
                bat "mvn compile"
                echo "Step mvn compile"
            }
        }
            stage (Run Unit Test) {
            steps {
                bat "mvn test"
                echo "Step mvn test"
            }
            }
            stage (Create Build) {
            steps {
                bat "mvn package"
                echo "Step mvn package"
            }
        }
    }
    failure
    {
        echo "Email for Jenkin build failed"
    }
}
