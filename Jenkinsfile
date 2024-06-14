pipeline {
    agent any
    stages {
        stage (Compile Code) {
            steps {
                bat "mvn compile"
                echo "Step mvn compile"
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
