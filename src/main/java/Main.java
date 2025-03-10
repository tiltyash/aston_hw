public class Main {
    public static void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Array is not 4x4");
        }

	int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Data is not type of int: [" + i + "][" + j + "]");
                }
            }
        }
    }
    public static void main(String[] args) {
        String[][] array = new String[4][4];

        int startElement = 0;
        for (String[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = String.valueOf(startElement);
                startElement++;
            }
        }

        for (String[] row : array) {
            for (String element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }

        String[][] array1 = {
                {"0","2"}
        };

        String[][] array2 = {
                {"1", "2", "3", "4"},
                {"a", "b", "c", "d"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        try {
            checkArray(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            checkArray(array1);
            System.out.println("Incorrect size array");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            checkArray(array2);
            System.out.println("Incorrect data array");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            String[] array3 = new String[10];
            System.out.println(array3[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("caught ArrayIndexOutOfBoundsException " + e.getMessage());
        }
    }
}
