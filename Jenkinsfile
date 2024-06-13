pipeline {
    agent any
    stages {
        stage ( stage 1 : compile code) {
            steps {
                bat "mvn compile"
                echo "Step mvn compile"
            }
        }
            stage ( stage 2 : Run Unit Test) {
            steps {
                bat "mvn test"
                echo "Step mvn test"
            }
            }
            stage ( stage 3 : Create build) {
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
