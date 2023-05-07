package tictactoe.models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GameHistoryModel {
    private final File gameHistory;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy, dd LLLL HH:mm:ss")
            .withZone(ZoneId.systemDefault());

    public GameHistoryModel() throws IOException {
        this.gameHistory = new File("game_history.db");
        if (!gameHistory.exists())
            if (!gameHistory.createNewFile())
                System.out.println("Can't create new game history file");
    }

    public void saveGameResult(String result) {
        try (FileWriter fw = new FileWriter(gameHistory, true)) {
            String timestamp = formatter.format(Instant.now());
            fw.append(timestamp + ": " + result + "\n");
        } catch (IOException e) {
            System.out.println("Can't write into game history file: " + e.getMessage());
        }
    }

    public String getGameHistory() {
        String history = "No games played yet.";
        try {
            List<String> historyLines = Files.readAllLines(gameHistory.toPath());
            if (!historyLines.isEmpty())
                history = String.join("\n", historyLines);
        } catch (IOException e) {
            System.out.println("Can't read from game history file: " + e.getMessage());
        }
        return history;
    }
}
