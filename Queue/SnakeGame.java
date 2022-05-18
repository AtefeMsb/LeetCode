/*
have a queue for food, so it gets consume one at a time
snake representation:
    1- queue<String>: to keep the body of snake in order
    2- set<String>: to have instant access to all cell in the snake body
    
    add to head of queue (snake head): addFirst()
    remove from end of queue (snake tail): removeLast()
    peek the tail of snake: peekLast()

*/

import java.util.*;

class SnakeGame {

    int width;
    int height;
    LinkedList<String> foodQueue;
    int foodAmount;

    //snake
    Set<String> snakeSet;
    LinkedList<String> snakeQueue;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;

        // food data structure
        foodQueue = new LinkedList<>();
        for (int[] item : food) {
            foodQueue.add(item[0] + "a" + item[1]);
        }

        foodAmount = 0;

        // snake data structure
        snakeSet = new HashSet<>();
        snakeQueue = new LinkedList<>();

        // snake starts from Cell(0, 0)
        String initial = 0 + "a" + 0;
        snakeSet.add(initial);
        snakeQueue.addFirst(initial);

    }

    public int move(String direction) {

        // find next position
        String cur = snakeQueue.peekFirst();
        String[] curArr = cur.split("a");
        int row = Integer.valueOf(curArr[0]);
        int col = Integer.valueOf(curArr[1]);

        switch(direction) {
            case "U":
                row--;
                break;
            case "D":
                row++;
                break;
            case "L":
                col--;
                break;
            case "R":
                col++;
                break;
        }

        String nextPosition = row + "a" + col;

        // would snake die
        if (snakeDie(nextPosition)) {
            return -1;
        }

        // if food array is not empty and next position contains food
        if (!foodQueue.isEmpty() && nextPosition.equals(foodQueue.peek())) {
            // add the next position to the snake body and set
            snakeQueue.addFirst(nextPosition);
            snakeSet.add(nextPosition);

            foodQueue.remove();
            foodAmount++;
            return foodAmount;

        }

        // add the new pos to the head
        snakeQueue.addFirst(nextPosition);

        // remove the tail from queue and set
        snakeSet.remove(snakeQueue.peekLast());
        snakeQueue.removeLast();
        return foodAmount;
    }

    private boolean snakeDie(String position) {
        String[] curArr = position.split("a");
        int row = Integer.valueOf(curArr[0]);
        int col = Integer.valueOf(curArr[1]);

        // if snake goes out of the boundry
        if (row < 0 || row >= height || col < 0 || col >= width) {
            return true;
        }

        // if snake hits itself, basically new position exist in the set and it is not the tail
        if (snakeSet.contains(position) && !position.equals(snakeQueue.peekLast())) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        int[][] food = new int[2][];
        food[0] = new int[]{1, 2};
        food[1] = new int[]{0, 1};
        SnakeGame obj = new SnakeGame(3, 2, food);
        System.out.println(obj.move("R"));
        System.out.println(obj.move("D"));
        System.out.println(obj.move("R"));
        System.out.println(obj.move("U"));
        System.out.println(obj.move("L"));
        System.out.println(obj.move("U"));


    }
}