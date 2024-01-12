import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.springDependencyManagement)
	alias(libs.plugins.springBoot)
}

group = "io.joergi"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.springBootStarterWeb)
	implementation(libs.jacksonKotlinModule)
	implementation(libs.kotlinReflect)
	compileOnly(libs.lombok)
	annotationProcessor(libs.lombok)
	testImplementation(libs.springBootStarterTest)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
