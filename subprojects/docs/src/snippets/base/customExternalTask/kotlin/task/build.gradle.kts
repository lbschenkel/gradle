// tag::external-task-build[]
plugins {
    groovy
// end::external-task-build[]
    `maven-publish`
// tag::external-task-build[]
}

dependencies {
    implementation(gradleApi())
}
// end::external-task-build[]

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13")
}

group = "org.gradle"
version = "1.0-SNAPSHOT"

publishing {
    repositories {
        maven {
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

// Needed when using ProjectBuilder
tasks.withType<Test>().configureEach {
    jvmArgumentProviders.add(object : CommandLineArgumentProvider {
        override fun asArguments() : Iterable<String> {
            return if (javaVersion.isCompatibleWith(JavaVersion.VERSION_16)) {
                listOf("--add-opens=java.base/java.lang=ALL-UNNAMED")
            } else {
                emptyList()
            }
        }
    })
}
