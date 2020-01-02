    // recursive 1
    private void helper(int index, char[] str) {

        // base case
        if (str == null || index >= str.length) {
            return;
        }

        // recurrence relation
        helper(index + 1, str);

        System.out.print(str[index] + " ");
    }

    ///////////////////////////////////////////////////////////////////////
    // recursive 2

    public void printReverse2(char[] str) {
        helper2(str.length - 1, str);
    }

    private void helper2(int high, char[] str) {

        // base
        if (str == null || high < 0) {
            return;
        }

        System.out.print(str[high] + " ");
        helper2(high - 1, str);

    }
