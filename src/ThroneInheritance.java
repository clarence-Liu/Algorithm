import java.util.*;

public class ThroneInheritance {
    private static Map<String, List<String>> edges;
    private static String king;
    private static Set<String> dead;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String operate = scanner.nextLine().replace("\"","").replace(" ","");
        operate = operate.substring(1, operate.length() - 1);
        String[] operates = operate.split(",");
        for (String s : operates) {
            System.out.println(s);
        }
        String nameString = scanner.nextLine();
        ThroneInheritance object = new ThroneInheritance("");
        object.birth("","");
        object.death("");
        List<String> result = object.getInheritanceOrder();
        for (String s : result) {
            System.out.println(s);
        }
    }

    public ThroneInheritance(String kingName) {
        king = kingName;
        edges = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth (String parentName, String childName) {
        List<String> children = edges.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        edges.put(parentName, children);
    }

    public void death (String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        preorder(king, result);
        return result;
    }

    public void preorder(String name, List<String> result) {
        if (!dead.contains(name)) {
            result.add(name);
        }
        List<String> children = edges.getOrDefault(name, new ArrayList<>());
        for (String s : children) {
            preorder(s, result);
        }
    }
}
