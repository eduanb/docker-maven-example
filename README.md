# Maven dockerfile example

Using local maven:`mvn <goal>`

Using maven in docker: `docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock -v "$(pwd)":/usr/src/example -w /usr/src/example maven:3.3-jdk-8 mvn <goal>`

Note1: Since this is creating containers and interacting with Docker, the `docker.sock` is required,
Note2: This will download a lot of maven dependencies every time. 
It is recommended to mount the repository.

To create a volume: `docker volume create --name maven-repo`

Then: `docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock -v maven-repo:/root/.m2 -v "$(pwd)":/usr/src/example -w /usr/src/example maven:3.3-jdk-8 mvn <goal>`
 
Otherwise, the default maven location is ~/.m2

`docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock -v ~/.m2:/root/.m2 -v "$(pwd)":/usr/src/example -w /usr/src/example maven:3.3-jdk-8 mvn <goal>`

The available goals are:

`package`: build the containers

For more info on the maven container: https://hub.docker.com/_/maven

For more info on the Docker plugin: https://maven.fabric8.io/
