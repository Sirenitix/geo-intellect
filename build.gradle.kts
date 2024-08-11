plugins {
    `java-library`
    `maven-publish`
    id("org.springframework.boot") version "3.3.2"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.org.postgresql.postgresql)
    api(libs.javax.annotation.javax.annotation.api)
    api(libs.org.projectlombok.lombok)
    api(libs.org.apache.commons.commons.lang3)
    api("org.hibernate:hibernate-core:5.4.23.Final")
    api(libs.org.springframework.boot.spring.boot.starter.web)
    api(libs.org.springframework.spring.jdbc)
    api(libs.org.springframework.boot.spring.boot.starter.data.jpa)
    api(libs.org.flywaydb.flyway.core)
    api(libs.org.springdoc.springdoc.openapi.ui)
    api(libs.com.google.guava.guava)
    api(libs.org.springframework.boot.spring.boot.starter.security)
    api(libs.org.springframework.boot.spring.boot.starter.validation)
    api(libs.org.springframework.security.spring.security.jwt)
    api(libs.com.nimbusds.nimbus.jose.jwt)
    api(libs.org.springframework.cloud.spring.cloud.starter.openfeign)
    compileOnly(libs.org.projectlombok.lombok)
    annotationProcessor(libs.org.projectlombok.lombok)
    testImplementation(libs.org.apache.httpcomponents.httpclient)
}

group = "kz.api.geo"
version = "1.0.0"
description = "geo-intellect"
java.sourceCompatibility = JavaVersion.VERSION_17


publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
