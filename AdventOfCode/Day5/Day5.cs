namespace Day5;
using System;
using System.Collections.Generic;

public class Day5 {

    public void readFile(string fileName) {
        var lines = File.ReadAllLines(fileName);
        foreach (var line in lines) {
            Console.WriteLine(line);
        }
    }

    static void main(string[] args) {
        var day5 = new Day5();
        day5.readFile("input.txt");
    }
}