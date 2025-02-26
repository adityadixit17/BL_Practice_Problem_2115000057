package D_26_02_25;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.csv.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
class IPLMatch {
    @JsonProperty("match_id")
    private int matchId;
    @JsonProperty("team1")
    private String team1;
    @JsonProperty("team2")
    private String team2;
    @JsonProperty("score")
    private Map<String, Integer> score;
    @JsonProperty("winner")
    private String winner;
    @JsonProperty("player_of_match")
    private String playerOfMatch;
    public int getMatchId() { return matchId; }
    public String getTeam1() { return team1; }
    public String getTeam2() { return team2; }
    public Map<String, Integer> getScore() { return score; }
    public String getWinner() { return winner; }
    public String getPlayerOfMatch() { return playerOfMatch; }
    public void setTeam1(String team1) { this.team1 = team1; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public void setWinner(String winner) { this.winner = winner; }
    public void setPlayerOfMatch(String playerOfMatch) { this.playerOfMatch = playerOfMatch; }
}
public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInput = "ipl_data.json";
        String jsonOutput = "ipl_data_censored.json";
        String csvInput = "ipl_data.csv";
        String csvOutput = "ipl_data_censored.csv";
        System.out.println("Processing JSON...");
        processJsonFile(jsonInput, jsonOutput);
        System.out.println("Processing CSV...");
        processCsvFile(csvInput, csvOutput);
        System.out.println("Processing Complete!");
    }
    public static void processJsonFile(String inputFile, String outputFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            IPLMatch[] matches = objectMapper.readValue(new File(inputFile), IPLMatch[].class);
            List<IPLMatch> censoredMatches = Arrays.stream(matches).map(match -> {
                match.setTeam1(maskTeamName(match.getTeam1()));
                match.setTeam2(maskTeamName(match.getTeam2()));
                match.setWinner(maskTeamName(match.getWinner()));
                match.setPlayerOfMatch("REDACTED");
                return match;
            }).collect(Collectors.toList());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), censoredMatches);
            System.out.println("Censored JSON written to: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void processCsvFile(String inputFile, String outputFile) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(inputFile));
                Writer writer = Files.newBufferedWriter(Paths.get(outputFile))
        ) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(csvParser.getHeaderMap().keySet().toArray(new String[0])));
            for (CSVRecord record : csvParser) {
                List<String> row = new ArrayList<>();
                row.add(record.get("match_id"));
                row.add(maskTeamName(record.get("team1")));
                row.add(maskTeamName(record.get("team2")));
                row.add(record.get("score_team1"));
                row.add(record.get("score_team2"));
                row.add(maskTeamName(record.get("winner")));
                row.add("REDACTED");
                csvPrinter.printRecord(row);
            }
            csvPrinter.flush();
            System.out.println("Censored CSV written to: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String maskTeamName(String teamName) {
        if (teamName == null) return null;
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
            return String.join(" ", words);
        }
        return teamName;
    }
}
