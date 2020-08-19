package AuguestChallenge2020;


class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        
        int[] result = new int[num_people];
        
        // counter to use for looping over the result array more than once
        int i = 0;
        
        // index of array elements
        int index = 0;
        
        // count of current candy batch that must be ditributed
        int candyCount = 1;
        
        // while current amount of candies for distribution is LESS than amount of candies left
        while (candyCount < candies) {
            
            // get the current index of the array
            index = i % num_people;
            
            // increase number of candies of the index with the current batch of candies for distribution
            result[index] += candyCount;
            
            // adjust the number of candies left
            candies = candies - candyCount;
            
            // move to the next element
            i++;
            // increase current candy bt ONE
            candyCount++; 
            
        }
        
        // if there are some candies left but it is not enough to
        // be one more than the last batch distributed
        // the last person/index gets all the remaining candies
        if (candies > 0) {
           index =  i % num_people;
            result[index] += candies;
        }
        
        return result; 
    }
}