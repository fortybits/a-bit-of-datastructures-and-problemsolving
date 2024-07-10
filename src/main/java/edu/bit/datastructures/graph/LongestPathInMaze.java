package edu.bit.datastructures.graph;

/**
 * Write a program that takes a map of a maze as input and outputs the length of the longest path
 * from the top to the bottom.
 * <p>
 * Conditions and constraints:
 * - The map is a two-dimensional, rectangular board.
 * - You can only visit each cell once.
 * - You are not allowed to go up, only left, right or down.
 * - You can start on any cell at the top row that is not a wall.
 * - You can exit on any cell at the bottom row that is not a wall.
 * <p>
 * Examples: (“.” is empty space, “#" is a wall)
 * <p>
 * INPUT_1 = tuple([
 * "..",
 * ".."])
 * EXPECTED_1 = 4
 * <p>
 * INPUT_2 = tuple([
 * "#...X#",
 * "#.#..#",
 * "#.##.#",
 * "#..#.#",
 * "#..#.#",
 * "#..#.#",
 * EXPECTED_2= 12?
 * <p>
 * size constraints 1000 x 1000. (minimum: 2x2)
 */
public class LongestPathInMaze {

    // longest path in a graph, [sources row=1, destinations row = n]
    // edges here formed could be from one node to each of its adjacent 'directions' without a wall

    // int longestPathInMaze( char [][] input) {
    //  convertedToGraph();
    //  int result = 0;
    //  for(Node src: row1)
    //    for(Node dest: rowN)
    //      if(src == empty && dest == empty)
    //        result = Math.max(result, longestPath(Node src, Node dst));
    //}

    // int longestPath(Node src, Node dst) {
    //   Queue<Node> queue;
    //   queue.offer(src);
    //
    //   int step = 0;
    //   while(!queue.empty()){
    //     Node currentNode = queue.poll();
    //     currentNode.isVisited = true;
    //     List<Node> adjacents = currentNode.getAdjacents(); // could only be empty spaces
    //     if(adjacents.isEmpty()){
    //     }
    //     else {
    //      for(Node adj: adjacents) {
    //        if(adj == dst) return step;
    //        if(!adj.isVisited)
    //          queue.offer(adj);
    //      }
    //      step++;
    //     }
    //   }
    //   return step;
    // }

    // "#...X#",
    //"#.#..#",
    //"#.##.#",
    //"#..#.#", <--- (X+1, Y+1, Z+1+1)
    //------
    //"XYZ#.#",
    //"#..#.#",
    //
    // step[N][i] = Max(step[N-1][i]+1, step[N-1][i-1]+2, step[N-1][i+1]+2)
}
