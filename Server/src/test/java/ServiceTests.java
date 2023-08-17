import org.example.collectionLogicModule.entity.*;
import org.example.collectionLogicModule.service.MusicBandService;
import org.example.collectionLogicModule.util.Exception.CollectionEmptyException;
import org.example.collectionLogicModule.util.MusicBandComparator;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.PriorityQueue;

public class ServiceTests {
    private static MusicBandService service = new MusicBandService();
    private static PriorityQueue<MusicBand> musicBandStorage = new PriorityQueue<>(new MusicBandComparator());

    @BeforeAll
    public static void SetUp() {
        Coordinates coordinates = new Coordinates(1, 1l);
        Location location = new Location(1f, 1, 1, "a");
        Person person1 = new Person("B", 1f, 1f, "111111", location);
        Person person2 = new Person("D", 1f, 1f, "222222", location);
        Person person3 = new Person("F", 1f, 1f, "333333", location);
        MusicBand musicBand1 = new MusicBand("B", coordinates, 1l, MusicGenre.JAZZ, person1);
        MusicBand musicBand2 = new MusicBand("D", coordinates, 1l, MusicGenre.BLUES, person2);
        MusicBand musicBand3 = new MusicBand("F", coordinates, 1l, MusicGenre.PSYCHEDELIC_CLOUD_RAP, person3);
        musicBand1.setCreationDate(LocalDateTime.now());
        musicBand2.setCreationDate(LocalDateTime.now());
        musicBand3.setCreationDate(LocalDateTime.now());
        musicBand1.setId(0);
        musicBand2.setId(1);
        musicBand3.setId(2);
        musicBandStorage.add(musicBand3);
        musicBandStorage.add(musicBand1);
        musicBandStorage.add(musicBand2);
    }

    @BeforeEach
    public void SetUpThis() {
        service.setMusicBandStorage(musicBandStorage);
    }

    @Test
    public void add_successfullyAdd() {
        Coordinates coordinates = new Coordinates(1, 2L);
        Location location = new Location(1f, 2, 3, "a");
        Person person = new Person("o", 1f, 1f, "333333", location);
        MusicBand musicBandToAdd = new MusicBand("k", coordinates, 3l, MusicGenre.JAZZ, person);
        service.add(musicBandToAdd);
        MusicBand foundMusicBand = service.getAllMusicBands()
                .stream()
                .filter(musicBand -> musicBand.equals(musicBandToAdd))
                .findFirst()
                .orElse(null);
        Assertions.assertNotNull(foundMusicBand);
    }

    @Test
    public void removeHead_successfullyRemoveHead() {
        MusicBand firstMusicBand = service.getAllMusicBands().stream().filter(musicBand -> musicBand.getName().equals("B"))
                .findFirst()
                .orElse(null);
        MusicBand removedMusicBand;
        try {
            removedMusicBand = service.removeHead();
        } catch (CollectionEmptyException e) {
            removedMusicBand = new MusicBand();
        }
        Assertions.assertEquals(firstMusicBand, removedMusicBand);
    }

    @Test
    public void updateById_successfullyUpdateById() {
        Coordinates coordinates = new Coordinates(1, 2L);
        Location location = new Location(1f, 2, 3, "a");
        Person person = new Person("o", 1f, 1f, "333333", location);
        MusicBand musicBandToUpdate = new MusicBand("k", coordinates, 3l, MusicGenre.JAZZ, person);
        int id = 0;
        service.updateById(id, musicBandToUpdate);
        MusicBand updatedMusicBand = service.getAllMusicBands()
                .stream()
                .filter(musicBand -> musicBand.getId() == id)
                .findFirst()
                .orElse(null);
        musicBandToUpdate.setId(id);
        musicBandToUpdate.setCreationDate(updatedMusicBand.getCreationDate());
        Assertions.assertEquals(musicBandToUpdate, updatedMusicBand);
    }

    @Test
    public void filterLessThanFrontman_successfulyFilter() {
        Location location = new Location(1f, 2, 3, "a");
        Person personSingleBandOutput = new Person("C", 1f, 1f, "333333", location);
        List<MusicBand> singleMusicBandExpectedList = service.filterLessThanFrontMan(personSingleBandOutput);
        Assertions.assertEquals(1, singleMusicBandExpectedList.size());
        List<MusicBand> allMusicBands = service.getAllMusicBands();
        MusicBand singleBandExpectedOutput = allMusicBands
                .stream()
                .filter(musicBand -> musicBand.getFrontMan().compareTo(personSingleBandOutput) < 0)
                .findFirst()
                .orElse(new MusicBand());
        Assertions.assertEquals(singleBandExpectedOutput, singleMusicBandExpectedList.get(0));
        Person personAllBandsOutput = new Person("z", 1f, 1f, "333333", location);
        List<MusicBand> allMusicBandExpectedList = service.filterLessThanFrontMan(personAllBandsOutput);
        Assertions.assertEquals(allMusicBands.size(), allMusicBandExpectedList.size());
        Assertions.assertEquals(allMusicBands, allMusicBandExpectedList);
    }
    @Test
    public void removeById_successfullyRemoveById() {
        MusicBand musicBandToRemove = service.getAllMusicBands()
                .stream()
                .filter(musicBand -> musicBand.getId() == 1)
                .findFirst()
                .orElse(null);
        service.removeById(1);
        Assertions.assertFalse(service.getAllMusicBands().contains(musicBandToRemove));
    }
    @AfterEach
    public void tearDownThis(){
        musicBandStorage.clear();
        Coordinates coordinates = new Coordinates(1, 1l);
        Location location = new Location(1f, 1, 1, "a");
        Person person1 = new Person("B", 1f, 1f, "111111", location);
        Person person2 = new Person("D", 1f, 1f, "222222", location);
        Person person3 = new Person("F", 1f, 1f, "333333", location);
        MusicBand musicBand1 = new MusicBand("B", coordinates, 1l, MusicGenre.JAZZ, person1);
        MusicBand musicBand2 = new MusicBand("D", coordinates, 1l, MusicGenre.BLUES, person2);
        MusicBand musicBand3 = new MusicBand("F", coordinates, 1l, MusicGenre.PSYCHEDELIC_CLOUD_RAP, person3);
        musicBand1.setCreationDate(LocalDateTime.now());
        musicBand2.setCreationDate(LocalDateTime.now());
        musicBand3.setCreationDate(LocalDateTime.now());
        musicBand1.setId(0);
        musicBand2.setId(1);
        musicBand3.setId(2);
        musicBandStorage.add(musicBand3);
        musicBandStorage.add(musicBand1);
        musicBandStorage.add(musicBand2);
    }

}
