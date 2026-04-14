class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        // zipping all the arrays into log objects
        List<Log> logs = new ArrayList<>();
        for (int i=0; i < timestamp.length; i++)
        {
            Log log = new Log(username[i], website[i], timestamp[i]);
            logs.add(log);
        }

        // order by timestamp
        Collections.sort(logs, (a,b) -> a.timestamp - b.timestamp);
        
        // mapping users to sequences via logs
        HashMap<String,List<String>> userHist = new HashMap<>();
        for (Log log : logs)
        {
            userHist.computeIfAbsent(log.username, k -> new ArrayList<>()).add(log.website);
        }

        // get the unique 3-website sequences and count
        HashMap<List<String>, Integer> freq = new HashMap<>();
        for (String user : userHist.keySet())
        {
            List<String> websites = userHist.get(user);
            HashSet<List<String>> seen = new HashSet<>();
            for (int i = 0; i < websites.size()-2; i++)
            {
                for (int j = i + 1; j < websites.size()-1; j++)
                {
                    for (int k = j + 1; k < websites.size(); k++)
                    {
                        List<String> seq = Arrays.asList(
                            websites.get(i),
                            websites.get(j),
                            websites.get(k)
                        );
                        if (seen.add(seq))
                        {
                            freq.put(seq, freq.getOrDefault(seq,0) + 1);
                        }
                    }
                }
            }
        }

        // get highest freq
        List<String> res = null;
        int max = 0;

        for (List<String> seq : freq.keySet())
        {
            //  return the pattern with the largest score
            if (max < freq.get(seq))
            {
                max = freq.get(seq);
                res = seq;
            }
            // If there is more than one pattern with the same largest score, 
            // return the lexicographically smallest such pattern.
            else if (max == freq.get(seq))
            {
                if (res == null)
                {
                    res = seq;
                }
                else
                {
                    for (int i = 0; i < 3; i++)
                    {
                        if (seq.get(i).compareTo(res.get(i)) < 0)
                        {
                            res = seq;
                            break;
                        }
                        else if (seq.get(i).compareTo(res.get(i)) > 0)
                        {
                            break;
                        }
                    }
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

    public Log (String username, String website, int timestamp) {
        this.username = username;
        this.website = website;
        this.timestamp = timestamp;
    }
}