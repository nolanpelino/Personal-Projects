public class ElfFile {
    public string name { get; set; }
    public int size { get; set; }

    public static ElfFile parseElf(string input) {
        string[] parts = input.Split(' ');
        return new ElfFile(parts[1], int.Parse(parts[0]));
    }

    public ElfFile(string name, int size) {
        this.name = name;
        this.size = size;
    }

    public static bool isParseable(string input) {
        string[] parts = input.Split(' ');
        return int.TryParse(parts[0], out int _);
    }
}
