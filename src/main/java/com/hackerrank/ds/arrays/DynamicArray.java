/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.hackerrank.ds.arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 29/05/16
 * Version : v1
 */

/**
 * https://www.hackerrank.com/challenges/dynamic-array
 */
public class DynamicArray {


    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;


    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();

    }

    private static void solve() throws IOException {


        int N = nextInt();
        @SuppressWarnings("unchecked")
        List<Integer>[] seqList = new List[N];
        for (int i = 0; i < N; i++) {
            seqList[i] = new ArrayList<>();
        }
        int Q = nextInt();
        int lastAns = 0;
        for (int q = 0; q < Q; q++) {

            int i = nextInt();
            int index = (nextInt() ^ lastAns) % N;
            if (i == 1) {
                seqList[index].add(nextInt());
            }
            if (i == 2) {
                int y = nextInt() % seqList[index].size();
                lastAns = seqList[index].get(y);
                pw.println(lastAns);
            }
        }

    }
}
