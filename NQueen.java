class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> positiveDiagonal = new HashSet<>();
    Set<Integer> negativeDiagonal = new HashSet<>();

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(char[] row : board){
            Arrays.fill(row,'.');
        }

        backtrack(0, n, board);
        return res;    
    }

    private void backtrack(int r, int n, char[][] board){
        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c=0; c<n; c++){
            if(col.contains(c) || positiveDiagonal.contains(r+c) || negativeDiagonal.contains(r-c)){
                continue;
            }

            col.add(c);
            positiveDiagonal.add(r+c);
            negativeDiagonal.add(r-c);
            board[r][c] = 'Q';

            backtrack(r+1, n, board);

            col.remove(c);
            positiveDiagonal.remove(r+c);
            negativeDiagonal.remove(r-c);
            board[r][c] = '.';
        }
    }
}
