import java.util.Date

plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
}

application {
    mainClass.set("tictactoe.TicTacToe")
}

tasks.jar {
    archiveBaseName.set("TicTacToe")
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
        attributes["Created-By"] = "Artyom Fartygin"
        attributes["Implementation-Title"] = "TicTacToe"
        attributes["Implementation-Version"] = "1.0"
        attributes["Built-Date"] = Date()
    }
}
