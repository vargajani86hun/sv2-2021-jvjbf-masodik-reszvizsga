package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            humans = getHumansFromStringList(lines);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }

    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, convertHumansToString(getMales()));
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Unable to create file!", ioe);
        }
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }

    private List<Human> getHumansFromStringList(List<String> lines) {
        List<Human> results = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(";");
            results.add(new Human(values[0], values[1]));
        }
        return results;
    }

    private List<Human> getMales() {
        List<Human> results = new ArrayList<>();
        for (Human actual : humans) {
            switch (actual.getIdentityNumber().toCharArray()[0]) {
                case '1':
                case '3':
                    results.add(actual);
            }
        }
        return results;
    }

    private List<String> convertHumansToString(List<Human> people) {
        List<String> results = new ArrayList<>();
        for (Human human : people) {
            results.add(human.getName() + ";" + human.getIdentityNumber());
        }
        return results;
    }
}
