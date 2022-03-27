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
            when { not { anyOf {
                branch 'master'
                branch 'develop'
                branch 'feature/2.0'
            }}}

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
                    branch 'develop'
                    branch 'feature/2.0'
                }
            }

            stages {
                stage('Setup') {
                    steps {
                        rtMavenDeployer(
                                id: "maven-deployer",
                                serverId: "opencollab-artifactory",
                                releaseRepo: "maven-releases",
                                snapshotRepo: "maven-snapshots"
                        )
                        rtMavenResolver(
                                id: "maven-resolver",
                                serverId: "opencollab-artifactory",
                                releaseRepo: "maven-deploy-release",
                                snapshotRepo: "maven-deploy-snapshot"
                        )
                    }
                }

                stage('Release') {
                    when {
                        branch 'master'
                    }

                    steps {
                        rtMavenRun(
                                pom: 'pom.xml',
                                goals: 'javadoc:jar source:jar install -am -DskipTests',
                                deployerId: "maven-deployer",
                                resolverId: "maven-resolver"
                        )
                    }
                }

                stage('Snapshot') {
                    when {
                        anyOf {
                            branch 'develop'
                            branch 'feature/2.0'
                        }
                    }
                    steps {
                        rtMavenRun(
                                pom: 'pom.xml',
                                goals: 'javadoc:jar source:jar install -am -DskipTests',
                                deployerId: "maven-deployer",
                                resolverId: "maven-resolver"
                        )
                    }
                }

                stage('Publish') {
                    steps {
                        rtPublishBuildInfo(
                                serverId: "opencollab-artifactory"
                        )
                    }
                }
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}