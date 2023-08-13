package GroupDAO;

public class GroupList {
    Group newGroup = new Group();

    public Group listGr(int count) {
        if (count == 1) {
            newGroup.setName("Группа Java");
            newGroup.setId_curator(1);
            newGroup.setId(1);
            return newGroup;
        }
        if (count == 2) {
            newGroup.setName("Группа PHP");
            newGroup.setId_curator(3);
            newGroup.setId(2);
            return newGroup;
        }
        if (count == 3) {
            newGroup.setName("Группа SQL");
            newGroup.setId_curator(2);
            newGroup.setId(3);
            return newGroup;
        }
        return null;
    }
}