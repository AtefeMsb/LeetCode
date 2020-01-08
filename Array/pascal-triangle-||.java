       public List<Integer> getRow(int rowIndex) {
           
        List<Integer> res = new ArrayList<>();
           
        for(int i = 0; i <= rowIndex; i++) {
            // System.out.println("i: " + i);
            res.add(1);
            // System.out.println("res: " + res);
            for(int j = i - 1; j > 0; j--) {
                // System.out.println("j: " + j);
                res.set(j, res.get(j-1) + res.get(j));
            }
            // System.out.println("res after j: " + res);
            // System.out.println("*********************");
        }
        return res;
    }
