plugins {
    java

    application
}

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.9.1"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

application {
    // Define the main class for the application
    mainClass.set("it.unibo.inner.TestIterablePlain")
}