# Math [![License](http://img.shields.io/badge/license-MIT-lightgrey.svg?style=flat)][License] [![Build Status](https://ci.opencollab.dev/job/NukkitX/job/math/job/master/badge/icon)](https://ci.opencollab.dev/job/NukkitX/job/math/job/master/)

Immutable math library for Java that offers easy conversion between math types, fast trigonometric functions, vectors, matrices, complex numbers, quaternions, and operation chaining, with a focus on games and computer graphics.

## Getting Started
* [Official documentation](#documentation)
* [Issues tracker](https://github.com/CloudburstMC/math/issues)

## Source Code
The latest and greatest source can be found here on [GitHub](https://github.com/CloudburstMC/math). If you are using Git, use this command to clone the project:

    git clone git://github.com/CloudburstMC/math.git

Or download the latest [development archive](https://github.com/CloudburstMC/math/archive/develop.zip) or the latest [stable archive](https://github.com/CloudburstMC/math/archive/master.zip).

## Test Dependencies
The following dependencies are only needed if you compiling the tests included with this project. Gotta test 'em all!
* [junit:junit](https://oss.sonatype.org/#nexus-search;gav~junit~junit~~~)

## Building from Source
This project can be built with the _latest_ [Java Development Kit](http://oracle.com/technetwork/java/javase/downloads) and [Maven](https://maven.apache.org/). Maven is used to simplify dependency management, but using it is optional.

For Maven, the command `mvn clean package` will build the project and will put the compiled JAR in `target`, and `mvn clean install` will copy it to your local Maven repository.

## Contributing
Are you a talented programmer looking to contribute some code? We'd love the help!

* Open a pull request with your changes, following our [guidelines and coding standards](CONTRIBUTING.md).
* Please follow the above guidelines for your pull request(s) accepted.
* For help setting up the project, keep reading!

## Usage
If you're using [Maven](https://maven.apache.org/download.html) to manage project dependencies, simply include the following in your `pom.xml` file:

    <repository>
        <id>opencollab-repo</id>
        <url>https://repo.opencollab.dev/maven-releases</url>
    </repository>

    <dependency>
        <groupId>org.cloudburstmc</groupId>
        <artifactId>math</artifactId>
        <version>1.1.0</version>
    </dependency>

If you're using [Gradle](https://www.gradle.org/) to manage project dependencies, simply include the following in your `build.gradle` file:

    repositories {
        maven {
          url 'https://repo.opencollab.dev/maven-releases'
        }
    }
    dependencies {
        compile 'org.cloudburstmc:math:1.1.0'
    }

If you plan on using snapshots and do not already have the snapshot repo in your repository list, you will need to add this as well:

    https://oss.sonatype.org/content/groups/public/

If you'd prefer to manually import the latest .jar file, you can get it [here](https://ci.opencollab.dev/job/NukkitX/job/math/job/master).

## Documentation
Want to get friendly with the project and put it to good use? Check out the latest [Javadocs](https://ci.opencollab.dev/job/NukkitX/job/math/job/master/javadoc).

To generate Javadocs with Maven, use the `mvn javadoc:javadoc` command. To view the Javadocs simply go to `target/site/apidocs/` and open `index.html` in a web browser.

## Version Control
We've adopted the [git flow branching model](http://nvie.com/posts/a-successful-git-branching-model/) in our projects. The creators of git flow released a [short intro video](http://vimeo.com/16018419) to explain the model.

The `master` branch is production-ready and contains the latest tagged releases. Before a release is made, it is stagged in `release/x` branches before being pushed and tagged in the `master` branch. Small patches from `hotfix/x` branches are also pushed to `master`, and will always have a release version. The `develop` branch is pre-production, and is where we push `feature/x` branches for testing.

## Legal Stuff
Flow Math is licensed under the [MIT License][License]. Basically, you can do whatever you want as long as you include the original copyright. Please see the `LICENSE.txt` file for details.

## Credits
* [Spout](https://spout.org/) and contributors - *where we all began, and for much of the re-licensed code.*
* All the people behind [Java](http://www.oracle.com/technetwork/java/index.html), [Maven](https://maven.apache.org/), and [Gradle](https://www.gradle.org/).

[License]: https://tldrlegal.com/l/mit
