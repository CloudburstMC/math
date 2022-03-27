pipeline {
    agent any
    tools {
        maven 'Maven 3'
        jdk 'Java 8'
    }
    options {
        buildDiscarder(logRotator(artifactNumToKeepStr: '5'))
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    junit '**/target/surefire-reports/**/*.xml'
                    archiveArtifacts artifacts: '**/target/*.jar', excludes: '**/target/original-*.jar', fingerprint: true
                }
            }
        }

        stage ('Deploy') {
            when {
                anyOf {
                    branch 'master'
                    branch 'feature/2.0'
                }
            }
            steps {
                sh 'mvn javadoc:javadoc javadoc:jar source:jar deploy -DskipTests'
                step([$class: 'JavadocArchiver',
                        javadocDir: 'target/site/apidocs',
                        keepAll: false])
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}