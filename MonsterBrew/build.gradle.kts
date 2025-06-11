plugins {
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "cz.beavergame"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

	// Spring Web (REST API)
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Spring Data JPA
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// PostgreSQL Driver
	runtimeOnly ("org.postgresql:postgresql")

	// Lombok
	compileOnly ("org.projectlombok:lombok")
	annotationProcessor  ("org.projectlombok:lombok")

	// DevTools
	developmentOnly ("org.springframework.boot:spring-boot-devtools")

	// Validation
	implementation ("jakarta.validation:jakarta.validation-api:3.0.2")

	// Tests
	testImplementation ("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
