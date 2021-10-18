package homework12;

import java.util.Arrays;

import java.util.Arrays;

public class StringCollectionImpl implements StringCollection {
    private String[] array = new String[0];

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public boolean add(String str) {
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = str;
        this.array = newArray;
        return true;
    }

    @Override
    public boolean add(int index, String str) {
        if (index > array.length + 1 || index < 0) {
            return false;
        } else {
            String[] newArray = new String[array.length + 1];
            int k = 0;
            for (int i = 0; i < array.length; i++) {
                if (i != index) {
                    newArray[k] = array[i];
                    k++;
                } else {
                    newArray[k] = str;
                    newArray[k + 1] = array[i];
                    k += 2;
                }
            }
            array = newArray;
            return true;
        }
    }

    @Override
    public boolean delete(String str) {
        if (contains(str)){
            String [] newArray = new String[array.length - 1];
            for (int i = 0; i < newArray.length; i++) {
                int k = i;
                if(array[i].equals(str)){
                    k++;
                }
                newArray[i] = array[k];
            }
            array = newArray;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String str) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].contains(str)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(StringCollection collection) {
        if (collection.size() == array.length) {
            for (int i = 0; i < collection.size(); i++) {
                if (!collection.get(i).equals(array[i])) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean clear() {
        array = new String[0];
        return true;
    }

    @Override
    public int size() {
        return this.array.length;
    }
}
