class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;  // To track the largest element seen so far
        int chunks = 0;    // To count the number of chunks

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);  // Update the maximum so far
            if (maxSoFar == i) {  // If maxSoFar equals the index, we can finalize a chunk
                chunks++;
            }
        }

        return chunks;  // Return the total number of chunks
    }
}
