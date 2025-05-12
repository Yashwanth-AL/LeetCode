class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0: 
            return False
        
        freq = Counter(hand)
        hand.sort()

        for card in hand:
            if freq[card] == 0:
                continue
            
            for i in range(groupSize):
                nextCard = card + i
                if freq[nextCard] == 0:
                    return False
                freq[nextCard] = freq[nextCard] - 1
        
        return True
