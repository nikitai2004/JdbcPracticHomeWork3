package curatorDAO;

public class CuratorList {
    Curator newCurator = new Curator();

    public Curator listCur(int count) {
        if (count == 1) {
            newCurator.setFio("Ковалев Алексей");
            newCurator.setId(1);
            return newCurator;
        }
        if (count == 2) {
            newCurator.setFio("Фролов  Дмитрий");
            newCurator.setId(2);
            return newCurator;
        }
        if (count == 3) {
            newCurator.setFio("Ефимов  Евгений");
            newCurator.setId(3);
            return newCurator;
        }
        if (count == 4) {
            newCurator.setFio("Ларин   Николай");
            newCurator.setId(4);
            return newCurator;
        }
        return null;
    }
}