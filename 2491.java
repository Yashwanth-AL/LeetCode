class Solution {
    public long dividePlayers(int[] skill) {
        int length = skill.length;
        if(length <= 1 || length % 2 != 0){
            return -1;
        } 
        Arrays.sort(skill);
        int sum = skill[0] + skill[length-1];
        long product = 0;
        for(int i = 0; i < length/2; i++){
            int newSum = skill[i] + skill[length-i-1];
            product += skill[i] * skill[length-i-1];
            if(newSum != sum){
                return -1;
            }
        }
        return product;
    }
}
