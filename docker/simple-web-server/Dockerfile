# Java Web Server based of Ubuntu
FROM ubuntu
RUN echo 'Image based out of Ubuntu'



# Install Java
RUN echo 'Going to install Java now'
RUN apt update
RUN apt install default-jdk -y
RUN echo 'Java has been installed successfully'

# Setup Server
RUN echo 'Setting up server'
RUN mkdir /webserver
RUN mkdir /webserver/tmp
COPY WebServer.jar /webserver
RUN echo 'Web server has been set up'

# Set Environment Variable
ENV app_port 9999

# Run Server
RUN echo 'Going to run the web server'
ENTRYPOINT java -jar /webserver/WebServer.jar