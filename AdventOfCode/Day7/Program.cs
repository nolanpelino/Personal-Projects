
class Program
{

    public static void Main(string[] args)
    {
        ElfDirectory root = readFile(File.ReadAllLines("input.txt"));

    }


    public static ElfDirectory cdAction(ElfDirectory current, string line) {
        string[] parts = line.Split(' ');
        if (parts[1] == "..") {
            return current.Parent;
        } else if (parts[1] == "/" && current.Name == "/") {
            return current;
        } else {
            return current.findChild(parts[1]!);
        }
    }


    static ElfDirectory readFile(string[] lines) {
        ElfDirectory root = new ElfDirectory("/", null!);
        ElfDirectory current = root;
        List<int> largest = new List<int>();

        foreach (string line in lines) {
            if(ElfFile.isParseable(line)) {
                current.addFile(ElfFile.parseElf(line));
            } else if (ElfDirectory.isParseable(line)) {
                current = ElfDirectory.parseElf(line, current);
            } else if (line.StartsWith("$ cd")) {
                if(current.size() <= 10000) {
                    largest.Add(current.size());
                }
              current = cdAction(current, line); 
            }
        }
        return root;
    }

}