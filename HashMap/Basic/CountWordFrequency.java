Map<String,Integer> freq = new HashMap<>();
String [] words = sentence.split(" ");
for(String word:words){
    freq.put(word,freq.getOrDefault(word,0)+1);
}
return freq;