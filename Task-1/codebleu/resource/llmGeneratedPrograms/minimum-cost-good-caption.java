class Solution {
    public String minCostGoodCaption(String caption) {
        if (caption.length() < 3) {
            return "";
        }
        char[] arr = caption.toCharArray();
        State[] dp = new State[arr.length];
        State state = go(dp, arr, 0);
        char[] res = new char[arr.length];
        int ix = 0;
        while (ix < arr.length) {
            for (int i = 0; i < state.len; i++) {
                res[ix++] = state.ch;
            }
            if (ix < arr.length) {
                state = dp[ix];
            }
        }
        return new String(res);
    }

    private State go(State[] dp, char[] arr, int ix) {
        if (ix == arr.length) {
            return new State();
        }
        if (ix > arr.length - 3) {
            return null;
        }
        if (dp[ix] != null) {
            return dp[ix];
        }
        State res = null;
        for (int len = 3; len <= 5; len++) {
            if (ix + len > arr.length) {
                continue;
            }
            State curr = min(arr, ix, len);
            State next = go(dp, arr, ix + len);
            if (next != null) {
                curr.count += next.count;
                if (less(dp, curr, res, ix)) {
                    res = curr;
                }
            }
        }
        dp[ix] = res;
        return res;
    }

    private boolean less(State[] dp, State f, State s, int ix) {
        if (s == null) {
            return true;
        }
        if (f.count < s.count) {
            return true;
        }
        if (f.count > s.count) {
            return false;
        }
        int i = 0;
        int j = 0;
        State fState = f;
        State sState = s;
        int fIx = ix;
        int sIx = ix;
        while (true) {
            if (fState.ch != sState.ch) {
                return fState.ch < sState.ch;
            }
            i++;
            j++;
            if (i == fState.len && j == sState.len) {
                fIx += fState.len;
                sIx += sState.len;
                if (fIx >= dp.length || sIx >= dp.length) {
                    return false;
                }
                fState = dp[fIx];
                sState = dp[sIx];
                i = 0;
                j = 0;
            } else if (i == fState.len) {
                fIx += fState.len;
                if (fIx >= dp.length) {
                    return false;
                }
                fState = dp[fIx];
                i = 0;
            } else if (j == sState.len) {
                sIx += sState.len;
                if (sIx >= dp.length) {
                    return false;
                }
                sState = dp[sIx];
                j = 0;
            }
        }
    }

    private State min(char[] arr, int ix, int len) {
        State res = new State();
        res.len = len;
        res.count = 1000000;
        for (char c = 'a'; c <= 'z'; c++) {
            int cost = 0;
            for (int i = 0; i < len; i++) {
                cost += Math.abs(arr[ix + i] - c);
            }
            if (cost < res.count) {
                res.count = cost;
                res.ch = c;
            }
        }
        return res;
    }
}

class State {
    int len;
    char ch;
    int count;
}