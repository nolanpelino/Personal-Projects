using System;

namespace ConsoleGame
{
  class Game : SuperGame
  {

    /*
     * UpdateCursor() takes a string representing a key
     * and updates the position of the cursor
     * to be drawn.
     * int x represents the change in x and int y represents the change in y
     */
    public new static void UpdatePosition(string key, out int x, out int y) {
        x = 0;
        y = 0;
      switch (key) {
        case "LeftArrow":
          x = -1;
          y = 0;
          break;
        case "RightArrow":
          x = 1;
          y = 0;
          break;
        case "UpArrow":
          x = 0;
          y = -1;
          break;
        case "DownArrow":
          x = 0;
          y = 1;
          break;
      }
    }

    /*
     * UpdateCursor() takes a string representing a key
     * and updates the symbol of the cursor
     * to be drawn.
     */
     public new static char UpdateCursor(string key) {
       switch (key) {
         case "LeftArrow":
           return '<';
         case "RightArrow":
           return '>';
         case "UpArrow":
           return '^';
         case "DownArrow":
           return 'v';
       }
       return '<';
     }

    /* KeepInBounds is a method that prevents the characer from leaving the game bounds
       and returns an int of the new position. The max coordinate is exclusive.
    */
     public new static int KeepInBounds(int coord, int max) {
      if (coord >= max)
        return max -1;
      else if (coord <= 0)
        return 0;
      else
        return coord;
     }

    public new static bool DidScore(int xc, int yc, int xf, int yf) {
      return (xc == xf) && (yc == yf);
    }
  }
}