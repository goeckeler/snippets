plugins {
    `java-library`
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.10.2"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  useJUnitPlatform()
  testLogging {
    events("passed", "skipped", "failed")
  }
  jvmArgs("--enable-native-access=ALL-UNNAMED")
}

tasks.withType<JavaExec> {
  jvmArgs("--enable-native-access=ALL-UNNAMED")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "game.GameOfLife"
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

