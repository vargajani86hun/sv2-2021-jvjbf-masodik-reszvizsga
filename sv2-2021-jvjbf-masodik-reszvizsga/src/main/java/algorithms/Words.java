package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> onlyWords = new ArrayList<>();

    public void addWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        else if (!isAllLowerCase(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        else {
            onlyWords.add(word);
        }
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < onlyWords.size() - 1; i++) {
            for (int j = i + 1; j < onlyWords.size(); j++) {
                if (onlyWords.get(i).equals(onlyWords.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getWords() {
        return new ArrayList<>(onlyWords);
    }

    private boolean isAllLowerCase(String word) {
        for (Character c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }
}
