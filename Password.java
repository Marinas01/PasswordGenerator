import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Password {

    public static String generatePassword(int size, boolean numbers, boolean characters) {
        String returnedPassword = "";
        List<String> numberElements = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        List<String> charactersElements = Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*", ")", "(", "-", "_", "+", "=",
                "}", "{", "]", "[", "|", ";", ":", "?", "/", ".", ",", ">", "<");
        List<String> letterElements = Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f",
                "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m");
        ArrayList<String> numberList = new ArrayList<>(numberElements);
        ArrayList<String> characterList = new ArrayList<>(charactersElements);
        ArrayList<String> lettersList = new ArrayList<>(letterElements);
        if (numbers || characters) {
            ArrayList<String> returned = new ArrayList<>();
            int length = size / 2;
            for (int i = 0; i < length; i++) {
                Random random = new Random();
                int index = random.nextInt(letterElements.size());
                returned.add(letterElements.get(index));
            }
            length = size - length;
            if (numbers & characters) {
                length = length / 2;
                for (int i = 0; i < length; i++) {
                    Random random = new Random();
                    int index = random.nextInt(numberElements.size());
                    returned.add(numberElements.get(index));
                }
                for (int i = 0; i < length; i++) {
                    Random random = new Random();
                    int index = random.nextInt(charactersElements.size());
                    returned.add(charactersElements.get(index));
                }
            } else {
                if(numbers) {
                    for (int i = 0; i < length; i++) {
                        Random random = new Random();
                        int index = random.nextInt(numberElements.size());
                        returned.add(numberElements.get(index));
                    }
                    }
                else{
                        for (int i = 0; i < length; i++) {
                            Random random = new Random();
                            int index = random.nextInt(charactersElements.size());
                            returned.add(charactersElements.get(index));
                        }
                    }
                }

            while (!returned.isEmpty()){
                Random random=new Random();
                int index=random.nextInt(returned.size());
                returnedPassword=returnedPassword+returned.get(index);
                returned.remove(index);
            }

        } else {
            for (int i = 0; i < size; i++) {
                Random random = new Random();
                int index = random.nextInt(letterElements.size());
                returnedPassword = returnedPassword + letterElements.get(index);
            }
        }


        return returnedPassword;
    }
}
