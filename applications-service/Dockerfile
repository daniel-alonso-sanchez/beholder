FROM openjdk:8-jre-alpine
ADD ./target/applications-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/applications-service.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8889/applications/health || exit 1

EXPOSE 8889