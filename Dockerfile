# Estágio 1: Build
FROM ubuntu:latest AS build

# Atualiza pacotes e instala o JDK
RUN apt-get update && apt-get install openjdk-21-jdk -y

# Copia o código-fonte para o container
COPY . .

# Dá permissão de execução ao Maven wrapper
RUN chmod +x mvnw

# Executa o Maven para empacotar a aplicação
RUN ./mvnw package

# Estágio 2: Imagem final
FROM openjdk:21-jdk-slim

# Exposição da porta
EXPOSE 8080

# Copia o JAR gerado no estágio de build
COPY --from=build /target/dslist-v1.jar app.jar

# Define o ponto de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
