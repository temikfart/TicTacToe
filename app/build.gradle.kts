plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    testImplementation("junit:junit:4.13.2")
}

application {
    mainClass.set("tictactoe.TicTacToe")
}
