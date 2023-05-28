package test;

public class competitionRank {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(calcRankAfterCompetition(players, callings));
    }

    public static String[] calcRankAfterCompetition(String[] players, String[] callings) {
        for (int x = 0; x < callings.length; x++) {
            for (int i = 0; i < players.length; i++) {
                if (i != 0 && players[i].equals(callings[x])) {
                    int index = x;
                    int same = 0;
                    while (true) {
                        if(same >= 2) {
                            x++;
                        }
                        if (index >= callings.length) {
                            break;
                        }
                        if (!callings[x].equals(callings[index]))  {
                            break;
                        }
                        changeRank(players, i);
                        i--;
                        index++;
                        same++;
                    }

                    break;
                }
            }
        }

        return players;
    }

    public static void changeRank(String[] players, int i) {
        String looser = players[i-1];
        players[i-1] = players[i];
        players[i] = looser;
    }
}
