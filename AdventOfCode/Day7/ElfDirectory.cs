public class ElfDirectory
{
    public string Name { get; set; }
    public ElfDirectory Parent { get;}
    private List<ElfDirectory> children = new List<ElfDirectory>();

    private List<ElfFile> files = new List<ElfFile>();

    public ElfDirectory(string name, ElfDirectory parent) {
        Name = name;
        Parent = parent;

        if (parent != null) {
            parent.children.Add(this);
        }
    }

    public void addFile(ElfFile file) {
        files.Add(file);
    }

    public void addChild(ElfDirectory child) {
        if (child != null)
            children.Add(child);
    }

    public int size() {
        int size = 0;
        foreach (ElfFile file in files) {
            size += file.size;
        }
        foreach (ElfDirectory child in children) {
            size += child.size();
        }
        return size;
    }

    public static ElfDirectory parseElf(string input, ElfDirectory parent) {
        string[] parts = input.Split(' ');
        return new ElfDirectory(parts[1], parent);
    }

    public ElfDirectory findChild(string name) {
        foreach (ElfDirectory child in children) {
            if (child.Name == name) {
                return child;
            }
        }
        return null;
    }

    public static bool isParseable(string input) {
        string[] parts = input.Split(' ');
        return parts[0].StartsWith("dir");
    }
}