class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n=req_skills.length;
        int m=people.size();

        HashMap<String,Integer> skillSet=new HashMap<String,Integer>();
        for(int i=0;i<n;i++){
            skillSet.put(req_skills[i],1<<i);
        }
        // stores people required fro a skill or set of skill
        HashMap<Integer,List<Integer>> dp=new HashMap<>(); 
        dp.put(0,new ArrayList<>()); // for 0 skill we have no team / set of people
        for(int i=0;i<m;i++){
            List<String> personSkills=people.get(i);
            // stores mask of all skills of a particular person
            int allOverSkills=0;

            for(String skill:personSkills){
                if(skillSet.containsKey(skill)){
                    allOverSkills |= skillSet.get(skill);
                }
            }

            // iterate over all possible skills combinations
            List<Integer> keys=new ArrayList<>(dp.keySet());

            for(int key:keys){
                // formulate new skills with the existing skills ans start building team
                // every key is a skill here
                int newSkills=key|allOverSkills;

                List<Integer> currTeam=dp.get(key);
                if(!dp.containsKey(newSkills)){
                    dp.put(newSkills,new ArrayList(currTeam));
                    dp.get(newSkills).add(i);
                }else{
                  //  [[5][11][15][52]]
                    // oldteam 11|52 -->63-- new skill is already there  
                    // newteam 15|52-->63
                    int oldTeamSize=dp.get(newSkills).size();
                    int newTeamSize=currTeam.size()+1;
                    if(newTeamSize<oldTeamSize){
                        dp.put(newSkills,new ArrayList(currTeam));
                         dp.get(newSkills).add(i);
                    }
                }
                // if(!dp.containsKey(newSkills) || (dp.get(key).size()+1<dp.get(newSkills).size())){
                //     dp.put(newSkills,new ArrayList<>(dp.get(key)));  
                //     dp.get(newSkills).add(i);
                // }
            }
        }
        List<Integer> temp=dp.get((1 << n) - 1);
        int[] ans=new int[temp.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=temp.get(i);
        }
        return ans;
    }
}