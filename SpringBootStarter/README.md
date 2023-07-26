Deploying Spring Boot Application on AWS EC2 - Step-by-Step Guide

This guide will walk you through the process of deploying a Spring Boot application on AWS EC2. Before you begin, ensure you have your Spring Boot application's runnable JAR file ready for deployment.
Step 1: Create an AWS EC2 Instance

    Log in to your AWS Management Console.
    Navigate to the EC2 Dashboard.
    Click on "Launch Instance" to create a new EC2 instance.
    Choose an Amazon Machine Image (AMI) that matches your application's requirements. For example, you can select an image with a suitable operating system and architecture.
    Choose an instance type based on your application's resource requirements.
    Configure the instance details, including network settings, storage, etc.
    Create a new or use an existing security group that allows incoming traffic on the desired ports (e.g., HTTP on port 80, HTTPS on port 443).
    Review your configuration and click "Launch" to create the instance.

Step 2: Connect to your EC2 Instance

    Once the instance is launched, download the key pair (PEM file) that you selected during the instance launch process. This key will be used to authenticate your SSH connection.
    Open your terminal (or a tool like PuTTY on Windows) and use the following command to connect to your instance:

    ssh -i /path/to/your/key.pem ec2-user@your-instance-public-ip

    Replace /path/to/your/key.pem with the actual path to your downloaded PEM file and your-instance-public-ip with the public IP address of your EC2 instance.

Step 3: Install Java on the EC2 Instance

    After connecting to the EC2 instance, check if Java is already installed by running the following command:

    java -version

If Java is not installed or if the version is not suitable for your application, install Java using the package manager for your Linux distribution. For example, on Amazon Linux 2, use the following command:

    sudo yum install java-openjdk11

Step 4: Copy your Spring Boot JAR file to the EC2 Instance

    Use scp (secure copy) to transfer your Spring Boot JAR file from your local machine to the EC2 instance. Run the following command in your local terminal:

    scp -i /path/to/your/key.pem /path/to/your/spring-boot-app.jar ec2-user@your-instance-public-ip:/path/on/ec2/instance

    Replace the placeholders with the actual paths to your files.

Step 5: Run your Spring Boot Application on the EC2 Instance

    Once the JAR file is on the EC2 instance, connect to the instance via SSH as explained in Step 2.
    Navigate to the directory where you placed the JAR file.
    Use the java command to run your Spring Boot application:

    java -jar spring-boot-app.jar

Step 6: Configure Security Groups

    Ensure that the security group associated with your EC2 instance allows incoming traffic on the port your Spring Boot application is running (usually port 8080 or any other port you've configured).
    Go to the EC2 Dashboard, select your instance, and click on the "Security groups" tab to view and modify the associated security groups.

Troubleshooting Tips

    Port Configuration: Ensure that the security group allows traffic on the correct port (e.g., 8080) and that your Spring Boot application is running on the expected port.
    Java Version: Double-check that you have installed the correct version of Java required for your Spring Boot application to run.
    File Paths: Verify that you have used the correct file paths when copying the JAR file to the EC2 instance and when running the application.
    Firewall Settings: If your application is not accessible from the web, check if there are any additional firewalls or network access control lists (ACLs) blocking incoming traffic.

Conclusion

With these steps and tips, you should have successfully deployed your Spring Boot application on AWS EC2. For more advanced deployment scenarios, consider using AWS Elastic Beanstalk or AWS ECS (Elastic Container Service). Ensure that you monitor your application and set up automatic backups for your data. Happy deploying!!!
