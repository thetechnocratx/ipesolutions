/* 
Sports tournament organizer: Write a program that simulates a sports tournament using a PriorityQueue. 
The program should allow the user to input team names and their win-loss records. 
The program should then prioritize teams based on their win-loss records and add them to the PriorityQueue. 
When its time for the next match, the program should remove the two highest priority teams from the PriorityQueue
and display their names.*/

import java.util.*;

class Team {
    String name;
    int wins;
    int losses;

    public Team(String name, int wins, int losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    public int getWinLossRatio() {
        return wins - losses;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SportsTournamentSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Team> teamsQueue = new PriorityQueue<>(Comparator.comparing(Team::getWinLossRatio).reversed());

        // Input team names and win-loss records
        System.out.println("Enter the number of teams: ");
        int numTeams = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer.

        for (int i = 0; i < numTeams; i++) {
            System.out.println("Enter team name: ");
            String name = scanner.nextLine();
            System.out.println("Enter number of wins: ");
            int wins = scanner.nextInt();
            System.out.println("Enter number of losses: ");
            int losses = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer.

            Team team = new Team(name, wins, losses);
            teamsQueue.add(team);
        }

        // Display the next match
        System.out.println("Next match:");
        if (!teamsQueue.isEmpty()) {
            Team team1 = teamsQueue.poll();
            Team team2 = teamsQueue.poll();
            System.out.println(team1 + " vs. " + team2);
        } else {
            System.out.println("Not enough teams to start the match.");
        }
    }
}
