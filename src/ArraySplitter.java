public class ArraySplitter {
    public static void main(String[] args) {
        String[] input = new String[]{"11111", "22222222", "33333333", "444", "11", "222", "3333", "4444444", "11111111",
                "222222", "33333333", "4", "1", "2222222222", "3", "44444444444444"};

        printRows(input, 4);
    }

    public static void printRows(String[] input, int columnsAmount) {
        //simple validation; exception can be thrown instead
        if (input == null || columnsAmount <= 0) {
            return;
        }

        int[] columnSizes = getColumnsSize(input, columnsAmount);

        for (int i = 0; i < input.length; ) {
            //splitting by rows
            if (i != 0 && i % columnsAmount == 0) {
                System.out.println();
            }

            //printing with required column length
            for (int size : columnSizes) {
                if (i == input.length) {
                    break;
                }
                System.out.printf("%-" + size + "s  ", input[i]);
                i++;
            }
        }
    }

    private static int[] getColumnsSize(String[] input, int columnsAmount) {
        int[] result = new int[columnsAmount];

        for (int i = 0; i < columnsAmount; i++) {
            int maxSize = 0;

            //finds the maximum length of a value in the column
            for (int j = i; j < input.length; j += columnsAmount) {
                int tempSize = input[j].length();

                if (tempSize > maxSize) {
                    maxSize = tempSize;
                }
            }

            result[i] = maxSize;
        }
        return result;
    }
}
