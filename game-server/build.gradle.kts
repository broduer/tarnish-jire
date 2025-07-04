plugins {
    kotlin("jvm")
    application
    id("org.zeroturnaround.gradle.jrebel")
    id("com.gradleup.shadow")
}

application {
    mainClass.set("com.osroyale.Main")
    applicationDefaultJvmArgs += arrayOf(
        "-XX:-OmitStackTraceInFastThrow",
        "--enable-preview",
        "-XX:+UseZGC",
        "-Xmx8g",
        "-Xms4g",
        "-XX:MaxGCPauseMillis=100"
    )
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    val slf4jVersion = "2.0.17"
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    runtimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")

    implementation("io.netty:netty-all:4.2.2.Final")
    implementation("joda-time:joda-time:2.14.0")
    implementation("org.quartz-scheduler:quartz:2.5.0")
    implementation("com.jcabi:jcabi-jdbc:0.19.0")
    implementation("com.google.code.gson:gson:2.13.1")
    implementation("com.google.guava:guava:33.4.8-jre")
    implementation("org.jsoup:jsoup:1.20.1")
    implementation("org.apache.commons:commons-compress:1.27.1")
    implementation("io.hotmoka:toml4j:0.7.3")
    implementation("com.mysql:mysql-connector-j:9.3.0")
    implementation("org.postgresql:postgresql:42.7.7")
    implementation("com.zaxxer:HikariCP:6.3.0")
    implementation("org.apache.logging.log4j:log4j-core:2.25.0")
    implementation("org.apache.ant:ant:1.10.15")
    implementation("org.jctools:jctools-core:4.0.5")
    implementation("io.github.classgraph:classgraph:4.8.179")
    implementation("com.discord4j:discord4j-core:3.2.8")
    implementation("it.unimi.dsi:fastutil:8.5.15")
    implementation("net.dv8tion:JDA:5.6.1")
    implementation("com.hankcs:aho-corasick-double-array-trie:1.2.3")
    implementation("org.mindrot:jbcrypt:0.4")
    implementation("de.mkammerer:argon2-jvm:2.12")
    implementation("net.openhft:affinity:3.27ea0")
    implementation("net.openhft:chronicle-threads:2.27ea0")
}

sourceSets.named("main") {
    java {
        srcDir("plugins")
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.apply {
        encoding = "UTF-8"
        compilerArgs.add("--enable-preview")
    }
}