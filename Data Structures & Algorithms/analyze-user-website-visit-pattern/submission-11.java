class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < timestamp.length; i++)
        {
            logs.add(new Log(username[i], website[i], timestamp[i]));
        }

        Collections.sort(logs, (a,b) -> a.timestamp - b.timestamp);

        HashMap<String,List<String>> userMap = new HashMap<>();
        for (Log log : logs)
        {
            userMap.computeIfAbsent(log.username, k -> new ArrayList<>()).add(log.website);
        }

        HashMap<List<String>, Integer> sequences = new HashMap<>();
        int max = 0;
        List<String> res = new ArrayList<>();
        
        for (String user : userMap.keySet())
        {
            Set<List<String>> userPatterns = new HashSet<>();
            List<String> websites = userMap.get(user);

            for (int i = 0; i < websites.size(); i++)
            {
                for (int j = i + 1; j < websites.size(); j++)
                {
                    for (int k = j + 1; k < websites.size(); k++)
                    {
                        List<String> seq = Arrays.asList(websites.get(i), websites.get(j), websites.get(k));
                        userPatterns.add(seq);
                    }
                }
            }
            for (List<String> seq : userPatterns) {
                sequences.put(seq, sequences.getOrDefault(seq, 0) + 1);
                int score = sequences.get(seq);
                if (score > max || (score == max && String.join(",", seq).compareTo(String.join(",", res)) < 0)) {
                    max = score;
                    res = seq;
                }
            }
        }

        return res;
    }
}

class Log {
    String username;
    String website;
    int timestamp;

    Log (String username, String website, int timestamp) {
        this.username = username;
        this.website = website;
        this.timestamp = timestamp;
    }
}