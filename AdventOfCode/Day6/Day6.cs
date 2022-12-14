namespace Day6;
using System;
using System.Collections.Generic;

public class Day6 {

    public void readFile(string fileName) {
        string all = File.ReadAllText(fileName);
        for (int i = 0; i < all.Length - 4; i++) {
            if (all.Substring(i, 4).Distinct().Count() == 4) {
                Console.WriteLine(i + 4);
                break;
            }
        }
    }

    public void readFile2(string fileName) {
        string all = File.ReadAllText(fileName);
        for (int i = 0; i < all.Length - 14; i++) {
            if (all.Substring(i, 14).Distinct().Count() == 14) {
                Console.WriteLine(i + 14);
                break;
            }
        }
    }
}