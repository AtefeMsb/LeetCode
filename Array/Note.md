### convert integer list to int[]
int[] intArray = listOfIntegers.stream().mapToInt(i->i).toArray();

### convert String list to String[]
String[] array = listOfString.toArray(new String[listOfString.size()]);
