# Start from the base image
FROM mcr.microsoft.com/devcontainers/java:1-21-bullseye

# Install Docker CLI
RUN apt-get update && apt-get install -y docker.io