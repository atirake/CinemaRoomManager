class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        if (array != null && index >= 0 && index < array.length) {
            System.out.println((int)Math.pow(array[index], 2));
        } else {
            System.out.println("Exception!");
        }
    }
}